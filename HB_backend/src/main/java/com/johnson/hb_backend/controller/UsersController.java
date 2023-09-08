package com.johnson.hb_backend.controller;

import com.johnson.hb_backend.model.UsersEntity;
import com.johnson.hb_backend.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

	private final UsersService usersService;

	@Autowired
	public UsersController(UsersService usersService) {
		this.usersService = usersService;
	}

	@GetMapping("/all")
	public List<UsersEntity> getAllUser() {
		return usersService.getAllUsers();
	}
}
