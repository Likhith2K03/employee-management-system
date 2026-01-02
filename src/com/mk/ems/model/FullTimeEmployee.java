package com.mk.ems.model;

import com.mk.ems.exception.InvalidEmployeeDataException;

public class FullTimeEmployee extends Employee {

    private final double monthlySalary;
    private double bonus;

    public FullTimeEmployee(int id, String name, String phoneNumber, Department department, double monthlySalary) {
        super(id, name, phoneNumber, department);
        if(monthlySalary <= 0) {
            throw new InvalidEmployeeDataException("Monthly salary cannot be negative");
        }
        this.monthlySalary = monthlySalary;
        this.bonus = 0;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public double getBonus() {
        return bonus;
    }

    public void updateBonus(double bonus) {
        if(bonus <= 0) {
            throw new InvalidEmployeeDataException("Bonus cannot be negative");
        }
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary + bonus;
    }

}
