package com.mk.ems.repository;

import com.mk.ems.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryEmployeeRepository implements EmployeeRepository {

    private List<Employee> employees;

    public InMemoryEmployeeRepository() {
        employees = new ArrayList<>();
    }

    @Override
    public void save(Employee employee) {

    }

    @Override
    public Optional<Employee> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Employee> findAll() {
        return List.of();
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public boolean existsById(int id) {
        return false;
    }
}
