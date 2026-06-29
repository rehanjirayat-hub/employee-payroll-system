package com.rehan.payroll.service.impl;

import com.rehan.payroll.model.Department;
import com.rehan.payroll.repository.DepartmentRepository;
import com.rehan.payroll.repository.impl.DepartmentRepositoryImpl;
import com.rehan.payroll.service.DepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository = new DepartmentRepositoryImpl();

    @Override
    public boolean addDepartment(Department department) {

        if (department == null) {
            throw new IllegalArgumentException("Department cannot be null.");
        }

        if (department.getDepartmentName() == null ||
                department.getDepartmentName().isBlank()) {
            throw new IllegalArgumentException("Department name cannot be blank.");
        }

        if (department.getDepartmentCode() == null ||
                department.getDepartmentCode().isBlank()) {
            throw new IllegalArgumentException("Department code cannot be blank.");
        }

        return departmentRepository.addDepartment(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.getAllDepartments();
    }

    @Override
    public Department getDepartmentById(int departmentId) {
        if (departmentId <= 0) {
            throw new IllegalArgumentException("Department ID must be greater than zero.");
        }
        return departmentRepository.getDepartmentById(departmentId);
    }

    @Override
    public boolean updateDepartment(Department department) {
        if (department == null) {
            throw new IllegalArgumentException("Department cannot be null.");
        }
        if (department.getDepartmentId() <= 0) {

            throw new IllegalArgumentException("Department ID must be greater than zero.");

        }

        if (department.getDepartmentName() == null ||
                department.getDepartmentName().isBlank()) {
            throw new IllegalArgumentException("Department name cannot be null or blank.");
        }

        if (department.getDepartmentCode() == null ||
                department.getDepartmentCode().isBlank()) {
            throw new IllegalArgumentException("Department code cannot be null or blank.");
        }

        return departmentRepository.updateDepartment(department);
    }

    @Override
    public boolean deleteDepartment(int departmentId) {
        if (departmentId <= 0) {
            throw new IllegalArgumentException("Department ID must be greater than zero.");
        }
        return departmentRepository.deleteDepartment(departmentId);
    }
}
