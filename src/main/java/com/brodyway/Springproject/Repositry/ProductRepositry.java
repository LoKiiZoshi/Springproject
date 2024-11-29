package com.brodyway.Springproject.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brodyway.Springproject.Model.Product;

public interface ProductRepositry extends JpaRepository<Product, Integer> { 

}
