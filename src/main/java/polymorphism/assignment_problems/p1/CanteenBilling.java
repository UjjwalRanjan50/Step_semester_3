package polymorphism.assignment_problems.p1;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

abstract class Customer {
    protected double amount;
    public Customer(double amount) {
        this.amount = amount;
    }
    public abstract double calculateFinalAmount();
    public abstract String getType();
}

class Student extends Customer {
    public Student(double amount) { super(amount); }
    public double calculateFinalAmount() { return amount * 0.90; }
    public String getType() { return "STUDENT"; }
}

class Staff extends Customer {
    public Staff(double amount) { super(amount); }
    public double calculateFinalAmount() { return amount * 0.95; }
    public String getType() { return "STAFF"; }
}

class Guest extends Customer {
    public Guest(double amount) { super(amount); }
    public double calculateFinalAmount() { return amount + 10; }
    public String getType() { return "GUEST"; }
}

public class CanteenBilling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double amount = scanner.nextDouble();
            switch (type) {
                case "STUDENT": customers.add(new Student(amount)); break;
                case "STAFF": customers.add(new Staff(amount)); break;
                case "GUEST": customers.add(new Guest(amount)); break;
            }
        }
        
        double grandTotal = 0;
        for (Customer c : customers) {
            double finalAmount = c.calculateFinalAmount();
            System.out.printf("%s: %.2f\n", c.getType(), finalAmount);
            grandTotal += finalAmount;
        }
        System.out.printf("Total: %.2f\n", grandTotal);
    }
}
