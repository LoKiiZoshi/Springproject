package com.brodyway.Springproject.Service;

import java.util.List;

import com.brodyway.Springproject.Model.Department;

public interface DepartmentService {

	void addDept(Department dept);

	void deleteDept(int id);

	void updateDept(Department dept);

	Department getDeptById(int id);

	List<Department> getAllDepts();

}
