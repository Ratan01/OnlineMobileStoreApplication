package com.cg.oma.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.oma.entities.User;
import com.cg.oma.exception.UserNotFoundException;
@Repository("repository")
public interface IUserRepository extends JpaRepository<User,String> {

	Optional<User> findByUserName(String userName);

	void deleteByUserName(String userName);
	
	

	

	

	
	
	
}
