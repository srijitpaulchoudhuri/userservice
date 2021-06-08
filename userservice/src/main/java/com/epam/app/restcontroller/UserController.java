package com.epam.app.restcontroller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.epam.app.dto.UserDTO;
import com.epam.app.model.User;
import com.epam.app.service.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<User> add(@RequestBody UserDTO userDto){
		return new ResponseEntity<>(userService.register(userDto),HttpStatus.CREATED);
	}
	@GetMapping
	public ResponseEntity<List<User>> getAll(){
		return new ResponseEntity<>(userService.getAll(),HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<User> get(@PathVariable int id){
		return new ResponseEntity<>(userService.get(id),HttpStatus.OK);
	}
	@PutMapping("/{id}")
	public ResponseEntity<User> update(@RequestBody UserDTO userDto,@PathVariable int id){
		return new ResponseEntity<>(userService.update(userDto, id),HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable int id){
		userService.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
