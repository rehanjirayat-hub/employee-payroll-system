package com.rehan.payroll.service;

import com.rehan.payroll.model.Department;
import com.rehan.payroll.model.Employee;
import com.rehan.payroll.enumtype.EmployeeStatus;
import com.rehan.payroll.service.impl.DepartmentServiceImpl;
import com.rehan.payroll.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {

    private EmployeeService employeeService;

    private DepartmentService departmentService;

    @BeforeEach
    void setUp() {

        employeeService = new EmployeeServiceImpl();

        departmentService = new DepartmentServiceImpl();
    }


// Validation Tests


    @Test
    void shouldThrowException_WhenEmployeeIsNull() {

        assertThrows(
                IllegalArgumentException.class,
                () -> employeeService.addEmployee(null)
        );
    }

    @Test
    void shouldThrowException_WhenFirstNameIsBlank() {

        Employee employee = new Employee();

        employee.setFirstName("");
        employee.setLastName("Jirayat");
        employee.setEmail("test@gmail.com");
        employee.setPhoneNumber("9876543210");
        employee.setDesignation("Java Developer");
        employee.setJoiningDate(LocalDate.now());
        employee.setBasicSalary(45000);
        employee.setStatus(EmployeeStatus.ACTIVE);

        Department department =
                departmentService.getDepartmentById(1);

        employee.setDepartment(department);

        assertThrows(
                IllegalArgumentException.class,
                () -> employeeService.addEmployee(employee)
        );
    }

    @Test
    void shouldThrowException_WhenLastNameIsBlank() {

        Employee employee = new Employee();

        employee.setFirstName("Rehan");
        employee.setLastName("");
        employee.setEmail("test@gmail.com");
        employee.setPhoneNumber("9876543210");
        employee.setDesignation("Java Developer");
        employee.setJoiningDate(LocalDate.now());
        employee.setBasicSalary(45000);
        employee.setStatus(EmployeeStatus.ACTIVE);

        Department department =
                departmentService.getDepartmentById(1);

        employee.setDepartment(department);

        assertThrows(
                IllegalArgumentException.class,
                () -> employeeService.addEmployee(employee)
        );
    }

    @Test
    void shouldThrowException_WhenEmailIsBlank() {

        Employee employee = new Employee();

        employee.setFirstName("Rehan");
        employee.setLastName("Jirayat");
        employee.setEmail("");
        employee.setPhoneNumber("9876543210");
        employee.setDesignation("Java Developer");
        employee.setJoiningDate(LocalDate.now());
        employee.setBasicSalary(45000);
        employee.setStatus(EmployeeStatus.ACTIVE);

        Department department =
                departmentService.getDepartmentById(1);

        employee.setDepartment(department);

        assertThrows(
                IllegalArgumentException.class,
                () -> employeeService.addEmployee(employee)
        );
    }

    @Test
    void shouldThrowException_WhenPhoneNumberIsBlank() {

        Employee employee = new Employee();

        employee.setFirstName("Rehan");
        employee.setLastName("Jirayat");
        employee.setEmail("test@gmail.com");
        employee.setPhoneNumber("");
        employee.setDesignation("Java Developer");
        employee.setJoiningDate(LocalDate.now());
        employee.setBasicSalary(45000);
        employee.setStatus(EmployeeStatus.ACTIVE);

        Department department =
                departmentService.getDepartmentById(1);

        employee.setDepartment(department);

        assertThrows(
                IllegalArgumentException.class,
                () -> employeeService.addEmployee(employee)
        );
    }

    @Test
    void shouldThrowException_WhenSalaryIsInvalid() {

        Employee employee = new Employee();

        employee.setFirstName("Rehan");
        employee.setLastName("Jirayat");
        employee.setEmail("test@gmail.com");
        employee.setPhoneNumber("9876543210");
        employee.setDesignation("Java Developer");
        employee.setJoiningDate(LocalDate.now());
        employee.setBasicSalary(0);
        employee.setStatus(EmployeeStatus.ACTIVE);

        Department department =
                departmentService.getDepartmentById(1);

        employee.setDepartment(department);

        assertThrows(
                IllegalArgumentException.class,
                () -> employeeService.addEmployee(employee)
        );
    }

    @Test
    void shouldThrowException_WhenDepartmentIsNull() {

        Employee employee = new Employee();

        employee.setFirstName("Rehan");
        employee.setLastName("Jirayat");
        employee.setEmail("test@gmail.com");
        employee.setPhoneNumber("9876543210");
        employee.setDesignation("Java Developer");
        employee.setJoiningDate(LocalDate.now());
        employee.setBasicSalary(45000);
        employee.setStatus(EmployeeStatus.ACTIVE);

        employee.setDepartment(null);

        assertThrows(
                IllegalArgumentException.class,
                () -> employeeService.addEmployee(employee)
        );
    }


// Add Employee

    @Test
    void shouldAddEmployee_WhenEmployeeIsValid() {

        Department department =
                departmentService.getDepartmentById(1);

        Employee employee = new Employee();

        employee.setFirstName("JUnit");
        employee.setLastName("Employee");
        employee.setEmail("junit" + System.currentTimeMillis() + "@gmail.com");
        employee.setPhoneNumber("99" + System.currentTimeMillis() % 100000000);
        employee.setDesignation("Java Developer");
        employee.setJoiningDate(LocalDate.now());
        employee.setBasicSalary(45000);
        employee.setStatus(EmployeeStatus.ACTIVE);
        employee.setDepartment(department);

        boolean isAdded =
                employeeService.addEmployee(employee);

        assertTrue(isAdded);
        assertTrue(employee.getEmployeeId() > 0);
    }

// Get Employee

    @Test
    void shouldReturnEmployee_WhenEmployeeIdIsValid() {

        Department department =
                departmentService.getDepartmentById(1);

        Employee employee = new Employee();

        employee.setFirstName("Get");
        employee.setLastName("Employee");
        employee.setEmail("get" + System.currentTimeMillis() + "@gmail.com");
        employee.setPhoneNumber("98" + (System.currentTimeMillis() % 100000000));
        employee.setDesignation("Java Developer");
        employee.setJoiningDate(LocalDate.now());
        employee.setBasicSalary(40000);
        employee.setStatus(EmployeeStatus.ACTIVE);
        employee.setDepartment(department);

        employeeService.addEmployee(employee);

        Employee savedEmployee =
                employeeService.getEmployeeById(employee.getEmployeeId());

        assertNotNull(savedEmployee);
        assertEquals(employee.getEmployeeId(), savedEmployee.getEmployeeId());
        assertEquals(employee.getEmail(), savedEmployee.getEmail());
    }


// Get All Employees

    @Test
    void shouldReturnAllEmployees() {

        List<Employee> employees =
                employeeService.getAllEmployees();

        assertNotNull(employees);
        assertFalse(employees.isEmpty());
    }

// Update Employee

    @Test
    void shouldUpdateEmployee_WhenEmployeeIsValid() {

        Department department =
                departmentService.getDepartmentById(1);

        Employee employee = new Employee();

        employee.setFirstName("Update");
        employee.setLastName("Employee");
        employee.setEmail("update" + System.currentTimeMillis() + "@gmail.com");
        employee.setPhoneNumber("97" + (System.currentTimeMillis() % 100000000));
        employee.setDesignation("Developer");
        employee.setJoiningDate(LocalDate.now());
        employee.setBasicSalary(50000);
        employee.setStatus(EmployeeStatus.ACTIVE);
        employee.setDepartment(department);

        employeeService.addEmployee(employee);

        employee.setDesignation("Senior Developer");
        employee.setBasicSalary(70000);

        boolean isUpdated =
                employeeService.updateEmployee(employee);

        assertTrue(isUpdated);

        Employee updatedEmployee =
                employeeService.getEmployeeById(employee.getEmployeeId());

        assertEquals("Senior Developer", updatedEmployee.getDesignation());
        assertEquals(70000, updatedEmployee.getBasicSalary());
    }

// Delete Employee

    @Test
    void shouldDeleteEmployee_WhenEmployeeIdIsValid() {

        Department department =
                departmentService.getDepartmentById(1);

        Employee employee = new Employee();

        employee.setFirstName("Delete");
        employee.setLastName("Employee");
        employee.setEmail("delete" + System.currentTimeMillis() + "@gmail.com");
        employee.setPhoneNumber("96" + (System.currentTimeMillis() % 100000000));
        employee.setDesignation("Tester");
        employee.setJoiningDate(LocalDate.now());
        employee.setBasicSalary(35000);
        employee.setStatus(EmployeeStatus.ACTIVE);
        employee.setDepartment(department);

        employeeService.addEmployee(employee);

        boolean isDeleted =
                employeeService.deleteEmployee(employee.getEmployeeId());

        assertTrue(isDeleted);

        assertThrows(
                IllegalArgumentException.class,
                () -> employeeService.getEmployeeById(employee.getEmployeeId())
        );
    }
}
