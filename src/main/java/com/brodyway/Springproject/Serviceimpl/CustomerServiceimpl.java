package com.brodyway.Springproject.Serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brodyway.Springproject.Model.Customer;
import com.brodyway.Springproject.Repositry.CustomerRepositry;
import com.brodyway.Springproject.Service.CustomerService;

@Service
public class CustomerServiceimpl implements CustomerService {
    @Autowired
	private CustomerRepositry customerRepo;
    
	@Override
	public void addcustomer(Customer customer) {
		customerRepo.save(customer);
		
	}

	@Override
	public void deletecustomer(Long id) {
		customerRepo.deleteById(id);
		
	}

	@Override
	public void updatecustomer(Customer customer) {
		 customerRepo.save(customer);
		 
	}

	@Override
	public Customer getcustomerById(Long id) {
		
		return customerRepo.findById(id).get();
	}

	@Override
	public List<Customer> getAllcustomer() {
		
		return customerRepo.findAll();
		
	}

}
