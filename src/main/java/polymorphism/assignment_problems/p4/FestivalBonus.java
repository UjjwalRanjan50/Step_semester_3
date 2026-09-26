package polymorphism.assignment_problems.p4;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

abstract class Employee {
    protected String name;
    protected double salary;
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    public abstract double calculateBonus();
    public String getName() { return name; }
}

class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name, double salary) { super(name, salary); }
    public double calculateBonus() { return salary * 0.10; }
}

class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name, double salary) { super(name, salary); }
    public double calculateBonus() { return salary * 0.05; }
}

class Intern extends Employee {
    public Intern(String name, double salary) { super(name, salary); }
    public double calculateBonus() { return 2000.0; }
}

public class FestivalBonus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            double salary = scanner.nextDouble();
            switch (type) {
                case "FULLTIME": employees.add(new FullTimeEmployee(name, salary)); break;
                case "PARTTIME": employees.add(new PartTimeEmployee(name, salary)); break;
                case "INTERN": employees.add(new Intern(name, salary)); break;
            }
        }
        
        double grandTotal = 0;
        for (Employee e : employees) {
            double bonus = e.calculateBonus();
            System.out.printf("%s: %.2f\n", e.getName(), bonus);
            grandTotal += bonus;
        }
        System.out.printf("Total Bonus: %.2f\n", grandTotal);
    }
}
