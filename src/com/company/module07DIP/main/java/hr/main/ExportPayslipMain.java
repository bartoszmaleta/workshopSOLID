package com.company.module07DIP.main.java.hr.main;


import com.company.module07DIP.main.java.hr.documents.Payslip;
import com.company.module07DIP.main.java.hr.logging.ConsoleLogger;
import com.company.module07DIP.main.java.hr.persistence.EmployeeFileRepository;
import com.company.module07DIP.main.java.hr.persistence.EmployeeFileSerializer;
import com.company.module07DIP.main.java.hr.personnel.Employee;

import java.time.Month;
import java.util.List;

public class ExportPayslipMain {
    public static void main(String[] args) {
        // Create dependencies
        ConsoleLogger consoleLogger = new ConsoleLogger();
        EmployeeFileSerializer employeeFileSerializer = new EmployeeFileSerializer();
        EmployeeFileRepository repository = new EmployeeFileRepository(employeeFileSerializer);

        // Grab employees
        List<Employee> employees = repository.findAll();

        for (Employee employee : employees){
            Payslip payslip = new Payslip(employee , Month.AUGUST);

            String exportableText = payslip.toTxt().toUpperCase();
            System.out.println(exportableText);
        }
    }
}
