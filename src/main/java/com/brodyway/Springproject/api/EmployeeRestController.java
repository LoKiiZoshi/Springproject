package com.brodyway.Springproject.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.brodyway.Springproject.Model.Employee;
import com.brodyway.Springproject.Service.EmployeeService;

@RestController
public class EmployeeRestController {
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/api/emp/list")
	public List<Employee> getEmps() {
		return empService.getAllEmployees(); 
		
  }
	
	@PostMapping("/api/emp/add")
	public String add(@RequestBody Employee emp) {
		empService.addEmployee(emp);
		return"added sucess";
	}
	
	@PutMapping("/api/emp/update")
	public  String update(@RequestBody Employee emp) {
		empService.updateEmployee(emp);
		return "update sucess";
	}
	
	@DeleteMapping("/api/emp/delete/{id}")
	public String delete(@PathVariable Long id) {
		empService.deleteEmployee(id);
		return"deleted sucess"; 
	}
	
	@GetMapping("/api/emp/{id}")
	public Employee getone(@PathVariable Long id) {
		return empService.getEmployeeById(id);
		
	}
	
	

}
