package com.brodyway.Springproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.brodyway.Springproject.Model.Customer;
import com.brodyway.Springproject.Service.CustomerService;

@Controller
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/Customer")
	public String getCustomer() {
		return "CustomerForm";
	}
   
    @PostMapping("/customer")
    public String postcustomer(@ModelAttribute Customer customer) {
    	customerService.addcustomer(customer);
    	return"CustomerForm";
    }
    
    @GetMapping("/CustomerList")
    public String getcustomerList(Model model) {
    	model.addAttribute("cList",customerService.getAllcustomer());
    	return "customerListForm";
    	
    }
    
    @GetMapping("/cus/delete")
    public String deletecustomer(@RequestParam Long id) {
    	customerService.deletecustomer(id);
    	
    	return"redirect:/CustomerList";
    	
    }
    
    
    @GetMapping("/cus/edit")
    public String edit(@RequestParam Long id,Model model) {
    	model.addAttribute("cmodel",customerService.getcustomerById(id));
    	return "CustomerEditFOrm";
    }
    
    @PostMapping("/cus/update")
    public String update(@ModelAttribute Customer customer) {
    	customerService.updatecustomer(customer);
    	return"redirect:/CustomerList";
    	
    }
    
    
    @GetMapping("/cus/view")
    public String customerView(@RequestParam Long id,Model model) {
    	model.addAttribute("cmodel",customerService.getcustomerById(id));
    	return "CustomerViewForm";
    }
    @PostMapping("/cus/Back")
    public String customerBack(@ModelAttribute Customer customer) {
    	return"redirect:/CustomerList";
    
    }
    
    
    
}
