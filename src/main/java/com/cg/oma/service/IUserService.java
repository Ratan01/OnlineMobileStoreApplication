package com.cg.oma.service;

import java.util.List;

import com.cg.oma.entities.User;
import com.cg.oma.exception.UserNotFoundException;

public interface IUserService {
	public String addUser(User user);
	public String updateUser(User user) throws UserNotFoundException;
	public String removeUser(String user) throws UserNotFoundException;
	public List<User> showAllUsers();
	public boolean validateUser(User user) throws UserNotFoundException;
	
}
