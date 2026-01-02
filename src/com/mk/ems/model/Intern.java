package com.mk.ems.model;

import com.mk.ems.exception.InvalidEmployeeDataException;

public class Intern extends Employee {

    private final double stipend;

    public Intern(int id, String name, String phoneNumber, Department department,  double stipend) {
        super(id, name, phoneNumber, department);
        if(stipend <= 0) {
            throw new InvalidEmployeeDataException("Stipend cannot be negative");
        }
        this.stipend = stipend;
    }

    @Override
    public double calculateSalary() {
        return stipend;
    }

}
