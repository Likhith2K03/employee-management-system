package com.mk.ems.ui;

import com.mk.ems.exception.DuplicateEmployeeException;
import com.mk.ems.exception.InvalidEmployeeDataException;
import com.mk.ems.model.*;
import com.mk.ems.service.EmployeeService;

import java.util.Scanner;

public class ConsoleMenu {
    Scanner scanner;
    EmployeeService employeeService;

    public ConsoleMenu(EmployeeService employeeService) {
    scanner = new Scanner(System.in);
    this.employeeService = employeeService;
    }

    public void start() {
        while (true) {
            showMenu();
            System.out.print("Enter command: ");
            String command = scanner.next();
            switch (command) {
                case "1":
                    handleAddEmployee();
                    break;
                case "2":
                    handleViewEmployee();
                    break;
                case "3":
                    handleViewAllEmployees();
                    break;
                case "4":
                    handleUpdateEmployee();
                    break;
                case "5":
                    handleDeleteEmployee();
                    break;
                case "6":
                    handleCalculateSalary();
                    break;
                case "7":
                    return;
            }
        }
    }

    public void showMenu() {
        System.out.print("""
                    1. Add Employee
                    2. View Employee by ID
                    3. View All Employees
                    4. Update Employee
                    5. Delete Employee
                    6. Calculate Salary
                    7. Exit""");
    }

    public void handleAddEmployee() {
        Employee employee;
        System.out.println("Which employee do you want to add?");
        System.out.println("""
                1. Full Time
                2. Contract
                3. Intern
                """);
        String employeeType = scanner.next();
        System.out.print("Employee ID: ");
        int employeeId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Employee name: ");
        String employeeName = scanner.nextLine();
        System.out.print("Employee phone number: ");
        String employeePhoneNumber = scanner.next();
        System.out.print("Department ID: ");
        int departmentId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Department name: ");
        String departmentName = scanner.next();
        Department department = new Department(departmentId, departmentName);
        switch(employeeType) {
            case "1":
                System.out.print("Monthly Salary: ");
                double monthlySalary = scanner.nextDouble();
                employee = new FullTimeEmployee(employeeId, employeeName, employeePhoneNumber, department, monthlySalary);
                break;
            case "2":
                System.out.print("Hourly Rate: ");
                double hourlyRate = scanner.nextDouble();
                employee = new ContractEmployee(employeeId, employeeName, employeePhoneNumber, department, hourlyRate);
                break;
            case "3":
                System.out.print("Stipend: ");
                double stipend = scanner.nextDouble();
                employee = new Intern(employeeId, employeeName, employeePhoneNumber, department,  stipend);
                break;
            default:
                System.out.println("Invalid employee type");
                return;
        }
        try {
            employeeService.addEmployee(employee);
        }
        catch (DuplicateEmployeeException | InvalidEmployeeDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public void handleViewEmployee() {}
    public void handleViewAllEmployees() {}
    public void handleUpdateEmployee() {}
    public void handleDeleteEmployee() {}
    public void handleCalculateSalary() {}
}
