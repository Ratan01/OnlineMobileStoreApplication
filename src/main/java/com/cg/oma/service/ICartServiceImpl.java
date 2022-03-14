package com.cg.oma.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.cg.oma.entities.Cart;
import com.cg.oma.entities.Mobile;
import com.cg.oma.exception.MobileNotFoundException;
import com.cg.oma.repository.ICartRepository;
import com.cg.oma.repository.MobileReprository;
import com.cg.oma.utility.GlobalResources;

@Transactional
@Service("service")
public class ICartServiceImpl implements ICartService {
	@Autowired
	private ICartRepository repository;
	
	@Autowired
	private MobileReprository mobileRepository;
	
	private Logger logger= GlobalResources.getLogger(ICartService.class);
	
	@Override
	public String addMobileItems(List<Mobile> mobiles) {
		String methodName="addMobileItems()";
		logger.info(methodName + "Called");
		
		repository.save(mobiles);
		return "Inserted Successfully";
	}

	@Override
	public String deleteMobileItems(int mobileId) throws MobileNotFoundException {
		String methodName="deleteMobileItems()";
		logger.info(methodName + "Called");
		
		Optional<Mobile> op=mobileRepository.findById(mobileId);
		if(op.isPresent()) {
			mobileRepository.deleteById(mobileId);
			return "delete successfully";
		}
		else
			throw new MobileNotFoundException("mobile id not found");
	}

	@Override
	public String updateMobileItemquantity(Mobile mobile) {
		String methodName="updateMobileItemquantity()";
		logger.info(methodName + "Called");
		
		Mobile result = mobileRepository.save(mobile);
		if(result!=null)
			return "company updated succesfully";
		else
			return "Company not updates";
	}
	@Override
	public List<Mobile> showAllMobileItems() {
		String methodName="showAllMobileItems()";
		logger.info(methodName + "Called");
		
		 return mobileRepository.findAll();
	}

	@Override
	public long placeOrder(Cart cart) {
		String methodName="placeOrder()";
		logger.info(methodName + "Called");
		
		int flag=0;
		Cart result=repository.save(cart);
		if(result!=null) {
			return repository.count();
		}
		else
			return 0;
	}
}
