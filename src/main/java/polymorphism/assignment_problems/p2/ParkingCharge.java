package polymorphism.assignment_problems.p2;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

abstract class Vehicle {
    protected int hours;
    public Vehicle(int hours) { this.hours = hours; }
    public abstract double calculateCharge();
    public abstract String getType();
}

class Bike extends Vehicle {
    public Bike(int hours) { super(hours); }
    public double calculateCharge() { return hours * 10.0; }
    public String getType() { return "BIKE"; }
}

class Car extends Vehicle {
    public Car(int hours) { super(hours); }
    public double calculateCharge() { return 30.0 + (hours - 1) * 20.0; }
    public String getType() { return "CAR"; }
}

class Truck extends Vehicle {
    public Truck(int hours) { super(hours); }
    public double calculateCharge() { return Math.max(100.0, hours * 50.0); }
    public String getType() { return "TRUCK"; }
}

public class ParkingCharge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        List<Vehicle> vehicles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int hours = scanner.nextInt();
            switch (type) {
                case "BIKE": vehicles.add(new Bike(hours)); break;
                case "CAR": vehicles.add(new Car(hours)); break;
                case "TRUCK": vehicles.add(new Truck(hours)); break;
            }
        }
        
        double grandTotal = 0;
        for (Vehicle v : vehicles) {
            double charge = v.calculateCharge();
            System.out.printf("%s: %.2f\n", v.getType(), charge);
            grandTotal += charge;
        }
        System.out.printf("Total: %.2f\n", grandTotal);
    }
}
