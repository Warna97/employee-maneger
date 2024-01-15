package employeeManagement;

public class Employee {
    private String name;
    private int age;
    private String department;
    private double salary;

    public Employee() {
        // Default constructor
    }

    public Employee(String name, int age, String department, double salary) {
        if (isValidName(name) && isValidAge(age) && isValidDepartment(department) && isValidSalary(salary)) {
            this.name = name;
            this.age = age;
            this.department = department;
            this.salary = salary;
        } else {
            throw new IllegalArgumentException("Invalid data provided for Employee");
        }
    }

    // Getter and Setter methods for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (isValidName(name)) {
            this.name = name;
        } else {
            throw new IllegalArgumentException("Invalid name");
        }
    }

    // Getter and Setter methods for age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (isValidAge(age)) {
            this.age = age;
        } else {
            throw new IllegalArgumentException("Invalid age");
        }
    }

    // Getter and Setter methods for department
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        if (isValidDepartment(department)) {
            this.department = department;
        } else {
            throw new IllegalArgumentException("Invalid department");
        }
    }

    // Getter and Setter methods for salary
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (isValidSalary(salary)) {
            this.salary = salary;
        } else {
            throw new IllegalArgumentException("Invalid salary");
        }
    }
    private boolean isValidName(String name) {
        return name != null && !name.isEmpty();
    }

    private boolean isValidAge(int age) {
        return age >= 18 && age <= 65; // Example: Age should be between 18 and 65
    }

    private boolean isValidDepartment(String department) {
        return department != null && (department.equals("Marketing") || department.equals("HR") || department.equals("Engineering"));
    }

    private boolean isValidSalary(double salary) {
        return salary >= 0; // Example: Salary should be non-negative
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}

