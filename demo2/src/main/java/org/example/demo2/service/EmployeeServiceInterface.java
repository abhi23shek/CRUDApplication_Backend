package org.example.demo2.service;

import org.example.demo2.entities.Employee;

import java.util.List;

public interface EmployeeServiceInterface {
    public List<Employee> getEmployee();
    public Employee getEmployeeById(Long id);
    public  Employee addEmployee(Employee employee);
    public String deleteEmployee(Long id);
    public Employee updateEmployee(Employee employee);
}

