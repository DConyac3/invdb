package com.projects.invdb.dao;

import com.projects.invdb.model.Device;
import com.projects.invdb.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgresEmployee")
public class EmployeeDataAccessService implements EmployeeDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDataAccessService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertEmployee(UUID id, Employee employee) {
        final String sql = "INSERT INTO employee (id, firstName, lastName, title, device_sn) VALUES (?,?,?,?,?)";
        return jdbcTemplate.update(sql, id, employee.getFirstName(), employee.getLastName(), employee.getTitle(), employee.getDevice());
    }

    @Override
    public List<Employee> selectAllEmployees() {
        final String sql = "SELECT id, firstName, lastName, title, device_sn FROM employee";
        return jdbcTemplate.query(sql, (resultSet, i) -> {
                UUID id = UUID.fromString(resultSet.getString("id"));
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String title = resultSet.getString("title");
                String device_sn = resultSet.getString("device_sn");
                return new Employee(id, firstName, lastName, title, device_sn);
        });
    }

    @Override
    public int deleteEmployeeById(UUID id) {
        final String sql = "DELETE FROM employee WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int updateEmployeeDevice(UUID id, Employee employee) {
        final String sql = "UPDATE employee SET device_sn = ? WHERE id = ?";
        return jdbcTemplate.update(sql, employee.getDevice(), id);
    }

    @Override
    public Optional<Employee> selectEmployeeById(UUID id) {
        final String sql = "SELECT FROM employee WHERE id = ?";
        Employee employee = jdbcTemplate.queryForObject(sql, new Object[]{id}, (resultSet, i) -> {
            UUID employeeID = UUID.fromString(resultSet.getString("id"));
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            String title = resultSet.getString("title");
            String device_sn = resultSet.getString("device_sn");
            return new Employee(employeeID, firstName, lastName, title, device_sn);
        });
        return Optional.ofNullable(employee);
    }
}
