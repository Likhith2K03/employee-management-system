package com.mk.ems.service;

import com.mk.ems.exception.DuplicateEmployeeException;
import com.mk.ems.exception.EmployeeNotFoundException;
import com.mk.ems.model.Employee;
import com.mk.ems.repository.EmployeeRepository;

import java.util.List;

public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void addEmployee(Employee employee) {
        if(employeeRepository.existsById(employee.getEmployeeId())) {
            throw new DuplicateEmployeeException("Employee already exists");
        }
        employeeRepository.save(employee);
    }

    public Employee getEmployeeById(int id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void updateEmployee(Employee employee) {
        if(!employeeRepository.existsById(employee.getEmployeeId())) {
            throw new EmployeeNotFoundException("Employee not found");
        }
        employeeRepository.save(employee);
    }

    public void deleteEmployee(int id) {
        if(!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException("Employee not found");
        }
        employeeRepository.deleteById(id);
    }

    public double calculateSalary(int id) {
        Employee employee = getEmployeeById(id);
        return employee.calculateSalary();
    }

}
