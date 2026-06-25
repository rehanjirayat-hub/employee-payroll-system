package com.rehan.payroll.service;

import com.rehan.payroll.model.Department;

import java.util.List;

public interface DepartmentService {

    boolean addDepartment(Department department);

    List<Department> getAllDepartments();

    Department getDepartmentById(int departmentId);

    boolean updateDepartment(Department department);

    boolean deleteDepartment(int departmentId);
}
