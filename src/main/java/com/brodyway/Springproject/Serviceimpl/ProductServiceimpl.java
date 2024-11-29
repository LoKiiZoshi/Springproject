package com.brodyway.Springproject.Serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brodyway.Springproject.Model.Product;
import com.brodyway.Springproject.Repositry.ProductRepositry;
import com.brodyway.Springproject.Service.ProductService;
@Service
public class ProductServiceimpl implements ProductService {

	
	@Autowired
	private ProductRepositry productRepo;
	
	@Override
	public void addproduct(Product product) {
		productRepo.save(product);
		
		
	}

	@Override
	public void deleteproduct(int id) {
		productRepo.deleteById(id);
		
		
	}

	@Override
	public void updateproduct(Product product) {
		productRepo.save(product);
		
	}

	@Override
	public Product getproductById(int id) {
		
		return productRepo.findById(id).get();
	}

	@Override
	public List<Product> getAllproduct() {
		
		return productRepo.findAll();
	}

	@Override
	public void buyproduct(Product product) {
		productRepo.save(product);
	}

}
