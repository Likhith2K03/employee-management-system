package com.mk.ems.model;

public abstract class Employee {
    private final int employeeId;
    private String name;
    private String phoneNumber;
    private Department department;

    protected Employee(int id, String name, String phoneNumber, Department department) {
        this.employeeId = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.department = department;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void updateContactInfo(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void changeDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public abstract double calculateSalary();
}
