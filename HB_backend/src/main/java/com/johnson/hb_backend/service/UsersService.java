package com.johnson.hb_backend.service;

import com.johnson.hb_backend.model.UsersEntity;
import com.johnson.hb_backend.repository.UsersEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

	private final UsersEntityRepository usersEntityRepository;

	@Autowired
	public UsersService(UsersEntityRepository usersEntityRepository) {
		this.usersEntityRepository = usersEntityRepository;
	}

	public List<UsersEntity> getAllUsers() {
		return usersEntityRepository.findAll();
	}
}
