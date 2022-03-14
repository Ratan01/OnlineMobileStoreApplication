package com.cg.oma.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.cg.oma.entities.User;
import com.cg.oma.exception.UserNotFoundException;
import com.cg.oma.repository.IUserRepository;

class TestUserService {

	@Mock
	IUserRepository ur;
	@InjectMocks
	UserServiceImpl userService;
	User u;
	
	@BeforeEach
	public void testcommon() {
		
		MockitoAnnotations.initMocks(this);
		//usi=new UserServiceImpl();
		//ur=Mockito.mock(IUserRepository.class);
		u=new User("rashmi","rash","customer");
	}
	
	/*
	 * Test case for adding user
	 */
	@Test
	public void testAddUser() {
		
		Mockito.when(ur.save(u)).thenReturn(u);
		//String actualResult=userService.addUser(u);
		String expectedResult="User is added";
		
		assertEquals(expectedResult, userService.addUser(u));
		
		Mockito.verify(ur,Mockito.times(1)).save(u);
	}
	/*
	 * Test case for updating user
	 */
	@Test
	public void testUpdateUser() throws UserNotFoundException{
		Mockito.when(ur.save(u)).thenReturn(u);
		String expectedResult="Updated User Successfully";
		assertEquals(expectedResult,userService.updateUser(u));
		Mockito.verify(ur,Mockito.times(1)).save(u);
	}
	/*
	 * Test case for removing user
	 */
	@Test
	public void testRemoveUser() throws UserNotFoundException {
		String y="rashmi";
		Mockito.when(ur.findByUserName(y)).thenReturn(Optional.of(u));
		String expectedResult="delete successfully ";
        assertEquals(expectedResult,userService.removeUser(y));
		Mockito.verify(ur,Mockito.times(1)).findByUserName(y);
	
	}
	/*
	 * Test case for showing all user
	 */
	@Test
	public void testShowAllUsers() {
	      
		  List<User> n=new ArrayList<>();
	        n.add(new User("rashmi","rash","customer"));
	        n.add(new User("ruchi","ru","manager"));
	        n.add(new User("chandu","ch","supervisor"));
	        
	        
	       Mockito.when(ur.findAll()).thenReturn(n);
	       assertEquals(n,userService.showAllUsers());
	       Mockito.verify(ur,Mockito.times(1)).findAll();
	}
	
}
