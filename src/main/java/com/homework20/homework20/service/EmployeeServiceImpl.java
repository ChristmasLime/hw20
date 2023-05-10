package com.homework20.homework20.service;

import com.homework20.homework20.exception.EmployeeAlreadyAddedException;
import com.homework20.homework20.exception.EmployeeNotFoundException;
import com.homework20.homework20.exception.EmployeeStorageIsFullException;
import model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final int MAX_SIZE = 10;
    private final Map<String,Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }
    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.size()>MAX_SIZE) {
            throw new EmployeeStorageIsFullException();
        }
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }
    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());

        }
        throw new EmployeeNotFoundException();
    }
    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException();
    }
    @Override
    public Collection<Employee> getAll() {
        return Collections.unmodifiableCollection(employees.values() );
    }
}
