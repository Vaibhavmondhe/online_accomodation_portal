package com.portal.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.dto.LoginDto;
import com.portal.dto.UserDTO;
import com.portal.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = { "*" })
public class HomeController {

	@Autowired
	private UserService userService;

	public HomeController() {
		System.out.println("in a cotr " + getClass());
	}

	// Adding new user
	// http://localhost:7070/user/signup
	// method= post
	@PostMapping("/register")
	public ResponseEntity<?> addUser(@RequestBody @Valid UserDTO dto) {
		System.out.println("in add user " + dto.getRole());

		return ResponseEntity.status(HttpStatus.CREATED).body(userService.addNewUser(dto));
	}

	@PostMapping("/login")
	public ResponseEntity<?> signInEmployee(@RequestBody @Valid LoginDto request) {
		System.out.println("auth req " + request);

		return ResponseEntity.status(HttpStatus.OK).body(userService.Signin(request));
	}
}
