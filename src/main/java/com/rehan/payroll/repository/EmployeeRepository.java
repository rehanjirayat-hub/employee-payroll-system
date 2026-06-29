package com.rehan.payroll.repository;

import com.rehan.payroll.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {

    boolean add(Employee employee);

    boolean update(Employee employee);

    boolean deleteById(int employeeId);

    Optional<Employee> findById(int employeeId);

    List<Employee> findAll();

    Optional<Employee> findByEmail(String email);

    List<Employee> findAllByDepartmentId(int departmentId);

    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phoneNumber);
}
