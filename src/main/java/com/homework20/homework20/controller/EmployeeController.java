package com.homework20.homework20.controller;

import com.homework20.homework20.service.EmployeeService;
import model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }
    @GetMapping
    Collection<Employee> getAll() {
        return service.getAll();
    }

    @GetMapping("/add")
    public Employee add(String firstName, String lastName) {
        return service.add(firstName, lastName);
    }
    @GetMapping("/remove")
    public Employee remove(String firstName, String lastName) {
        return service.remove(firstName, lastName);
    }
    @GetMapping("/find")
    public Employee find(String firstName, String lastName) {
        return service.find(firstName, lastName);
    }

}
