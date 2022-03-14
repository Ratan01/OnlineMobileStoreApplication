package com.cg.oma.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oma.entities.User;
import com.cg.oma.exception.UserNotFoundException;
import com.cg.oma.repository.IUserRepository;
import com.cg.oma.utility.GlobalResources;
@Transactional
@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
	private IUserRepository repository;
    private Logger logger=GlobalResources.getLogger(UserServiceImpl.class);
    
    /*
     * Implementation for adding user
     */
	@Override
	public String addUser(User user) {
		String methodName="addUser()";
		logger.info(methodName+"Called");
		User result=repository.save(user);
		if(result!=null) {
		return "User is added";
		}
		else {
		return "Some Problem In Insertion ";
		}
		}
		
	/*
     * Implementation for updating user
     */
	@Override
	public String updateUser(User User)  {
		String methodName="updateUser()";
		logger.info(methodName+"Called");
		User result=repository.save(User);
		if(result!=null) {
		return "Updated User Successfully";
		}
		else {
		return "Some Problem In updation";
		}
		
	}

	/*
     * Implementation for deleting user
     */
	@Override
	public String removeUser(String userName) throws UserNotFoundException {
		String methodName="removeUser()";
		logger.info(methodName+"Called");
		Optional <User>op= repository.findByUserName(userName);
		if(op.isPresent()) {
		repository.deleteByUserName(userName);
		return("delete successfully ");
		}
		else {
		throw new UserNotFoundException("User not found ");
		
		}
		
	}

/*
 * Implementation for showing user
 */
	@Override
	public List<User> showAllUsers() {
		String methodName="showAllUser()";
		logger.info(methodName+"Called");
		return repository.findAll();
	
	}

	/*
     * Implementation for validating user
     */
	@Override
	public boolean validateUser(User user) throws UserNotFoundException {
		String methodName="validateUser()";
		logger.info(methodName+"Called");
	Optional<User> op =repository.findByUserName(user.getUserName());
	if(op.isPresent()) {
		if(op.get().getUserPassword().equals(user.getUserPassword())) 
			return true;
		else 
			return false;
	}
	else
	throw new UserNotFoundException("this User Is Not Valid");
	}

	}


	

