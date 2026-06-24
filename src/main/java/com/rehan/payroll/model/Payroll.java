package com.rehan.payroll.model;

import java.time.LocalDateTime;

public class Payroll {
    private int payrollId;
    private int employeeId;
    private int payrollMonth;
    private int payrollYear;
    private double basicSalary;
    private double allowance;
    private double deduction;
    private double netSalary;
    private LocalDateTime generatedDate;

    public Payroll() {
    }

    public Payroll(int employeeId, int payrollMonth, int payrollYear, double basicSalary, double allowance, double deduction, double netSalary) {
        this.employeeId = employeeId;
        this.payrollMonth = payrollMonth;
        this.payrollYear = payrollYear;
        this.basicSalary = basicSalary;
        this.allowance = allowance;
        this.deduction = deduction;
        this.netSalary = netSalary;
        this.generatedDate = LocalDateTime.now();
    }

    public Payroll(int payrollId, int employeeId, int payrollMonth, int payrollYear, double basicSalary, double allowance, double deduction, double netSalary, LocalDateTime generatedDate) {
        this.payrollId = payrollId;
        this.employeeId = employeeId;
        this.payrollMonth = payrollMonth;
        this.payrollYear = payrollYear;
        this.basicSalary = basicSalary;
        this.allowance = allowance;
        this.deduction = deduction;
        this.netSalary = netSalary;
        this.generatedDate = generatedDate;
    }

    public int getPayrollId() {
        return payrollId;
    }

    public void setPayrollId(int payrollId) {
        this.payrollId = payrollId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getPayrollMonth() {
        return payrollMonth;
    }

    public void setPayrollMonth(int payrollMonth) {
        this.payrollMonth = payrollMonth;
    }

    public int getPayrollYear() {
        return payrollYear;
    }

    public void setPayrollYear(int payrollYear) {
        this.payrollYear = payrollYear;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    public double getDeduction() {
        return deduction;
    }

    public void setDeduction(double deduction) {
        this.deduction = deduction;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }

    public LocalDateTime getGeneratedDate() {
        return generatedDate;
    }

    public void setGeneratedDate(LocalDateTime generatedDate) {
        this.generatedDate = generatedDate;
    }

    @Override
    public String toString() {
        return "Payroll{" +
                "payrollId=" + payrollId +
                ", employeeId=" + employeeId +
                ", payrollMonth=" + payrollMonth +
                ", payrollYear=" + payrollYear +
                ", basicSalary=" + basicSalary +
                ", allowance=" + allowance +
                ", deduction=" + deduction +
                ", netSalary=" + netSalary +
                ", generatedDate=" + generatedDate +
                '}';
    }
}
