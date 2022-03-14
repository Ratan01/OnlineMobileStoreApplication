package com.cg.oma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.cg.oma.entities.Cart;
import com.cg.oma.entities.Mobile;


@Repository("repository")
public interface ICartRepository extends JpaRepository<Cart,Integer> {

	Mobile save(List<Mobile> mobiles);
	/*
	@Query("DELETE s FROM Mobile s WHERE s.mobileId =:p")
	public String deleteMobileItems(@Param("p") int mobileId);

	public int count(Cart cart);
	*/
}
	
