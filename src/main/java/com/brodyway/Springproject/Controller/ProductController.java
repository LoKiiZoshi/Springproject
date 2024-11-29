package com.brodyway.Springproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.brodyway.Springproject.Model.Product;
import com.brodyway.Springproject.Service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping("/Product")
	public String getProduct() {
		return "ProductForm";
		
	}
	
	@PostMapping("/Product")
	public String postproduct(@ModelAttribute Product product) {
		productService.addproduct(product);
		return "ProductForm";
	}
	
	@GetMapping("/productList")
	public String getproductList(Model model) {
		model.addAttribute("plist",productService.getAllproduct());
		return "ProductListForm";
	}
	
	
	@GetMapping("/pro/delete")
	public String deleteproduct(@RequestParam int id) {
		productService.deleteproduct(id);
		return "redirect:/productList";
	}
	
	@GetMapping("/pro/edit")
	public String edit(@RequestParam int id,Model model) {
		model.addAttribute("pmodel",productService.getproductById(id));
		return"ProductEditForm";
	}
	
	@PostMapping("/pro/update")
	public String update(@ModelAttribute Product product ) {
		productService.updateproduct(product);
		return"redirect:/productList";
	}
	
	@GetMapping("/pro/buy")
	public String buyproduct(@RequestParam int id,Model model) {
		model.addAttribute("pmodel",productService.getproductById(id));
		return"ProductbuyForm";
	}
	
	@PostMapping("/pro/Addproduct")
	public String Addproduct(@ModelAttribute Product product) {
		productService.buyproduct(product);
		return"ProductCartForm";
		
	}
	
	
	
	

}
