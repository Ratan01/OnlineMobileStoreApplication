package com.cg.oma.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.cg.oma.entities.Category;
import com.cg.oma.entities.Mobile;
import com.cg.oma.exception.MobileNotFoundException;
import com.cg.oma.repository.CategoryRepository;
import com.cg.oma.repository.MobileReprository;
import com.cg.oma.utility.GlobalResources;




@Transactional
@Service("service")
public class MobileServiceImpl implements IMobileService {
	@Autowired
	private MobileReprository repository;
	@Autowired
	private CategoryRepository categoryRepo;
	
	private Logger logger= GlobalResources.getLogger(MobileServiceImpl.class);
	
	/*
	 * Implementation of add mobile in this method
	 */
	
   public String addMobile(Mobile mobile) {
	   
	   String methodName="addMobile()";
		logger.info(methodName + "called");
		
		Mobile result=repository.save(mobile);
		if(result!=null) {
			return "mobile is added";
		}
		else {
			return "Some Problem In Insertion ";
		}
	}

	
	/*
	 * Implementation of update mobile in this method
	 */
   
	public String updateMobile(Mobile mobile) throws MobileNotFoundException {
		
		String methodName="updateMobile()";
		logger.info(methodName + "called");
		
		Mobile result=repository.save(mobile);
		if(result!=null) {
			return "Updated Mobile Successfully";
		}
		else {
			return "Some Problem is there";
		}
		
	}
	
	
	/*
	 * Implementation of delete mobile in this method
	 */
	
	public String deleteMobile(int id) throws MobileNotFoundException{
		
		String methodName="deleteMobile()";
		logger.info(methodName + "called");
		
		Optional <Mobile>op= repository.findById(id);
	     if(op.isPresent()) {
		repository.deleteById(id);
		 return("delete successfully Mobile By Given"+" "+ id);
	     }
	     else {
	    	 throw new MobileNotFoundException("Mobile  not  found Plz Check Your ID");
	     }
		
	}


	/*
	 * Implementation of show all mobile by category id in this method
	 */
	
	public List<Mobile> showAllMobileByCategoryId(int categoryId) {
		String methodName="showAllMobileByCategory()";
		logger.info(methodName + "called");
		
		List<Mobile > mobile = repository.showAllMobile(categoryId);
		return mobile;
	}

	
	/*
	 * Implementation of show mobile by id in this method
	 */
	
	public Mobile showMobileById(int mobileId) throws MobileNotFoundException {
		String methodName="showMobileById()";
		logger.info(methodName + "called");
		
		Optional<Mobile> result = repository.findById(mobileId);
		if(result.isPresent()) 
			return result.get();
		else
			throw new MobileNotFoundException("Mobile  not  found Plz Check Your ID");
		
		
	}

	
	/*
	 * Implementation of add category in this method
	 */
	
	public String addCategory(Category category) {
		Category categorys=categoryRepo.save(category);
		if(categorys!=null)
			return "Category Inserted ";
		else
			return "Category Can Not Be Inserted";
		
	}



}
