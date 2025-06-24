package org.example.demo2.controller;

import lombok.RequiredArgsConstructor;
import org.example.demo2.entities.Employee;
import org.example.demo2.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {


    private final EmployeeService employeeService;

    //lombok
//    public GreetingController(GreetingService greetingService) {
//        this.greetingService = greetingService;
//    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return employeeService.generateGreeting(name);
    }

    @GetMapping("/employee")
    public List<Employee> getEmployee(){

        return this.employeeService.getEmployee();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return this.employeeService.getEmployeeById(id);
    }

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee){
        return this.employeeService.addEmployee(employee);
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable Long id){
        return this.employeeService.deleteEmployee(id);
    }

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee){
        return this.employeeService.updateEmployee(employee);
    }

}

