package com.brodyway.Springproject.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brodyway.Springproject.Model.Customer;

public interface CustomerRepositry extends JpaRepository<Customer, Long> {

}
