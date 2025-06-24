package org.example.demo2.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.demo2.dao.EmployeeDao;
import org.example.demo2.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService implements EmployeeServiceInterface {

//    List<Employee> employees = new ArrayList<>();
//
//    {
//        employees.add(new Employee(1, "John Smith", "john123@gmail.com"));
//        employees.add(new Employee(2, "Sarah Johnson", "sarah123@gmail.com"));
//    }

    private final EmployeeDao employeeDao;

    @Override
    public List<Employee> getEmployee() {

        return employeeDao.findAll();

    }

    @Override
    public Employee getEmployeeById(Long id) {
//        return employees.stream()
//                .filter(employee -> employee.getId() == id)
//                .findFirst()
//                .orElse(null);
        Integer i = (int) (long) id;
        return employeeDao.getOne(i);
    }
    @Override
    public Employee addEmployee(Employee employee) {

        employeeDao.save(employee);
        return employee;
    }
    @Override
    public String deleteEmployee(Long id) {

//        employees.removeIf(employee -> employee.getId() == id);
//        return "Successfully deleted";
//        System.out.println("id : " + id);
        Integer i = (int) (long) id;
        Employee entity = employeeDao.getOne(i);  //findById
        Optional<Employee> ent = employeeDao.findById(i);
//        System.out.println(ent.get().getEmail());
        log.info("email: {}",ent.get().getEmail()); //log.error
        employeeDao.delete(entity);
        return "Successfully deleted";

    }

    @Override
    public Employee updateEmployee(Employee employee) {

//        for (Employee value : employees) {
//            if (value.getId() == employee.getId()) {
//                value.setName(employee.getName());
//                value.setEmail(employee.getEmail());
//                return "Successfully updated";
//            }
//        }
//        return "Employee not found";

        employeeDao.save(employee);
        return employee;
    }


    public String generateGreeting(String name) {
        return String.format("Hello %s!", name);
    }



}
