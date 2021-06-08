package com.epam.app.customexception;

public class UserNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "User with this id is not found";
	}
	
	
	

}
