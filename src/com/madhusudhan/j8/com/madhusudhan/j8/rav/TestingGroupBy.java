package com.madhusudhan.j8.com.madhusudhan.j8.rav;

import com.madhusudhan.j8.domain.Employee;
import com.madhusudhan.j8.util.EmployeeUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.madhusudhan.j8.util.EmployeeUtil.createDetailedEmployees;

/**
 * Created by ravi on 30/03/2017.
 */
public class TestingGroupBy {

    public static void main(String[] args) {
        List<Employee> employees = createDetailedEmployees();

        // group by dept
        Map<String,List<Employee>> dept =  employees.stream().collect(Collectors.groupingBy(e -> e.getDepartment()));
        System.out.println(dept);

        Map<String,List<Employee>> city = employees.stream().collect(Collectors.groupingBy(e -> e.getCity()));
        System.out.println(city);


        // group by city and dept
       Map<String,Map<String,List<Employee>>> cityDept = employees.stream().collect(Collectors.groupingBy(e -> e.getCity(), Collectors.groupingBy(e1 -> e1.getDepartment())));
       cityDept.forEach((s, stringListMap) -> {
           System.out.println("city:" + s);
           stringListMap.forEach((s1, employees1) -> {
               System.out.println("Dept:" + s1);
               System.out.println(employees1);
           });
       });
    }
}
