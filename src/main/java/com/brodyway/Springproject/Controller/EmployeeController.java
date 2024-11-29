package com.brodyway.Springproject.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.brodyway.Springproject.Model.Employee;
import com.brodyway.Springproject.Service.DepartmentService;
import com.brodyway.Springproject.Service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private DepartmentService deptService;
	
	@GetMapping("/Employee")
	public String getEmployee(Model model) {
		model.addAttribute("dList", deptService.getAllDepts());
		return "EmployeeForm";
	}
	
	@PostMapping("/Employee")
	public String postEmployee(@ModelAttribute Employee emp) {
		empService.addEmployee(emp);
		return "redirect:/Employee";
	}
	
   @GetMapping("/EmployeeList")
   public String getAll(Model model) {
	  model.addAttribute("eList",empService.getAllEmployees());
	   
	   return "EmployeeListForm"; 
	   
	   
   }
   
   @GetMapping("/emp/delete")
   public String delete(@RequestParam Long id) {
	   empService.deleteEmployee(id);
	   return "redirect:/EmployeeList";
   }
   
   @GetMapping ("/emp/edit")
   public String edit(@RequestParam Long id,Model model) {
	   model.addAttribute("emodel",empService.getEmployeeById(id));
	   return "EmployeeEditForm";
   }
   
   @PostMapping("/emp/update")
   public String update(@ModelAttribute Employee emp) {
	   empService.updateEmployee(emp);
	   
	   return"redirect:/EmployeeList";
	   
   }
   
   
   @GetMapping ("/emp/view")
   public String Employeeview(@RequestParam Long id,Model model) {
	   model.addAttribute("emodel",empService.getEmployeeById(id));
	   return "EmployeeViewForm";
   }
	
   @PostMapping("/emp/View")
   public String viewEmployee(@ModelAttribute Employee emp) {
	   empService.updateEmployee(emp);
	   
	   return"redirect:/EmployeeList";
	   
   }
}

