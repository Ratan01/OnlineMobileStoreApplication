package com.cg.oma.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.oma.entities.Order;


@Repository("orderRespository")
public interface IOrderRepository extends JpaRepository<Order, Integer> {

	
}
