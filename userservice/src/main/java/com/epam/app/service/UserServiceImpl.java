package com.epam.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.epam.app.customexception.UserNotFoundException;
import com.epam.app.dto.UserDTO;
import com.epam.app.model.User;
import com.epam.app.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User register(UserDTO userDto) {
		return userRepository.save(new User(userDto.getName(), userDto.getUsername(), userDto.getPassword()));
	}

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public User get(int id)throws UserNotFoundException {
		return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
	}

	@Override
	public User update(UserDTO userDto, int id)throws UserNotFoundException {
		User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
		user.setName(userDto.getName());
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		return userRepository.save(user);
	}

	@Override
	public void delete(int id) throws EmptyResultDataAccessException{
		userRepository.deleteById(id);
		
	}
	

}
