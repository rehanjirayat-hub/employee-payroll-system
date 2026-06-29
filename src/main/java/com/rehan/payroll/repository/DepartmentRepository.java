package com.rehan.payroll.repository;

import com.rehan.payroll.model.Department;

import java.util.List;

public interface DepartmentRepository {
    boolean addDepartment(Department department);

    List<Department> getAllDepartments();

    Department getDepartmentById(int departmentId);

    boolean updateDepartment(Department department);

    boolean deleteDepartment(int departmentId);
}
