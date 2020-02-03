package com.projects.invdb.api;

import com.projects.invdb.model.Device;
import com.projects.invdb.model.Employee;
import com.projects.invdb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("api/v1/employee")
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @PostMapping
    public void addEmployee(@Valid @NonNull @RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }

    @DeleteMapping (path = "{id}")
    public int deleteEmployeeById(@PathVariable("id") UUID id){
        return employeeService.deleteEmployeeById(id);
    }
    

    @PutMapping(path = "{id}")
    public int updateEmployeeDevice(@PathVariable("id") UUID id, @Valid @NonNull @RequestBody Employee update){
        return employeeService.updateEmployeeDevice(id, update);
    }

    @GetMapping
    public List<Employee> selectAllEmployees(){
        return employeeService.selectAllEmployees();
    }

    @GetMapping(path = "{id}")
    public Optional<Employee> getEmployeeByID(@PathVariable UUID id){
        return employeeService.selectEmployeeByID(id);
    }
}
