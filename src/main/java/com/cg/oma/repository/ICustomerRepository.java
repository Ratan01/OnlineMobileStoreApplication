package com.cg.oma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.oma.entities.Customer;

@Repository("customerRepository")
public interface ICustomerRepository extends JpaRepository<Customer, Integer>{

}
