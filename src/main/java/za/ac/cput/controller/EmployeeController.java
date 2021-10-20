package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.staff.Employee;
import za.ac.cput.factory.staff.EmployeeFactory;
import za.ac.cput.repository.staff.EmployeeRepository;
import za.ac.cput.service.staff.EmployeeService;

import java.util.Set;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public Employee create(@RequestBody Employee employee){
        Employee newEmployee = EmployeeFactory.buildEmployee(employee.getEmployeeNumber(), employee.getPositionId(), employee.getFirstName(), employee.getLastName());
        return employeeService.create(newEmployee);
    }

    @GetMapping("/read/{id}")
    public Employee read(@PathVariable String id){
        return employeeService.read(id);
    }

    @PostMapping("/update")
    public Employee update(@RequestBody Employee employee){
        return employeeService.update(employee);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return employeeService.delete(id);
    }

    //@GetMapping("/getAll")
   // public Set<Employee> getAll(){//    return employeeService.getAll();
   // }
}
