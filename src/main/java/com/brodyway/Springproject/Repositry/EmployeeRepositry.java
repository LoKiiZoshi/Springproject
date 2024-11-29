package com.brodyway.Springproject.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brodyway.Springproject.Model.Employee;

public interface EmployeeRepositry extends JpaRepository<Employee, Long> {

}
