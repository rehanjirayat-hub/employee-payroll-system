package com.rehan.payroll.repository.impl;

import com.rehan.payroll.exception.DepartmentNotFoundException;
import com.rehan.payroll.model.Department;
import com.rehan.payroll.repository.DepartmentRepository;
import com.rehan.payroll.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepositoryImpl implements DepartmentRepository {

    @Override
    public boolean addDepartment(Department department) {
        String sql = """
        INSERT INTO departments (department_name, department_code)
        VALUES (?, ?)
        """;
        try(Connection connection = ConnectionManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){


            preparedStatement.setString(1, department.getDepartmentName());
            preparedStatement.setString(2, department.getDepartmentCode());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Department> getAllDepartments() {

        List<Department> departments = new ArrayList<>();

        String sql = """
            SELECT * FROM departments
            """;
        try (
                Connection connection = ConnectionManager.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet rs = preparedStatement.executeQuery()
        ) {

            while (rs.next()) {

                int departmentId = rs.getInt("department_id");
                String departmentName = rs.getString("department_name");
                String departmentCode = rs.getString("department_code");
                LocalDateTime createdAt = rs.getTimestamp("created_at").toLocalDateTime();

                Department department = new Department(
                        departmentId,
                        departmentName,
                        departmentCode,
                        createdAt
                );

                departments.add(department);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return departments;
    }

    @Override
    public Department getDepartmentById(int departmentId) {

        String sql = """
            SELECT * FROM departments
            WHERE department_id = ?
            """;

        try (
                Connection connection = ConnectionManager.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {

            preparedStatement.setInt(1, departmentId);

            try (ResultSet rs = preparedStatement.executeQuery()) {

                if (rs.next()) {

                    return new Department(
                            rs.getInt("department_id"),
                            rs.getString("department_name"),
                            rs.getString("department_code"),
                            rs.getTimestamp("created_at").toLocalDateTime()
                    );
                }

                throw new DepartmentNotFoundException(
                        "Department not found with ID: " + departmentId
                );

            }

        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch department.", e);
        }
    }

    @Override
    public boolean updateDepartment(Department department) {
        String sql = """
                UPDATE departments
                SET department_name = ?,
                department_code = ?
                WHERE department_id = ?
                """;

        try(Connection connection = ConnectionManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){


            preparedStatement.setString(1, department.getDepartmentName());
            preparedStatement.setString(2, department.getDepartmentCode());
            preparedStatement.setInt(3,department.getDepartmentId());
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public boolean deleteDepartment(int departmentId) {
        String sql = "DELETE FROM departments\n" +
                "WHERE department_id = ?";

        try(Connection connection = ConnectionManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,departmentId);
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
