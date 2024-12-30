package com.portal.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.portal.dto.AddCityDTO;
import com.portal.dto.AddPropertyDto;
import com.portal.dto.ApiResponse;
import com.portal.dto.ApprovedDTO;
import com.portal.dto.CitiesDTO;
import com.portal.dto.PropertyResponseDto;
import com.portal.dto.UserDTO;
import com.portal.dto.UserResponseDto;
import com.portal.service.CityService;
import com.portal.service.PropertyService;
import com.portal.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserService userService;

	@Autowired
	private CityService cityService;

	@Autowired
	private PropertyService propertyService;

	public AdminController() {
		System.out.println("in a cotr " + getClass());
	}

	@GetMapping("/pending")
	public List<UserDTO> pendingList() {
		return userService.showPendingList();
	}

	@GetMapping("/approved")
	public List<UserDTO> approvedList() {
		return userService.showApprovedList();
	}

	@GetMapping("/rejected")
	public List<UserDTO> rejectedList() {
		return userService.showRejectedList();
	}

	@PutMapping("/role/approved")
	public UserResponseDto verifyRole(@RequestBody ApprovedDTO approveddto) {
		return userService.verifyRoleTOApprove(approveddto);
	}

	// http://localhost:7070/admin/propertylist
	// show all properties to admin
	@GetMapping("/propertylist")
	public List<PropertyResponseDto> listAllProperties() {

		return propertyService.listAllProperties();
	}

	// delete user
	// http://localhost:7070/admin/user/delete/id

	@DeleteMapping("/users/delete/{userId}")
	public ResponseEntity<?> removeUser(@PathVariable Long userId) {
		userService.removeUserById(userId);
		return ResponseEntity.noContent().build();
	}

	// http://localhost:7070/admin/users/owners
	@GetMapping("/users/owners")
	public List<UserDTO> getAllOwners() {
		return userService.getAllOwners();
	}

	// http://localhost:7070/admin/users/customers
	@GetMapping("/users/customers")
	public List<UserDTO> getAllCustomers() {
		return userService.getAllCustomers();
	}

	// http://localhost:7070/admin/user
	// get All users
	@GetMapping("/users")
	public List<UserDTO> getAllUsers() {
		return userService.getAllUsers();
	}

	// add city
	// http://localhost:7070/admin/addcity

	@PostMapping("/addcity")
	ResponseEntity<ApiResponse> addCity(@RequestBody AddCityDTO citydto) {

		return ResponseEntity.status(HttpStatus.CREATED).body(cityService.addNewCity(citydto));
	}

	// http://localhost:7070/admin/edit
	@PutMapping("/editcity")
	public CitiesDTO updateCity(@RequestBody CitiesDTO citydto) {
		return cityService.updateCity(citydto);
	}
}
