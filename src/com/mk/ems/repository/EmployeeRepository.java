package com.mk.ems.repository;

import com.mk.ems.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    void save(Employee employee);
    Optional<Employee> findById(int id);
    List<Employee> findAll();
    void deleteById(int id);
    boolean existsById(int id);
}
