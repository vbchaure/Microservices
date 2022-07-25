package com.example.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.UserService.Repository.*;
import com.example.model.User;

@Service
public class UserService {
	@Autowired
	private UserRepository repo;
	public List<User> listAll() {
		return repo.findAll();
	}

	public void save(User acc) {
		repo.save(acc);
	}

	public User get(int id) {
		return repo.findById(id).get();
	}

	public void delete(int id) {
		repo.deleteById(id);
	}
}


