package com.madhusudhan.j8.com.madhusudhan.j8.rav;

import com.madhusudhan.j8.domain.Employee;
import com.madhusudhan.j8.util.EmployeeUtil;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import static com.madhusudhan.j8.util.EmployeeUtil.createDetailedEmployees;
import static com.madhusudhan.j8.util.EmployeeUtil.createEmployees;


/**
 * Created by ravi on 30/03/2017.
 */
public class TestFilter {

    public static void main(String[] args) {
        // create a list of employees who are executives
        List<Employee> emps = createEmployees();
        System.out.println(emps.stream().count());
        // emps.stream().filter(e -> e.isExecutive()).forEach(System.out::println);

        List<Employee> allemps = createDetailedEmployees();

        // find all employees whose managers name is sarah
        // allemps.stream().filter(e -> e.getManager().getName().startsWith("Sarah")).forEach(System.out::println);

        // find all employees who work work in finance and city of hyderabad
        allemps.stream().filter(e -> e.getDepartment().startsWith("Finance"))
                .filter(e -> e.getCity().startsWith("Hyderabad")).forEach(System.out::println);


    }
}
