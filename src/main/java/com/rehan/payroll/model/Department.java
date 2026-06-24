package com.rehan.payroll.model;

import java.time.LocalDateTime;

public class Department {
    private int departmentId;
    private String departmentName;
    private String departmentCode;
    private LocalDateTime createdAt;

    public Department() {
    }

    public Department(String departmentName, String departmentCode, LocalDateTime createdAt) {
        this.departmentName = departmentName;
        this.departmentCode = departmentCode;
        this.createdAt = createdAt;
    }

    public Department(int departmentId, String departmentName, String departmentCode, LocalDateTime createdAt) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentCode = departmentCode;
        this.createdAt = createdAt;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
