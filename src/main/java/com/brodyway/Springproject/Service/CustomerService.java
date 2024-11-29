package com.brodyway.Springproject.Service;

import java.util.List;

import com.brodyway.Springproject.Model.Customer;

public interface CustomerService {
	void addcustomer(Customer customer);
	void deletecustomer(Long id);
	void updatecustomer(Customer customer);
	Customer getcustomerById(Long id);
	List<Customer>getAllcustomer();
	

}
