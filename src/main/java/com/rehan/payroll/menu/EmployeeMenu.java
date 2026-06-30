package com.rehan.payroll.menu;

import com.rehan.payroll.model.Department;
import com.rehan.payroll.model.Employee;
import com.rehan.payroll.enumtype.EmployeeStatus;
import com.rehan.payroll.service.DepartmentService;
import com.rehan.payroll.service.EmployeeService;
import com.rehan.payroll.service.impl.DepartmentServiceImpl;
import com.rehan.payroll.service.impl.EmployeeServiceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class EmployeeMenu {

    private final Scanner scanner = new Scanner(System.in);

    private final EmployeeService employeeService =
            new EmployeeServiceImpl();

    private final DepartmentService departmentService =
            new DepartmentServiceImpl();

    public void showEmployeeMenu() {

        int choice = 0;

        do {

            System.out.println("""
                ====================================
                      EMPLOYEE MANAGEMENT
                ====================================

                1. Add Employee
                2. View All Employees
                3. Search Employee by ID
                4. Update Employee
                5. Delete Employee
                6. Search Employee by Email
                7. Search Employees by Department
                8. Back to Main Menu

                Enter your choice:
                """);

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    try {

                        System.out.println("\n========== Add Employee ==========");

                        System.out.print("Enter First Name: ");
                        String firstName = scanner.nextLine();

                        System.out.print("Enter Last Name: ");
                        String lastName = scanner.nextLine();

                        System.out.print("Enter Email: ");
                        String email = scanner.nextLine();

                        System.out.print("Enter Phone Number: ");
                        String phoneNumber = scanner.nextLine();

                        System.out.print("Enter Designation: ");
                        String designation = scanner.nextLine();

                        System.out.print("Enter Joining Date (yyyy-MM-dd): ");
                        LocalDate joiningDate = LocalDate.parse(scanner.nextLine());

                        System.out.print("Enter Basic Salary: ");
                        double basicSalary = Double.parseDouble(scanner.nextLine());

                        System.out.println("\n========== Available Departments ==========");

                        List<Department> departments =
                                departmentService.getAllDepartments();

                        if (departments.isEmpty()) {
                            System.out.println("No departments found. Please add a department first.");
                            break;
                        }

                        for (Department department : departments) {
                            System.out.println(
                                    department.getDepartmentId() + " " +
                                            department.getDepartmentName() + " " +
                                            department.getDepartmentCode()
                            );
                        }

                        System.out.print("\nEnter Department ID: ");
                        int departmentId = Integer.parseInt(scanner.nextLine());

                        Department department =
                                departmentService.getDepartmentById(departmentId);

                        System.out.println("\n========== Employee Status ==========");
                        System.out.println("1. ACTIVE");
                        System.out.println("2. INACTIVE");
                        System.out.print("Enter your choice: ");

                        int statusChoice = Integer.parseInt(scanner.nextLine());

                        EmployeeStatus status;

                        if (statusChoice == 1) {
                            status = EmployeeStatus.ACTIVE;
                        } else if (statusChoice == 2) {
                            status = EmployeeStatus.INACTIVE;
                        } else {
                            System.out.println("Invalid status selected.");
                            break;
                        }

                        Employee employee = new Employee();

                        employee.setFirstName(firstName);
                        employee.setLastName(lastName);
                        employee.setEmail(email);
                        employee.setPhoneNumber(phoneNumber);
                        employee.setDesignation(designation);
                        employee.setJoiningDate(joiningDate);
                        employee.setBasicSalary(basicSalary);
                        employee.setStatus(status);
                        employee.setDepartment(department);

                        boolean isAdded =
                                employeeService.addEmployee(employee);

                        if (isAdded) {
                            System.out.println("✅ Employee added successfully.");
                        } else {
                            System.out.println("❌ Failed to add employee.");
                        }

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    try {

                        List<Employee> employees =
                                employeeService.getAllEmployees();

                        if (employees.isEmpty()) {
                            System.out.println("No employees found.");
                        } else {

                            System.out.println("\n========== Employee List ==========");

                            for (Employee employee : employees) {

                                System.out.println(
                                        employee.getEmployeeId() + " | " +
                                                employee.getFirstName() + " " +
                                                employee.getLastName() + " | " +
                                                employee.getEmail() + " | " +
                                                employee.getPhoneNumber() + " | " +
                                                employee.getDesignation() + " | " +
                                                employee.getBasicSalary() + " | " +
                                                employee.getStatus() + " | " +
                                                employee.getDepartment().getDepartmentName()
                                );
                            }
                        }

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    try {

                        System.out.println("\n========== Search Employee ==========");

                        System.out.print("Enter Employee ID: ");
                        int employeeId = Integer.parseInt(scanner.nextLine());

                        Employee employee =
                                employeeService.getEmployeeById(employeeId);

                        System.out.println("\n========== Employee Details ==========");
                        System.out.println("Employee ID    : " + employee.getEmployeeId());
                        System.out.println("First Name     : " + employee.getFirstName());
                        System.out.println("Last Name      : " + employee.getLastName());
                        System.out.println("Email          : " + employee.getEmail());
                        System.out.println("Phone Number   : " + employee.getPhoneNumber());
                        System.out.println("Designation    : " + employee.getDesignation());
                        System.out.println("Joining Date   : " + employee.getJoiningDate());
                        System.out.println("Basic Salary   : " + employee.getBasicSalary());
                        System.out.println("Status         : " + employee.getStatus());
                        System.out.println("Department ID  : " + employee.getDepartment().getDepartmentId());
                        System.out.println("Department     : " + employee.getDepartment().getDepartmentName());
                        System.out.println("Created At     : " + employee.getCreatedAt());
                        System.out.println("======================================");

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    try {

                        System.out.println("\n========== Update Employee ==========");

                        System.out.print("Enter Employee ID: ");
                        int employeeId = Integer.parseInt(scanner.nextLine());

                        Employee employee =
                                employeeService.getEmployeeById(employeeId);

                        System.out.print("Enter New First Name: ");
                        employee.setFirstName(scanner.nextLine());

                        System.out.print("Enter New Last Name: ");
                        employee.setLastName(scanner.nextLine());

                        System.out.print("Enter New Email: ");
                        employee.setEmail(scanner.nextLine());

                        System.out.print("Enter New Phone Number: ");
                        employee.setPhoneNumber(scanner.nextLine());

                        System.out.print("Enter New Designation: ");
                        employee.setDesignation(scanner.nextLine());

                        System.out.print("Enter New Joining Date (yyyy-MM-dd): ");
                        employee.setJoiningDate(LocalDate.parse(scanner.nextLine()));

                        System.out.print("Enter New Basic Salary: ");
                        employee.setBasicSalary(Double.parseDouble(scanner.nextLine()));

                        System.out.println("\n========== Available Departments ==========");

                        List<Department> departments =
                                departmentService.getAllDepartments();

                        for (Department department : departments) {

                            System.out.println(
                                    department.getDepartmentId() + " " +
                                            department.getDepartmentName()
                            );
                        }

                        System.out.print("\nEnter Department ID: ");
                        int departmentId = Integer.parseInt(scanner.nextLine());

                        Department department =
                                departmentService.getDepartmentById(departmentId);

                        employee.setDepartment(department);

                        System.out.println("\n========== Employee Status ==========");
                        System.out.println("1. ACTIVE");
                        System.out.println("2. INACTIVE");
                        System.out.print("Enter your choice: ");

                        int statusChoice = Integer.parseInt(scanner.nextLine());

                        if (statusChoice == 1) {
                            employee.setStatus(EmployeeStatus.ACTIVE);
                        } else if (statusChoice == 2) {
                            employee.setStatus(EmployeeStatus.INACTIVE);
                        } else {
                            System.out.println("Invalid status selected.");
                            break;
                        }

                        boolean isUpdated =
                                employeeService.updateEmployee(employee);

                        if (isUpdated) {
                            System.out.println("✅ Employee updated successfully.");
                        } else {
                            System.out.println("❌ Failed to update employee.");
                        }

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    try {

                        System.out.println("\n========== Delete Employee ==========");

                        System.out.print("Enter Employee ID: ");
                        int employeeId = Integer.parseInt(scanner.nextLine());

                        boolean isDeleted =
                                employeeService.deleteEmployee(employeeId);

                        if (isDeleted) {
                            System.out.println("✅ Employee deleted successfully.");
                        } else {
                            System.out.println("❌ Failed to delete employee.");
                        }

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6:
                    try {

                        System.out.println("\n========== Search Employee By Email ==========");

                        System.out.print("Enter Email: ");
                        String email = scanner.nextLine();

                        Employee employee =
                                employeeService.getEmployeeByEmail(email);

                        System.out.println("\n========== Employee Details ==========");
                        System.out.println("Employee ID    : " + employee.getEmployeeId());
                        System.out.println("First Name     : " + employee.getFirstName());
                        System.out.println("Last Name      : " + employee.getLastName());
                        System.out.println("Email          : " + employee.getEmail());
                        System.out.println("Phone Number   : " + employee.getPhoneNumber());
                        System.out.println("Designation    : " + employee.getDesignation());
                        System.out.println("Joining Date   : " + employee.getJoiningDate());
                        System.out.println("Basic Salary   : " + employee.getBasicSalary());
                        System.out.println("Status         : " + employee.getStatus());
                        System.out.println("Department     : " + employee.getDepartment().getDepartmentName());
                        System.out.println("Created At     : " + employee.getCreatedAt());

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 7:
                    try {

                        System.out.println("\n========== Search Employees By Department ==========");

                        System.out.println("\nAvailable Departments:");

                        List<Department> departments =
                                departmentService.getAllDepartments();

                        for (Department department : departments) {
                            System.out.println(
                                    department.getDepartmentId() + " - " +
                                            department.getDepartmentName()
                            );
                        }

                        System.out.print("\nEnter Department ID: ");
                        int departmentId = Integer.parseInt(scanner.nextLine());

                        List<Employee> employees =
                                employeeService.getEmployeesByDepartment(departmentId);

                        if (employees.isEmpty()) {
                            System.out.println("No employees found in this department.");
                        } else {

                            System.out.println("\n========== Employees ==========");

                            for (Employee employee : employees) {

                                System.out.println(
                                        employee.getEmployeeId() + " | " +
                                                employee.getFirstName() + " " +
                                                employee.getLastName() + " | " +
                                                employee.getDesignation() + " | " +
                                                employee.getEmail()
                                );
                            }
                        }

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 8:
                    System.out.println("Returning to Main Menu...");
                    break;

                default:
                    System.out.println("❌ Invalid choice. Please try again.");
                    break;
            }

        } while (choice != 8);
    }

}
