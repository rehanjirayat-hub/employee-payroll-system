package com.rehan.payroll.app;

import com.rehan.payroll.menu.DepartmentMenu;

public class EmployeePayrollApplication {
    public static void main (String[] args){
        DepartmentMenu departmentMenu = new DepartmentMenu();

        departmentMenu.showDepartmentMenu();
    }
}