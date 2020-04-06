package com.company.module07DIP.main.java.hr.payment;



import com.company.module07DIP.main.java.hr.notifications.EmailSender;
import com.company.module07DIP.main.java.hr.persistence.EmployeeFileRepository;
import com.company.module07DIP.main.java.hr.persistence.EmployeeFileSerializer;
import com.company.module07DIP.main.java.hr.personnel.Employee;

import java.util.List;

public class PaymentProcessor {

    private EmployeeFileRepository employeeRepository;

    public PaymentProcessor(){
        EmployeeFileSerializer serializer =
                new EmployeeFileSerializer();
        this.employeeRepository =
                new EmployeeFileRepository(serializer);
    }

    public int sendPayments(){
        List<Employee> employees = this.employeeRepository.findAll();
        int totalPayments = 0;

        for(Employee employee : employees){
            totalPayments += employee.getMonthlyIncome();
            EmailSender.notify(employee);
        }

        return totalPayments;
    }
}
