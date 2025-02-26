package com.nagarro.Note_Maker_Backend.controller;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.Note_Maker_Backend.entity.User;
import com.nagarro.Note_Maker_Backend.servicesimpl.UserDetailsServiceImpl;
import com.nagarro.Note_Maker_Backend.servicesimpl.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@RestController
@CrossOrigin("*")
public class UserController {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private UserDetailsServiceImpl detailsServiceImpl;
	
	@PostMapping("/user/register")
	@CrossOrigin("*")
	public User register(@RequestBody User user) throws Exception {
		try {
			// Encode the password
			user.setPassword(this.passwordEncoder.encode(user.getPassword())); //It is responsible for encoding the user's password before storing it in the database.
			
			return this.userService.createUser(user);
		} catch (Exception e) {
			throw new Exception("User with email " + user.getEmail() + " already exists!!");
		}
	}
	
	@GetMapping("/current-user")
	@CrossOrigin("*")
	public User getCurrentUser(Principal principal) {
		System.out.println(principal.getName());
		return ((User) this.detailsServiceImpl.loadUserByUsername(principal.getName()));
	}
	
}
