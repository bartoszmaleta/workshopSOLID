package com.company.module07DIP.main.java.hr.main;



import com.company.module07DIP.main.java.hr.logging.ConsoleLogger;
import com.company.module07DIP.main.java.hr.persistence.EmployeeFileRepository;
import com.company.module07DIP.main.java.hr.persistence.EmployeeFileSerializer;
import com.company.module07DIP.main.java.hr.personnel.Employee;
import com.company.module07DIP.main.java.hr.personnel.FullTimeEmployee;

import java.util.List;

public class NatHolidayEmployeeTimeOffMain {
    public static void main(String[] args) {
        // Create dependencies
        ConsoleLogger consoleLogger = new ConsoleLogger();
        EmployeeFileSerializer employeeFileSerializer = new EmployeeFileSerializer();
        EmployeeFileRepository repository = new EmployeeFileRepository(employeeFileSerializer);

        // Grab employees
        List<Employee> employees = repository.findAll();
        Employee manager = new FullTimeEmployee("Steve Jackson", 5000);

        // Request time off for each employee on
        // national holiday
        for (Employee employee : employees){
            employee.requestTimeOff(1, manager);
        }
    }
}
