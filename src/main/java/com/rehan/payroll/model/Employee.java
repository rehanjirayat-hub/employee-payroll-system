package com.rehan.payroll.model;

import com.rehan.payroll.enumtype.EmployeeStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Employee {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String designation;
    private LocalDate joiningDate;
    private double basicSalary;
    private EmployeeStatus status;
    private Department department;
    private LocalDateTime createdAt;


    public Employee() {
    }

    public Employee(String firstName, String lastName, String email, String phoneNumber, String designation, LocalDate joiningDate, double basicSalary, EmployeeStatus status, Department department, LocalDateTime createdAt) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.designation = designation;
        this.joiningDate = joiningDate;
        this.basicSalary = basicSalary;
        this.status = status;
        this.department = department;
        this.createdAt = createdAt;
    }

    public Employee(int employeeId, String firstName, String lastName, String email, String phoneNumber, String designation, LocalDate joiningDate, double basicSalary, EmployeeStatus status, Department department, LocalDateTime createdAt) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.designation = designation;
        this.joiningDate = joiningDate;
        this.basicSalary = basicSalary;
        this.status = status;
        this.department = department;
        this.createdAt = createdAt;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", designation='" + designation + '\'' +
                ", joiningDate=" + joiningDate +
                ", basicSalary=" + basicSalary +
                ", status=" + status +
                ", department=" + department +
                ", createdAt=" + createdAt +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getEmployeeId());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return employeeId == employee.employeeId;
    }
}
