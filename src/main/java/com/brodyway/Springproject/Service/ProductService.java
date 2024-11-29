package com.brodyway.Springproject.Service;

import java.util.List;

import com.brodyway.Springproject.Model.Product;

public interface ProductService {
	void addproduct(Product product);
	void deleteproduct(int id);
	void updateproduct(Product product);
	Product getproductById(int id);
	List<Product>getAllproduct();
	void buyproduct(Product product);
	

}
