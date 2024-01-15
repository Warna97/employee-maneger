package employeeManagement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Step 1: Create a list of employees
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", 35, "HR", 60000));
        employees.add(new Employee("Alice", 28, "Engineering", 75000));
        employees.add(new Employee("Bob", 32, "Marketing", 55000));

        // Define a Function that concatenates name and department
        Function<Employee, String> nameAndDeptConcatenator = e -> e.getName() + " - " + e.getDepartment();

        // Use streams to generate a collection of concatenated strings
        List<String> concatenatedInfo = employees.stream()
                .map(nameAndDeptConcatenator)
                .collect(Collectors.toList());

        // Calculate the average salary
        double averageSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);

        // Define an age threshold and filter employees
        int ageThreshold = 30;
        List<Employee> filteredEmployees = employees.stream()
                .filter(e -> e.getAge() > ageThreshold)
                .collect(Collectors.toList());

        // Display the results
        System.out.println("Concatenated Info: " + concatenatedInfo);
        System.out.println("Average Salary: " + averageSalary);
        System.out.println("Employees above " + ageThreshold + " years old: " + filteredEmployees);

        // Search by name
        String searchName = "Alice";
        List<Employee> searchResultByName = searchEmployeesByName(employees, searchName);
        System.out.println("Employees with name '" + searchName + "': " + searchResultByName);

        // Search by department
        String searchDepartment = "HR";
        List<Employee> searchResultByDepartment = searchEmployeesByDepartment(employees, searchDepartment);
        System.out.println("Employees in department '" + searchDepartment + "': " + searchResultByDepartment);

        // Search by age range
        int minAge = 30;
        int maxAge = 40;
        List<Employee> searchResultByAgeRange = searchEmployeesByAgeRange(employees, minAge, maxAge);
        System.out.println("Employees in age range " + minAge + " to " + maxAge + " years old: " + searchResultByAgeRange);

        // Sort employees by name
        List<Employee> sortedByName = sortEmployeesByName(employees);
        System.out.println("Sorted by Name: " + sortedByName);

        // Sort employees by age
        List<Employee> sortedByAge = sortEmployeesByAge(employees);
        System.out.println("Sorted by Age: " + sortedByAge);

        // Sort employees by salary
        List<Employee> sortedBySalary = sortEmployeesBySalary(employees);
        System.out.println("Sorted by Salary: " + sortedBySalary);
    }

    // Search by name
    private static List<Employee> searchEmployeesByName(List<Employee> employees, String name) {
        return employees.stream()
                .filter(e -> e.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    // Search by department
    private static List<Employee> searchEmployeesByDepartment(List<Employee> employees, String department) {
        return employees.stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase(department))
                .collect(Collectors.toList());
    }

    // Search by age range
    private static List<Employee> searchEmployeesByAgeRange(List<Employee> employees, int minAge, int maxAge) {
        return employees.stream()
                .filter(e -> e.getAge() >= minAge && e.getAge() <= maxAge)
                .collect(Collectors.toList());
    }

    // Sort employees by name
    private static List<Employee> sortEmployeesByName(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.toList());
    }

    // Sort employees by age
    private static List<Employee> sortEmployeesByAge(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparingInt(Employee::getAge))
                .collect(Collectors.toList());
    }

    // Sort employees by salary
    private static List<Employee> sortEmployeesBySalary(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .collect(Collectors.toList());
    }
}
