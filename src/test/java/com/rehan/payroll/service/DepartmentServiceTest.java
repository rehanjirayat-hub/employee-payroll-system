package com.rehan.payroll.service;

import com.rehan.payroll.exception.DepartmentNotFoundException;
import com.rehan.payroll.model.Department;
import com.rehan.payroll.service.impl.DepartmentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DepartmentServiceTest {

    private DepartmentService departmentService;

    @BeforeEach
    void setUp() {
        departmentService = new DepartmentServiceImpl();
    }

    // ==========================================================
    // Validation Tests
    // ==========================================================

    @Test
    void shouldThrowException_WhenDepartmentIsNull() {

        assertThrows(
                IllegalArgumentException.class,
                () -> departmentService.addDepartment(null)
        );
    }

    @Test
    void shouldThrowException_WhenDepartmentNameIsBlank() {

        Department department = new Department();
        department.setDepartmentName("");
        department.setDepartmentCode("TEST001");

        assertThrows(
                IllegalArgumentException.class,
                () -> departmentService.addDepartment(department)
        );
    }

    @Test
    void shouldThrowException_WhenDepartmentNameIsNull() {

        Department department = new Department();
        department.setDepartmentName(null);
        department.setDepartmentCode("TEST002");

        assertThrows(
                IllegalArgumentException.class,
                () -> departmentService.addDepartment(department)
        );
    }

    @Test
    void shouldThrowException_WhenDepartmentCodeIsBlank() {

        Department department = new Department();
        department.setDepartmentName("Testing Department");
        department.setDepartmentCode("");

        assertThrows(
                IllegalArgumentException.class,
                () -> departmentService.addDepartment(department)
        );
    }

    @Test
    void shouldThrowException_WhenDepartmentCodeIsNull() {

        Department department = new Department();
        department.setDepartmentName("Testing Department");
        department.setDepartmentCode(null);

        assertThrows(
                IllegalArgumentException.class,
                () -> departmentService.addDepartment(department)
        );
    }

    // ==========================================================
    // Add Department
    // ==========================================================

    @Test
    void shouldAddDepartment_WhenDepartmentIsValid() {

        Department department = new Department();
        department.setDepartmentName("JUnit Testing 1");
        department.setDepartmentCode("JUNIT" + System.currentTimeMillis());

        boolean isAdded = departmentService.addDepartment(department);

        assertTrue(isAdded);
        assertTrue(department.getDepartmentId() > 0);
    }

    // ==========================================================
    // Get Department
    // ==========================================================

    @Test
    void shouldReturnDepartment_WhenDepartmentIdIsValid() {

        Department department = departmentService.getDepartmentById(1);

        assertNotNull(department);
        assertEquals(1, department.getDepartmentId());
        assertEquals("IT", department.getDepartmentName());
        assertEquals("IT001", department.getDepartmentCode());
    }

    @Test
    void shouldThrowException_WhenDepartmentIdIsInvalid() {

        assertThrows(
                IllegalArgumentException.class,
                () -> departmentService.getDepartmentById(0)
        );
    }

    @Test
    void shouldThrowException_WhenDepartmentDoesNotExist() {

        assertThrows(
                DepartmentNotFoundException.class,
                () -> departmentService.getDepartmentById(200)
        );
    }

    // ==========================================================
    // Get All Departments
    // ==========================================================

    @Test
    void shouldReturnAllDepartments() {

        List<Department> departments =
                departmentService.getAllDepartments();

        assertNotNull(departments);
        assertFalse(departments.isEmpty());
    }

    // ==========================================================
    // Update Department
    // ==========================================================

    @Test
    void shouldUpdateDepartment_WhenDepartmentIsValid() {

        Department department = new Department();
        department.setDepartmentId(7);
        department.setDepartmentName("Marketing and Sales");
        department.setDepartmentCode("MKS001");

        boolean isUpdated =
                departmentService.updateDepartment(department);

        assertTrue(isUpdated);

        Department updatedDepartment =
                departmentService.getDepartmentById(7);

        assertEquals(
                "Marketing and Sales",
                updatedDepartment.getDepartmentName()
        );

        assertEquals(
                "MKS001",
                updatedDepartment.getDepartmentCode()
        );
    }

    // ==========================================================
    // Delete Department
    // ==========================================================

    @Test
    void shouldDeleteDepartment_WhenDepartmentIdIsValid() {

        Department department = new Department();
        department.setDepartmentName("JUnit Delete");
        department.setDepartmentCode(
                "DELETE" + System.currentTimeMillis()
        );

        departmentService.addDepartment(department);

        boolean isDeleted =
                departmentService.deleteDepartment(
                        department.getDepartmentId()
                );

        assertTrue(isDeleted);

        assertThrows(
                DepartmentNotFoundException.class,
                () -> departmentService.getDepartmentById(
                        department.getDepartmentId()
                )
        );
    }
}