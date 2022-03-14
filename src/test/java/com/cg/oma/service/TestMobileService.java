package com.cg.oma.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.oma.entities.Category;
import com.cg.oma.entities.Mobile;
import com.cg.oma.exception.MobileNotFoundException;
import com.cg.oma.repository.MobileReprository;


class TestMobileService {
 
	@Mock
	MobileReprository repository;
	@InjectMocks
	MobileServiceImpl service;
	Mobile m;
	
	@BeforeEach
	public void testCommon() {
		
		 MockitoAnnotations.initMocks(this);
		
		 m = new Mobile("real me",1000,LocalDate.of(2022,03,10),"8876789","veer", new Category(101,"fjh"));
	}
	
	/*
	 * 1. Test Case For addMobile()
	 */
	@Test
	public void testAddMobile() {
		
		Mockito.when(repository.save(m)).thenReturn(m);
		//String actualResult=service.addMobile(m);
		String expectedResult="mobile is added";
		
		assertEquals(expectedResult, service.addMobile(m));
	
	}
	
	/*
	 * 2.Test Case For updateMobile()
	 */
	
	@Test
	public void testUpdateMobile() throws MobileNotFoundException {
		Mockito.when(repository.save(m)).thenReturn(m);
		String expectedResult="Updated Mobile Successfully";
		assertEquals(expectedResult,service.updateMobile(m));
		Mockito.verify(repository,Mockito.times(1)).save(m);
	}
	
	/*
	 *3. Test Case For deleteMobile()
	 */
	
	@Test
	public void testDeleteMobile() throws MobileNotFoundException {
		int id= 101;
		
		Mockito.when(repository.findById(id)).thenReturn(Optional.of(m));
		
		String expectedResult="delete successfully Mobile By Given"+" "+ id;
		assertEquals(expectedResult,service.deleteMobile(id));
		Mockito.verify(repository,Mockito.times(1)).findById(id);
		
	}
	
	/*
	 * 4.Test Case For showAllMobileByCategoryId()
	 */
	
	@Test
	public void testShowAllMobileByCategoryId() {
		
		int categoryId= 101;
		
		  List<Mobile> emp=new ArrayList<>();
	        emp.add(new Mobile("Realme",1000,LocalDate.of(2022,03,10),"8876789","veer",new Category(1,"smart phone")));
	        emp.add(new Mobile("Redme",100,LocalDate.of(2022,03,10),"8876789","veer",new Category(1,"smart phone")));
	        
	        Category c= new Category(1,"smart Phone");
	        
	       Mockito.when(repository.showAllMobile(categoryId)).thenReturn(emp);
	       assertEquals(service.showAllMobileByCategoryId(categoryId), emp);
	       Mockito.verify(repository,Mockito.times(1)).showAllMobile(categoryId);
	}
	
	
	
	/*
	 *5. Test Case For updateMobile()
	 */
	
	@Test
	public void testShowMobileById() throws MobileNotFoundException {
		int id =101;
		Mockito.when(repository.findById(id)).thenReturn(Optional.of(m));
		Mobile expectedResult=service.showMobileById(id);
		assertEquals(expectedResult, m);
		Mockito.verify(repository ,Mockito.times(1)).findById(id);
	}
	
	/*
	 * 6.Failure Test Case For testShowMobileById()
	 */
	
	@Test
	void testShowMobilesByIdFailure() throws MobileNotFoundException {
		int id = -101;
		Mockito.when(repository.findById(id)).thenReturn(Optional.empty());
		assertThrows(MobileNotFoundException.class, () -> service.showMobileById(id));
		 Mockito.verify(repository,Mockito.times(1)).findById(id);
	}
}
