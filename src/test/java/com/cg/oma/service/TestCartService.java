package com.cg.oma.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;


import com.cg.oma.entities.Cart;
import com.cg.oma.entities.Mobile;
import com.cg.oma.repository.ICartRepository;
   
class TestCartService {
	@Mock
	ICartRepository cr;
	@InjectMocks
	ICartServiceImpl ics;
	Cart cart;
	Mobile mobile;
	
   /* @BeforeEach
    public void testCommon() {
    MockitoAnnotations.initMocks(this);
    List<Mobile> list =new ArrayList<>();
    list.add(new Mobile(101, "Redmi", 5400.87, LocalDate.now() , "AI7654DWE", "RedmiIndia"));
    list.add(new Mobile(102, "Vivo", 6420.88, LocalDate.now(), "AI7654BNC", "VivoIndia"));
    }
	
    @Test
	void testInsertCompany() {
		Mockito.when(cr.save(cart)).thenReturn(cart);
		String expectedresult="Inserted Successfully";
		assertEquals(expectedresult,ics.showAllMobileItems());
	    Mockito.verify(cr,Mockito.times(1)).save(cart);
	}
	
    @Test
	void testDeleteCompany() {
		int id=10;
		Mockito.when(cr.findById(id)).thenReturn(Optional.of(cart));
		String expected="delete successfully";
		assertEquals(expected,ics.deleteMobileItems(id));
		Mockito.verify(cr,Mockito.times(1)).findById(id);
	}
	*/
}