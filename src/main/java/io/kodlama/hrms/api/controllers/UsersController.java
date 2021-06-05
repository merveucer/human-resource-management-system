package io.kodlama.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.kodlama.hrms.business.abstracts.UserService;
import io.kodlama.hrms.core.utilities.results.DataResult;
import io.kodlama.hrms.entities.concretes.User;

@RestController
@RequestMapping("/api/users")
public class UsersController {
	
	private UserService userService;
	
	@Autowired
	public UsersController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<User>> getAll() {
		return userService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<User> getById(@RequestParam int id) {
		return userService.getById(id);
	}
	
	@GetMapping("/getByEmail")
	public DataResult<User> getByEmail(@RequestParam String email) {
		return userService.getByEmail(email);
	}

}
