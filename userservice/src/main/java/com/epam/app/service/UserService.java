package com.epam.app.service;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;

import com.epam.app.customexception.UserNotFoundException;
import com.epam.app.dto.UserDTO;
import com.epam.app.model.User;

public interface UserService {

	public User register(UserDTO userDto);
	public List<User> getAll();
	public User get(int id)throws UserNotFoundException;
	public User update(UserDTO userDto,int id)throws UserNotFoundException;
	public void delete(int id)throws EmptyResultDataAccessException;
}
