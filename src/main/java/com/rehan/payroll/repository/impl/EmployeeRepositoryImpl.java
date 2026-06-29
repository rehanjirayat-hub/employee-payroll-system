package com.rehan.payroll.repository.impl;

import com.rehan.payroll.enumtype.EmployeeStatus;
import com.rehan.payroll.model.Department;
import com.rehan.payroll.model.Employee;
import com.rehan.payroll.repository.EmployeeRepository;
import com.rehan.payroll.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Override
    public boolean add(Employee employee) {

        String sql = """
                INSERT INTO employees (
                    first_name,
                    last_name,
                    email,
                    phone_number,
                    designation,
                    joining_date,
                    basic_salary,
                    status,
                    department_id
                )
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;

        try (
                Connection connection = ConnectionManager.getConnection();
                PreparedStatement preparedStatement =
                        connection.prepareStatement(
                                sql,
                                Statement.RETURN_GENERATED_KEYS
                        )
        ) {

            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getPhoneNumber());
            preparedStatement.setString(5, employee.getDesignation());
            preparedStatement.setDate(6, Date.valueOf(employee.getJoiningDate()));
            preparedStatement.setDouble(7, employee.getBasicSalary());
            preparedStatement.setString(8, employee.getStatus().name());
            preparedStatement.setInt(9, employee.getDepartment().getDepartmentId());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {

                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

                if (generatedKeys.next()) {
                    employee.setEmployeeId(generatedKeys.getInt(1));
                }

                return true;
            }

            return false;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Optional<Employee> findById(int employeeId) {

        String sql = """
                SELECT
                    e.employee_id,
                    e.first_name,
                    e.last_name,
                    e.email,
                    e.phone_number,
                    e.designation,
                    e.joining_date,
                    e.basic_salary,
                    e.status,
                    e.created_at,
                
                    d.department_id,
                    d.department_name,
                    d.department_code
                
                FROM employees e
                JOIN departments d
                    ON e.department_id = d.department_id
                WHERE e.employee_id = ?
                """;

        try (
                Connection connection = ConnectionManager.getConnection();
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql)
        ) {

            preparedStatement.setInt(1, employeeId);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                Employee employee = new Employee();
                Department department = new Department();


                employee.setEmployeeId(resultSet.getInt("employee_id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setEmail(resultSet.getString("email"));
                employee.setPhoneNumber(resultSet.getString("phone_number"));
                employee.setDesignation(resultSet.getString("designation"));
                employee.setJoiningDate(resultSet.getDate("joining_date").toLocalDate());
                employee.setBasicSalary(resultSet.getDouble("basic_salary"));
                employee.setStatus(EmployeeStatus.valueOf(resultSet.getString("status")));
                employee.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());


                department.setDepartmentId(resultSet.getInt("department_id"));
                department.setDepartmentName(resultSet.getString("department_name"));
                department.setDepartmentCode(resultSet.getString("department_code"));


                employee.setDepartment(department);

                return Optional.of(employee);
            }

            return Optional.empty();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Employee> findAll() {

        List<Employee> employees = new ArrayList<>();

        String sql = """
                SELECT
                    e.employee_id,
                    e.first_name,
                    e.last_name,
                    e.email,
                    e.phone_number,
                    e.designation,
                    e.joining_date,
                    e.basic_salary,
                    e.status,
                    e.created_at,
                
                    d.department_id,
                    d.department_name,
                    d.department_code
                
                FROM employees e
                JOIN departments d
                    ON e.department_id = d.department_id
                """;

        try (
                Connection connection = ConnectionManager.getConnection();
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql)
        ) {

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Employee employee = new Employee();
                Department department = new Department();


                employee.setEmployeeId(resultSet.getInt("employee_id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setEmail(resultSet.getString("email"));
                employee.setPhoneNumber(resultSet.getString("phone_number"));
                employee.setDesignation(resultSet.getString("designation"));
                employee.setJoiningDate(resultSet.getDate("joining_date").toLocalDate());
                employee.setBasicSalary(resultSet.getDouble("basic_salary"));
                employee.setStatus(EmployeeStatus.valueOf(resultSet.getString("status")));
                employee.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());


                department.setDepartmentId(resultSet.getInt("department_id"));
                department.setDepartmentName(resultSet.getString("department_name"));
                department.setDepartmentCode(resultSet.getString("department_code"));


                employee.setDepartment(department);

                employees.add(employee);
            }

            return employees;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Employee> findByEmail(String email) {
        String sql = """
                SELECT
                    e.employee_id,
                    e.first_name,
                    e.last_name,
                    e.email,
                    e.phone_number,
                    e.designation,
                    e.joining_date,
                    e.basic_salary,
                    e.status,
                    e.created_at,
                
                    d.department_id,
                    d.department_name,
                    d.department_code
                
                FROM employees e
                JOIN departments d
                    ON e.department_id = d.department_id
                WHERE e.email = ?
                """;

        try (
                Connection connection = ConnectionManager.getConnection();
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql)
        ) {

            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {

                Employee employee = new Employee();
                Department department = new Department();


                employee.setEmployeeId(resultSet.getInt("employee_id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setEmail(resultSet.getString("email"));
                employee.setPhoneNumber(resultSet.getString("phone_number"));
                employee.setDesignation(resultSet.getString("designation"));
                employee.setJoiningDate(resultSet.getDate("joining_date").toLocalDate());
                employee.setBasicSalary(resultSet.getDouble("basic_salary"));
                employee.setStatus(EmployeeStatus.valueOf(resultSet.getString("status")));
                employee.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());


                department.setDepartmentId(resultSet.getInt("department_id"));
                department.setDepartmentName(resultSet.getString("department_name"));
                department.setDepartmentCode(resultSet.getString("department_code"));


                employee.setDepartment(department);

                return Optional.of(employee);
            }

            return Optional.empty();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Employee> findAllByDepartmentId(int departmentId) {

        List<Employee> employees = new ArrayList<>();

        String sql = """
                SELECT
                    e.employee_id,
                    e.first_name,
                    e.last_name,
                    e.email,
                    e.phone_number,
                    e.designation,
                    e.joining_date,
                    e.basic_salary,
                    e.status,
                    e.created_at,
                
                    d.department_id,
                    d.department_name,
                    d.department_code
                
                FROM employees e
                JOIN departments d
                    ON e.department_id = d.department_id
                WHERE d.department_id = ?
                """;

        try (
                Connection connection = ConnectionManager.getConnection();
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql)
        ) {
            preparedStatement.setInt(1, departmentId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                Employee employee = new Employee();
                Department department = new Department();


                employee.setEmployeeId(resultSet.getInt("employee_id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setEmail(resultSet.getString("email"));
                employee.setPhoneNumber(resultSet.getString("phone_number"));
                employee.setDesignation(resultSet.getString("designation"));
                employee.setJoiningDate(resultSet.getDate("joining_date").toLocalDate());
                employee.setBasicSalary(resultSet.getDouble("basic_salary"));
                employee.setStatus(EmployeeStatus.valueOf(resultSet.getString("status")));
                employee.setCreatedAt(resultSet.getTimestamp("created_at").toLocalDateTime());


                department.setDepartmentId(resultSet.getInt("department_id"));
                department.setDepartmentName(resultSet.getString("department_name"));
                department.setDepartmentCode(resultSet.getString("department_code"));


                employee.setDepartment(department);

                employees.add(employee);
            }

            return employees;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean existsByEmail(String email) {
        String sql = """
                SELECT 1
                FROM employees
                WHERE email = ?
                """;

        try (
                Connection connection = ConnectionManager.getConnection();
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql)
        ) {


            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return true;
            }

            return false;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean existsByPhoneNumber(String phoneNumber) {
        String sql = """
                SELECT 1
                FROM employees
                WHERE phone_number = ?
                """;

        try (
                Connection connection = ConnectionManager.getConnection();
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql)
        ) {


            preparedStatement.setString(1, phoneNumber);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return true;
            }

            return false;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Employee employee) {

        String sql = """
                UPDATE employees
                SET
                    first_name = ?,
                    last_name = ?,
                    email = ?,
                    phone_number = ?,
                    designation = ?,
                    joining_date = ?,
                    basic_salary = ?,
                    status = ?,
                    department_id = ?
                WHERE employee_id = ?
                """;

        try (
                Connection connection = ConnectionManager.getConnection();
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql)
        ) {

            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4, employee.getPhoneNumber());
            preparedStatement.setString(5, employee.getDesignation());
            preparedStatement.setDate(6, Date.valueOf(employee.getJoiningDate()));
            preparedStatement.setDouble(7, employee.getBasicSalary());
            preparedStatement.setString(8, employee.getStatus().name());
            preparedStatement.setInt(9, employee.getDepartment().getDepartmentId());
            preparedStatement.setInt(10, employee.getEmployeeId());

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteById(int employeeId) {

        String sql = """
                DELETE FROM employees
                WHERE employee_id = ?
                """;

        try (
                Connection connection = ConnectionManager.getConnection();
                PreparedStatement preparedStatement =
                        connection.prepareStatement(sql)
        ) {

            preparedStatement.setInt(1, employeeId);

            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
