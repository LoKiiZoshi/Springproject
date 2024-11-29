package com.brodyway.Springproject.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brodyway.Springproject.Model.Department;

public interface DepartmentReposity extends JpaRepository<Department, Integer> {

}
