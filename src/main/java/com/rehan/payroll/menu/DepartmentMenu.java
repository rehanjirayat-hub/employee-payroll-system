package com.rehan.payroll.menu;

import com.rehan.payroll.exception.DepartmentNotFoundException;
import com.rehan.payroll.model.Department;
import com.rehan.payroll.service.DepartmentService;
import com.rehan.payroll.service.impl.DepartmentServiceImpl;

import java.util.List;
import java.util.Scanner;

public class DepartmentMenu {
    private final Scanner scanner = new Scanner(System.in);

    private final DepartmentService departmentService =
            new DepartmentServiceImpl();

    public void showDepartmentMenu() {

        int choice = 0;

        do {

            System.out.println("""
                    ====================================
                          DEPARTMENT MANAGEMENT
                    ====================================
                    
                    1. Add Department
                    2. View All Departments
                    3. Search Department by ID
                    4. Update Department
                    5. Delete Department
                    6. Back to Main Menu
                    
                    Enter your choice:
                    """);
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    try {

                        System.out.print("Enter Department Name: ");
                        String departmentName = scanner.nextLine();

                        System.out.print("Enter Department Code: ");
                        String departmentCode = scanner.nextLine();

                        Department department = new Department();

                        department.setDepartmentName(departmentName);
                        department.setDepartmentCode(departmentCode);

                        boolean isAdded = departmentService.addDepartment(department);

                        if (isAdded) {
                            System.out.println("✅ Department added successfully.");
                        } else {
                            System.out.println("❌ Failed to add department.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;


                case 2:
                    try {

                        List<Department> departments =
                                departmentService.getAllDepartments();

                        if (departments.isEmpty()) {
                            System.out.println("No departments found.");
                        } else {
                            for (Department department : departments) {
                                System.out.println(
                                        department.getDepartmentId() + " " +
                                                department.getDepartmentName() + " " +
                                                department.getDepartmentCode() + " " +
                                                department.getCreatedAt()
                                );
                            }
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    try {

                        System.out.println("Enter Department ID:");
                        int departmentId = Integer.parseInt(scanner.nextLine());

                        Department department =
                                departmentService.getDepartmentById(departmentId);
                        System.out.println("\n========== Department Details ==========");
                        System.out.println("Department ID   : " + department.getDepartmentId());
                        System.out.println("Department Name : " + department.getDepartmentName());
                        System.out.println("Department Code : " + department.getDepartmentCode());
                        System.out.println("Created At      : " + department.getCreatedAt());
                        System.out.println("========================================");


                    } catch (IllegalArgumentException | DepartmentNotFoundException e) {

                        System.out.println(e.getMessage());

                    }
                    break;

                case 4:
                    try {

                        System.out.println("\n========== Update Department ==========");

                        System.out.print("Enter Department ID: ");
                        int departmentId = Integer.parseInt(scanner.nextLine());

                        System.out.print("Enter New Department Name: ");
                        String departmentName = scanner.nextLine();

                        System.out.print("Enter New Department Code: ");
                        String departmentCode = scanner.nextLine();

                        Department department = new Department(
                                departmentId,
                                departmentName,
                                departmentCode
                        );

                        boolean isUpdated = departmentService.updateDepartment(department);

                        if (isUpdated) {
                            System.out.println("✅ Department updated successfully.");
                        } else {
                            System.out.println("❌ Failed to update department.");
                        }

                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    try {
                        System.out.println("\n========== Delete Department ==========");
                        System.out.print("Enter Department ID: ");
                        int departmentId = Integer.parseInt(scanner.nextLine());
                        boolean isDeleted = departmentService.deleteDepartment(departmentId);
                        if (isDeleted) {
                            System.out.println("✅ Department deleted successfully.");
                        } else {
                            System.out.println("❌ Failed to delete department.");
                        }

                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6:
                    System.out.println("Returning to Main Menu...");
                    break;

                default:
                    System.out.println("❌ Invalid choice. Please try again.");
                    break;
            }


        } while (choice != 6);
    }
}
