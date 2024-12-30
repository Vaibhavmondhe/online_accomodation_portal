package com.portal.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.dto.EditPassDTO;
import com.portal.dto.EditPasswordDTO;
import com.portal.dto.ForgetPassOtpDTO;
import com.portal.dto.OTPVerificationDTO;
import com.portal.dto.UserDTO;
import com.portal.dto.UserUpdateDTO;

import com.portal.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = { "*" })
public class UserController {

	@Autowired
	private UserService userService;

	public UserController() {
		System.out.println("in a user cotr " + getClass());
	}

	// Adding new user
	// http://localhost:7070/user/register
	// method= post
	@PostMapping("/register")
	public ResponseEntity<?> addUser(@RequestBody @Valid UserDTO dto) {
		System.out.println("in add user " + dto.getFirstName());

		return ResponseEntity.status(HttpStatus.CREATED).body(userService.addNewUser(dto));
	}

	// Update user
	// http://localhoast:7070/user/edit
	@PutMapping("/edit")
	public ResponseEntity<?> updateUser(@RequestBody @Valid UserUpdateDTO user) {
		return ResponseEntity.ok(userService.updateUserDetails(user));
	}

	// to get specific user
	// http://localhoast:7070/user/{id}
	@GetMapping("/{id}")
	public UserDTO getById(@PathVariable Long id) {
		System.out.println("in listUsers");
		return userService.getById(id);
	}

	// change password
	// http://localhoast:7070/user/password
	@PutMapping("/password")
	public ResponseEntity<?> changePassword(@RequestBody EditPasswordDTO password) {
		System.out.println("hi" + password.getNewpaasword());
		return ResponseEntity.status(HttpStatus.OK).body(userService.editCustomerPassword(password));
	}

	// Forgot password send otp
	@PostMapping("/getotpforforgotpass")
	public ResponseEntity<String> getOtpForForgotPass(@RequestBody ForgetPassOtpDTO emailId) {
		System.out.println(emailId);
		String email = emailId.getEmail();
		System.out.println(email);
		userService.getotpForForgotPass(email);
		return ResponseEntity.ok("OTP sent for verification.");
	}

	@PostMapping("/verifyotpforforgot")
	public ResponseEntity<?> verifyOTPForForgotPass(@RequestBody OTPVerificationDTO otpVerificationDTO) {
		System.out.println(otpVerificationDTO);
		boolean isVerified = userService.verifyOTP(otpVerificationDTO);

		try {

			if (isVerified) {

				return ResponseEntity.ok("OTP Verification is Successful");
			} else {
				return ResponseEntity.badRequest().body("OTP verification failed.");
			}

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("error occured during OTP verififcation");
		}

	}

	@PostMapping("/storenewpass")
	public ResponseEntity<?> storeNewPass(@RequestBody EditPassDTO editpassword) {
		boolean isPasswordChanged = userService.forgotchangePassword(editpassword);

		if (isPasswordChanged) {
			return ResponseEntity.ok("Password changed successfully");
		} else {
			return ResponseEntity.badRequest().body("Password change failed");
		}
	}

}
