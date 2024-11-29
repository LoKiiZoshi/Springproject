package com.brodyway.Springproject.Serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brodyway.Springproject.Model.Employee;
import com.brodyway.Springproject.Repositry.EmployeeRepositry;
import com.brodyway.Springproject.Service.EmployeeService;
@Service
public class EmployeeServiceimpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepositry empRepo;

	@Override
	public void addEmployee(Employee emp) {
		empRepo.save(emp);
	}

	@Override
	public void deleteEmployee(Long id) {
		empRepo.deleteById(id);
		
		
	}

	@Override
	public void updateEmployee(Employee emp) {
		empRepo.save(emp);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		
		return empRepo.findById(id).get();
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return empRepo.findAll();
	}

}
