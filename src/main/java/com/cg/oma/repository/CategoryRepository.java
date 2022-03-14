package com.cg.oma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.oma.entities.Category;



@Repository("categoryRepo")
public interface CategoryRepository extends JpaRepository<Category,Integer>{

}
