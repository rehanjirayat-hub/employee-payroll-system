package com.rehan.payroll.menu;


import java.util.Scanner;

public class MainMenu {

    private final Scanner scanner = new Scanner(System.in);

    private final DepartmentMenu departmentMenu =
            new DepartmentMenu();

    private final EmployeeMenu employeeMenu =
            new EmployeeMenu();

    public void showMainMenu() {

        int choice = 0;

        do {

            System.out.println("""
                    ====================================
                         EMPLOYEE PAYROLL SYSTEM
                    ====================================

                    1. Department Management
                    2. Employee Management
                    3. Attendance Management
                    4. Payroll Management
                    5. Exit

                    Enter your choice:
                    """);

            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    departmentMenu.showDepartmentMenu();
                    break;

                case 2:
                    employeeMenu.showEmployeeMenu();
                    break;

                case 3:
                    System.out.println("Attendance Module Coming Soon...");
                    break;

                case 4:
                    System.out.println("Payroll Module Coming Soon...");
                    break;

                case 5:
                    System.out.println("Thank you for using Employee Payroll System.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);
    }
}
