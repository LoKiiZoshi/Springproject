package com.brodyway.Springproject.Service;

import java.util.List;

import com.brodyway.Springproject.Model.Employee;

public interface EmployeeService {
	void addEmployee(Employee emp);
	void deleteEmployee(Long id);
	void updateEmployee(Employee emp);
	Employee getEmployeeById(Long id);
	List<Employee> getAllEmployees();

}
