package com.softgroup.dsa.interview;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getDepartment() {
        return department;
    }
}

public class EmployeeOperations {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "Engineering", 65000),
                new Employee(2, "Bob", "Marketing", 55000),
                new Employee(3, "Charlie", "Engineering", 70000),
                new Employee(4, "David", "Engineering", 62000),
                new Employee(5, "Eve", "HR", 60000)
        );

        // Filter employees from Engineering department
        List<Employee> engineeringEmployees = employees.stream()
                .filter(e -> e.getDepartment().equals("Engineering"))
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .collect(Collectors.toList());

        // Calculate average salary of engineering employees
        OptionalDouble averageSalary = engineeringEmployees.stream()
                .mapToDouble(Employee::getSalary)
                .average();

        // Print average salary
        if (averageSalary.isPresent()) {
            System.out.println("Average Salary of Engineering Employees: " + averageSalary.getAsDouble());
        } else {
            System.out.println("No engineering employees found.");
        }

        // Print name and salary of employee with highest salary
        if (!engineeringEmployees.isEmpty()) {
            Employee highestSalaryEmployee = engineeringEmployees.get(0);
            System.out.println("Highest Salary Employee: " + highestSalaryEmployee.getName() +
                    " (Salary: " + highestSalaryEmployee.getSalary() + ")");
        } else {
            System.out.println("No engineering employees found.");
        }
    }
}
