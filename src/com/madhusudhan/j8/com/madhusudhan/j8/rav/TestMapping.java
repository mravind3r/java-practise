package com.madhusudhan.j8.com.madhusudhan.j8.rav;

import com.madhusudhan.j8.domain.Employee;

import java.util.stream.Stream;

import static com.madhusudhan.j8.util.EmployeeUtil.createEmployees;


public class TestMapping {

    public static void main(String[] args) {
        Stream<Employee> employeeStream = createEmployees().stream();
       // employeeStream.forEach(System.out::println);

        employeeStream.map(employee -> employee.getName()).map(String::toUpperCase);

    }
}
