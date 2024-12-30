package com.portal.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portal.exception.ResourceNotFoundException;

import com.portal.dao.OTPRepository;
import com.portal.dao.UserDao;
import com.portal.dto.ApiResponse;
import com.portal.dto.ApprovedDTO;
import com.portal.dto.EditPassDTO;
import com.portal.dto.EditPasswordDTO;
import com.portal.dto.LoginDto;
import com.portal.dto.OTPDTO;
import com.portal.dto.OTPVerificationDTO;
import com.portal.dto.PropertyResponseDto;
import com.portal.dto.SigninRequest;

import com.portal.dto.Signup;
import com.portal.dto.UserDTO;
import com.portal.dto.UserResponseDto;
import com.portal.dto.UserUpdateDTO;

import com.portal.entities.OTP;

import com.portal.entities.Status;
import com.portal.entities.User;
import com.portal.entities.UserRole;
import com.portal.exception.CustomException;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userdao;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private PasswordEncoder encoder;

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	private OTPRepository otpRepo;

	public UserServiceImpl() {
		System.out.println("in a cotr " + getClass());
	}

	// add new user
	@Override
	public UserDTO addNewUser(UserDTO dto) {

		// if (dto.getPassword().equals(dto.getConfirmPassword())) {
		User user = mapper.map(dto, User.class);

		System.out.println("in add service " + user.getRole());
		userdao.save(user);
		return mapper.map(user, UserDTO.class);
		// }
		// throw new ApiException("Password Invalid Try Again ");
	}

	// update user
	@Override
	public UserUpdateDTO updateUserDetails(UserUpdateDTO user) {
		User user2 = userdao.findById(user.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Id or Not yet assigned "));

		mapper.map(user, user2);

		userdao.save(user2);

		return mapper.map(user2, UserUpdateDTO.class);
	}

	// get user by id;
	@Override
	public UserDTO getById(Long id) {
		User user = userdao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid Id"));
		return mapper.map(user, UserDTO.class);
	}

	// sign in /login
	@Override
	public ApiResponse Signin(LoginDto req) {
		User user = userdao.findByEmailAndPassword(req.getEmail(), req.getPassword())
				.orElseThrow(() -> new ResourceNotFoundException("invalid email or Password....!"));
		System.out.println(user);
		mapper.map(user, LoginDto.class);
		return new ApiResponse("Successfuly Loged In");
	}

	// change password
	@Override
	public String editCustomerPassword(EditPasswordDTO pass) {

		User cust = userdao.findById(pass.getId()).orElseThrow(() -> new ResourceNotFoundException("Invalid User Id"));
		if (cust.getPassword().equals(pass.getOldpassword())) {
			cust.setPassword(pass.getNewpaasword());
			return "Password changed successfully";
		}
		return "Invalid email or old password";
	}

	@Override
	public void removeUserById(Long userId) {
		User user = userdao.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Invalid id"));
		userdao.delete(user);
	}

	@Override
	public List<UserDTO> getAllUsers() {

		List<User> usersList = userdao.findAll();

		List<UserDTO> userDTOList = new ArrayList<UserDTO>();

		userDTOList = Arrays.asList(mapper.map(usersList, UserDTO[].class));

		return userDTOList;
	}

	@Override
	public List<UserDTO> showPendingList() {

		List<UserDTO> userDTOList = new ArrayList<UserDTO>();

		List<User> list = userdao.findByStatus(Status.PENDING);

		userDTOList = Arrays.asList(mapper.map(list, UserDTO[].class));

		return userDTOList;
	}

	@Override
	public List<UserDTO> showApprovedList() {
		List<UserDTO> userDTOList = new ArrayList<UserDTO>();

		List<User> list = userdao.findByStatus(Status.APPROVED);

		userDTOList = Arrays.asList(mapper.map(list, UserDTO[].class));

		return userDTOList;
	}

	@Override
	public List<UserDTO> showRejectedList() {
		List<UserDTO> userDTOList = new ArrayList<UserDTO>();

		List<User> list = userdao.findByStatus(Status.REJECTED);

		userDTOList = Arrays.asList(mapper.map(list, UserDTO[].class));

		return userDTOList;
	}

	@Override
	public UserResponseDto verifyRoleTOApprove(ApprovedDTO approveddto) {

		System.out.println("inverify role service " + approveddto.getId() + approveddto.getStatus());
		User user = userdao.findById(approveddto.getId())
				.orElseThrow(() -> new CustomException("Invalid Id Plz Try Again"));
		user.setRole(approveddto.getRole());
		user.setStatus(approveddto.getStatus());

		userdao.save(user);

		return mapper.map(user, UserResponseDto.class);
	}

	// jwt
	@Override
	public Signup userRegistration(Signup reqDTO) {
		// dto --> entity
		User user = mapper.map(reqDTO, User.class);
		user.setPassword(encoder.encode(user.getPassword()));// pwd : encrypted using SHA
		userdao.save(user);
		return mapper.map(user, Signup.class);
	}

	@Override
	public List<UserDTO> getAllOwners() {
		List<User> ownersList = userdao.findByRole(UserRole.ROLE_OWNER);
		List<UserDTO> ownersRespList = ownersList.stream().map(user -> mapper.map(user, UserDTO.class))
				.collect(Collectors.toList());
		return ownersRespList;
	}

	@Override
	public List<UserDTO> getAllCustomers() {
		List<User> customersList = userdao.findByRole(UserRole.ROLE_CUSTOMER);
		List<UserDTO> customersRespList = customersList.stream().map(user -> mapper.map(user, UserDTO.class))
				.collect(Collectors.toList());
		return customersRespList;
	}

	@Override
	public User getUserByEmail(SigninRequest reqDTO) {
		
		User user = userdao.findByEmail(reqDTO.getEmail());
		//if(user.getStatus()!=Status.PENDING)
		return user;
	}

	// ------------------------------------------------

	private String generateOTP() {
		int otpLength = 6;
		String numbers = "0123456789";
		StringBuilder otp = new StringBuilder();

		for (int i = 0; i < otpLength; i++) {
			int index = (int) (Math.random() * numbers.length());
			otp.append(numbers.charAt(index));
		}

		return otp.toString();
	}

	private void sendOTPEmail(String email, String otp) {

		MimeMessage message = javaMailSender.createMimeMessage();

		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setTo(email);
			helper.setSubject("OTP Verification");
			helper.setText("Your OTP for registration is: " + otp);
			javaMailSender.send(message);
		} catch (MessagingException e) {
			// Handle exception
		}
	}

	OTP otpobj = new OTP();
	OTPDTO userObj = new OTPDTO();

	@Override
	public void getotpForForgotPass(String emailId) {
		OTP dbotp = new OTP();
    
		User cust = userdao.findByEmail(emailId);// .orElseThrow(() -> new ResourceNotFoundException("Invalid id"));

		System.out.println("-------" + cust.toString());

		userObj.setEmail(emailId);
		if (cust.getEmail() != null) {
			String otp = generateOTP();
			sendOTPEmail(emailId, otp);
			otpobj.setEmail(emailId);
			otpobj.setOtp(otp);
			dbotp.setOtp(otp);
			dbotp.setEmail(emailId);
			// dao.saveAll(dbotp);
			otpRepo.save(dbotp);
		} else if (cust.getEmail() == null && cust != null)
			throw new ResourceNotFoundException("User Does not exist from userServiceImpl Class");
	}

	@Override
	public boolean verifyOTP(OTPVerificationDTO otpVerificationDTO) {

		OTP storedOTP = otpRepo.findByEmail(otpVerificationDTO.getEmail());
		System.out.println("in service=====>" + storedOTP.getOtp() + storedOTP.getEmail());

		if (storedOTP != null && storedOTP.getOtp().equals(otpVerificationDTO.getOtp())) {

			return true;

		}
		return false;
	}

	@Override
	public boolean forgotchangePassword(EditPassDTO changePasswordDTO) {

		System.out.println(changePasswordDTO.getEmail());

		User user = userdao.findByEmail(changePasswordDTO.getEmail());
		// .orElseThrow(() -> new ResourceNotFoundException("Invalid Emailid"));
		if (user != null && user.getEmail().equals(changePasswordDTO.getEmail())) {
			// user.setPassword(changePasswordDTO.getNewPassword());

			user.setPassword(encoder.encode(changePasswordDTO.getNewPassword()));

			userdao.save(user);
			return true;
		}
		return false;
	}
}
