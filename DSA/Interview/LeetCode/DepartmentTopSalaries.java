package com.softgroup.dsa.interview.leetcode;
import java.util.*;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    int salary;
    String department;

    public Employee(int id, String name, int salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}

public class DepartmentTopSalaries {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", 70000, "HR"),
            new Employee(2, "Bob", 80000, "HR"),
            new Employee(3, "Charlie", 75000, "HR"),
            new Employee(4, "David", 60000, "HR"),
            new Employee(5, "Eve", 90000, "IT"),
            new Employee(6, "Frank", 85000, "IT"),
            new Employee(7, "Grace", 95000, "IT"),
            new Employee(8, "Heidi", 70000, "IT"),
            new Employee(9, "Ivan", 80000, "Finance"),
            new Employee(10, "Judy", 85000, "Finance"),
            new Employee(11, "Mallory", 75000, "Finance")
        );

        Map<String, List<Employee>> topThreeSalariesByDept = employees.stream()
            .collect(Collectors.groupingBy(
                e -> e.department,
                Collectors.collectingAndThen(
                    Collectors.toList(),
                    list -> list.stream()
                        .sorted(Comparator.comparingInt(Employee::getSalary).reversed())
                        .limit(3)
                        .collect(Collectors.toList())
                )
            ));

        topThreeSalariesByDept.forEach((department, topSalaries) -> {
            System.out.println("Department: " + department);
            topSalaries.forEach(System.out::println);
        });
    }
}
