package com.company.module07DIP.main.java.hr.main;


import com.company.module07DIP.main.java.hr.logging.ConsoleLogger;
import com.company.module07DIP.main.java.hr.persistence.EmployeeFileRepository;
import com.company.module07DIP.main.java.hr.persistence.EmployeeFileSerializer;
import com.company.module07DIP.main.java.hr.personnel.Employee;

import java.io.IOException;
import java.util.List;

public class SaveEmployeesMain {
    public static void main(String[] args) {
        // Grab employees
        EmployeeFileSerializer employeeFileSerializer = new EmployeeFileSerializer();
        ConsoleLogger consoleLogger = new ConsoleLogger();

        EmployeeFileRepository repository = new EmployeeFileRepository(employeeFileSerializer);
        List<Employee> employees = repository.findAll();

        // Save all
        for (Employee e : employees){
            try {
                repository.save(e);
                consoleLogger.writeInfo("Saved employee " + e.toString());
            } catch (IOException exception) {
                consoleLogger.writeError("Error saving employee", exception);
            }
        }
    }
}
