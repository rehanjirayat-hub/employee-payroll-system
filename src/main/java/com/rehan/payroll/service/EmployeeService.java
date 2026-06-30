package com.rehan.payroll.service;

import com.rehan.payroll.model.Employee;

import java.util.List;

public interface EmployeeService {

    boolean addEmployee(Employee employee);

    boolean updateEmployee(Employee employee);

    boolean deleteEmployee(int employeeId);

    Employee getEmployeeById(int employeeId);

    List<Employee> getAllEmployees();

    Employee getEmployeeByEmail(String email);

    List<Employee> getEmployeesByDepartment(int departmentId);
}