package com.cg.oma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.oma.entities.Mobile;





@Repository("repository")
public interface MobileReprository extends JpaRepository<Mobile, Integer> {

	@Query("select s from Mobile s join s.category c where c.categoryId=:n" )
	public List<Mobile> showAllMobile(@Param("n")int categoryId);
	

}
