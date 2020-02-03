package com.projects.invdb.service;

import com.projects.invdb.dao.EmployeeDAO;
import com.projects.invdb.model.Device;
import com.projects.invdb.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeService(@Qualifier("postgresEmployee") EmployeeDAO employee){
        this.employeeDAO = employee;
    }

    public int addEmployee(Employee employee){
        return employeeDAO.insertEmployee(employee);
    }

    public int deleteEmployeeById(UUID id){
        return employeeDAO.deleteEmployeeById(id);
    }

    public int updateEmployeeDevice(UUID id, Employee update){
        return employeeDAO.updateEmployeeDevice(id, update);
    }

    public List<Employee> selectAllEmployees(){
        return employeeDAO.selectAllEmployees();
    }

    public Optional<Employee> selectEmployeeByID(UUID id){
        return employeeDAO.selectEmployeeById(id);
    }
}
