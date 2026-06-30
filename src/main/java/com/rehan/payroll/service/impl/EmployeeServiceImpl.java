package com.rehan.payroll.service.impl;

import com.rehan.payroll.model.Department;
import com.rehan.payroll.model.Employee;
import com.rehan.payroll.repository.DepartmentRepository;
import com.rehan.payroll.repository.EmployeeRepository;
import com.rehan.payroll.repository.impl.DepartmentRepositoryImpl;
import com.rehan.payroll.repository.impl.EmployeeRepositoryImpl;
import com.rehan.payroll.service.EmployeeService;

import java.util.List;
import java.util.Optional;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository =
            new EmployeeRepositoryImpl();

    private final DepartmentRepository departmentRepository =
            new DepartmentRepositoryImpl();

    private void validateEmployeeForAdd(Employee employee) {

        if (employee == null) {
            throw new IllegalArgumentException("Employee cannot be null.");
        }

        if (employee.getFirstName() == null ||
                employee.getFirstName().isBlank()) {
            throw new IllegalArgumentException("Employee first name cannot be null or blank.");
        }

        if (employee.getLastName() == null ||
                employee.getLastName().isBlank()) {
            throw new IllegalArgumentException("Employee last name cannot be null or blank.");
        }

        if (employee.getEmail() == null ||
                employee.getEmail().isBlank()) {
            throw new IllegalArgumentException("Employee email cannot be null or blank.");
        }

        if (employeeRepository.existsByEmail(employee.getEmail())) {
            throw new IllegalArgumentException("Employee email already exists.");
        }

        if (employee.getPhoneNumber() == null ||
                employee.getPhoneNumber().isBlank()) {
            throw new IllegalArgumentException("Employee phone number cannot be null or blank.");
        }

        if (employeeRepository.existsByPhoneNumber(employee.getPhoneNumber())) {
            throw new IllegalArgumentException("Employee phone number already exists.");
        }

        if (employee.getDesignation() == null ||
                employee.getDesignation().isBlank()) {
            throw new IllegalArgumentException("Employee designation cannot be null or blank.");
        }

        if (employee.getJoiningDate() == null) {
            throw new IllegalArgumentException("Joining date cannot be null.");
        }

        if (employee.getBasicSalary() <= 0) {
            throw new IllegalArgumentException("Basic salary must be greater than zero.");
        }

        if (employee.getStatus() == null) {
            throw new IllegalArgumentException("Employee status cannot be null.");
        }

        if (employee.getDepartment() == null) {
            throw new IllegalArgumentException("Department cannot be null.");
        }

        if (employee.getDepartment().getDepartmentId() <= 0) {
            throw new IllegalArgumentException("Invalid department ID.");
        }

        departmentRepository.getDepartmentById(
                employee.getDepartment().getDepartmentId()
        );
    }


    @Override
    public boolean addEmployee(Employee employee) {

        validateEmployeeForAdd(employee);

        return employeeRepository.add(employee);
    }

    @Override
    public boolean updateEmployee(Employee employee) {

        if (employee == null) {
            throw new IllegalArgumentException("Employee cannot be null.");
        }

        if (employee.getEmployeeId() <= 0) {
            throw new IllegalArgumentException("Invalid employee ID.");
        }

        employeeRepository.findById(employee.getEmployeeId())
                .orElseThrow(() ->
                        new IllegalArgumentException("Employee not found."));

        if (employee.getFirstName() == null ||
                employee.getFirstName().isBlank()) {
            throw new IllegalArgumentException("Employee first name cannot be null or blank.");
        }

        if (employee.getLastName() == null ||
                employee.getLastName().isBlank()) {
            throw new IllegalArgumentException("Employee last name cannot be null or blank.");
        }

        if (employee.getEmail() == null ||
                employee.getEmail().isBlank()) {
            throw new IllegalArgumentException("Employee email cannot be null or blank.");
        }

        Optional<Employee> existingEmail =
                employeeRepository.findByEmail(employee.getEmail());

        if (existingEmail.isPresent()
                && existingEmail.get().getEmployeeId() != employee.getEmployeeId()) {
            throw new IllegalArgumentException("Employee email already exists.");
        }

        if (employee.getPhoneNumber() == null ||
                employee.getPhoneNumber().isBlank()) {
            throw new IllegalArgumentException("Employee phone number cannot be null or blank.");
        }

        Optional<Employee> existingPhone =
                employeeRepository.findByPhoneNumber(employee.getPhoneNumber());

        if (existingPhone.isPresent()
                && existingPhone.get().getEmployeeId() != employee.getEmployeeId()) {
            throw new IllegalArgumentException("Employee phone number already exists.");
        }

        if (employee.getDesignation() == null ||
                employee.getDesignation().isBlank()) {
            throw new IllegalArgumentException("Employee designation cannot be null or blank.");
        }

        if (employee.getJoiningDate() == null) {
            throw new IllegalArgumentException("Joining date cannot be null.");
        }

        if (employee.getBasicSalary() <= 0) {
            throw new IllegalArgumentException("Basic salary must be greater than zero.");
        }

        if (employee.getStatus() == null) {
            throw new IllegalArgumentException("Employee status cannot be null.");
        }

        if (employee.getDepartment() == null) {
            throw new IllegalArgumentException("Department cannot be null.");
        }

        if (employee.getDepartment().getDepartmentId() <= 0) {
            throw new IllegalArgumentException("Invalid department ID.");
        }

        departmentRepository.getDepartmentById(
                employee.getDepartment().getDepartmentId()
        );

        return employeeRepository.update(employee);
    }

    @Override
    public boolean deleteEmployee(int employeeId) {

        if (employeeId <= 0) {
            throw new IllegalArgumentException("Invalid employee ID.");
        }

        employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new IllegalArgumentException("Employee not found."));

        return employeeRepository.deleteById(employeeId);
    }

    @Override
    public Employee getEmployeeById(int employeeId) {

        if (employeeId <= 0) {
            throw new IllegalArgumentException("Invalid employee ID.");
        }

        return employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new IllegalArgumentException("Employee not found."));
    }

    @Override
    public List<Employee> getAllEmployees() {

        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeByEmail(String email) {

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email cannot be null or blank.");
        }

        return employeeRepository.findByEmail(email)
                .orElseThrow(() ->
                        new IllegalArgumentException("Employee not found."));
    }

    @Override
    public List<Employee> getEmployeesByDepartment(int departmentId) {

        if (departmentId <= 0) {
            throw new IllegalArgumentException("Invalid department ID.");
        }

        departmentRepository.getDepartmentById(departmentId);

        return employeeRepository.findAllByDepartmentId(departmentId);
    }
}


