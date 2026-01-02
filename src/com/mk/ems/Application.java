package com.mk.ems;

import com.mk.ems.repository.InMemoryEmployeeRepository;
import com.mk.ems.service.EmployeeService;
import com.mk.ems.ui.ConsoleMenu;

public class Application {

    public static void main(String[] args) {
        InMemoryEmployeeRepository repository = new InMemoryEmployeeRepository();
        EmployeeService service = new EmployeeService(repository);
        ConsoleMenu menu = new ConsoleMenu(service);
        menu.start();
    }

}
