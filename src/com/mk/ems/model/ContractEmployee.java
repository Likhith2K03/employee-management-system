package com.mk.ems.model;

import com.mk.ems.exception.InvalidEmployeeDataException;

public class ContractEmployee extends Employee {

    private final double hourlyRate;
    private int hoursWorked;

    public ContractEmployee(int id, String name, String phoneNumber, Department department, double hourlyRate) {
        super(id, name, phoneNumber, department);
        if (hourlyRate <= 0) {
            throw new InvalidEmployeeDataException("Hourly rate cannot be negative");
        }
        this.hourlyRate = hourlyRate;
        this.hoursWorked = 0;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void addHoursWorked(int hoursWorked) {
        if (hoursWorked <= 0) {
            throw new InvalidEmployeeDataException("Hours Added cannot be negative");
        }
        this.hoursWorked += hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}