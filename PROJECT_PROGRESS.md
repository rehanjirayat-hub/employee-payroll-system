# Employee Payroll System

## Project Overview

A console-based Employee Payroll Management System developed using:

- Java 21
- Core Java
- OOP
- Collections
- JDBC
- MySQL
- Maven
- JUnit 5
- Git & GitHub

The project follows a layered architecture similar to enterprise Java applications.

---

# Project Architecture

```
Presentation (Menu)
        ↓
Service
        ↓
Repository
        ↓
Database
```

---

# Package Structure

```
com.rehan.payroll
│
├── app
├── menu
├── model
├── repository
├── repository.impl
├── service
├── service.impl
├── util
├── exception
```

---

# Database

Database Name

employee_payroll_db

Tables

- departments ✅
- employees ⏳
- attendance ⏳
- payroll ⏳
- leave_requests ⏳

---

# Completed Module

## Department Module ✅

Features

- Add Department
- View All Departments
- Search Department
- Update Department
- Delete Department

Validation

- Department cannot be null
- Department name cannot be null
- Department name cannot be blank
- Department code cannot be null
- Department code cannot be blank
- Department ID must be greater than zero

Exception Handling

- IllegalArgumentException
- DepartmentNotFoundException

Database

- JDBC CRUD completed

---

# JUnit 5

Completed Tests

Validation Tests

- shouldThrowException_WhenDepartmentIsNull()
- shouldThrowException_WhenDepartmentNameIsBlank()
- shouldThrowException_WhenDepartmentNameIsNull()
- shouldThrowException_WhenDepartmentCodeIsBlank()
- shouldThrowException_WhenDepartmentCodeIsNull()

CRUD Tests

- shouldAddDepartment_WhenDepartmentIsValid()
- shouldReturnDepartment_WhenDepartmentIdIsValid()
- shouldThrowException_WhenDepartmentIdIsInvalid()
- shouldThrowException_WhenDepartmentDoesNotExist()
- shouldReturnAllDepartments()
- shouldUpdateDepartment_WhenDepartmentIsValid()
- shouldDeleteDepartment_WhenDepartmentIdIsValid()

---

# Git History

✅ Initial Project Setup

✅ Department Module Completed

✅ DepartmentService JUnit Tests Completed

---

# Coding Standards

- Validation in Service layer
- Database code only in Repository layer
- Menu contains only input/output logic
- Use custom exceptions where appropriate
- Follow Arrange → Act → Assert in JUnit tests
- Use meaningful method names
- Use constructor injection where applicable

---

# Remaining Modules

- Employee Module
- Attendance Module
- Payroll Module
- Leave Module
- Reports Module

---

# Learning Roadmap

Current

- Core Java
- JDBC
- MySQL
- Maven
- JUnit 5
- Git

Next

- Employee Module
- Servlets
- JSP
- Spring Boot
- Hibernate
- Spring Data JPA
- Spring Security
- REST APIs