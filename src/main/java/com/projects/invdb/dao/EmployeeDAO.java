package com.projects.invdb.dao;

import com.projects.invdb.model.Device;
import com.projects.invdb.model.Employee;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmployeeDAO
{
    int insertEmployee(UUID id, Employee employee);

    default int insertEmployee(Employee employee){
        UUID id = UUID.randomUUID();
        return insertEmployee(id, employee);
    }

    List<Employee> selectAllEmployees();

    int deleteEmployeeById(UUID id);

    int updateEmployeeDevice(UUID id, Employee employee);

    Optional<Employee> selectEmployeeById(UUID id);
}
