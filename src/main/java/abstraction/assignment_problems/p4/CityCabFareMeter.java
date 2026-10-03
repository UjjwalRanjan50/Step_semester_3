package abstraction.assignment_problems.p4;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

interface NightServiceCapable { }

abstract class Cab {
    protected double km;
    protected boolean isNight;
    
    public Cab(double km, boolean isNight) {
        this.km = km;
        this.isNight = isNight;
    }
    
    public double calculateFare() {
        double fare = km * getRatePerKm();
        fare = Math.max(fare, 100.0);
        if (isNight && this instanceof NightServiceCapable) {
            fare *= 1.20;
        }
        return fare;
    }
    
    protected abstract double getRatePerKm();
    public abstract String getType();
    public boolean getIsNight() { return isNight; }
}

class MiniCab extends Cab {
    public MiniCab(double km, boolean isNight) { super(km, isNight); }
    protected double getRatePerKm() { return 10.0; }
    public String getType() { return "MINI"; }
}

class SedanCab extends Cab implements NightServiceCapable {
    public SedanCab(double km, boolean isNight) { super(km, isNight); }
    protected double getRatePerKm() { return 14.0; }
    public String getType() { return "SEDAN"; }
}

class SUVCab extends Cab implements NightServiceCapable {
    public SUVCab(double km, boolean isNight) { super(km, isNight); }
    protected double getRatePerKm() { return 18.0; }
    public String getType() { return "SUV"; }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        List<Cab> cabs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double km = scanner.nextDouble();
            String time = scanner.next();
            boolean isNight = time.equals("NIGHT");
            
            switch (type) {
                case "MINI": cabs.add(new MiniCab(km, isNight)); break;
                case "SEDAN": cabs.add(new SedanCab(km, isNight)); break;
                case "SUV": cabs.add(new SUVCab(km, isNight)); break;
            }
        }
        
        double total = 0;
        for (Cab c : cabs) {
            if (c.getIsNight() && !(c instanceof NightServiceCapable)) {
                System.out.printf("%s: night service not available\n", c.getType());
            } else {
                double fare = c.calculateFare();
                System.out.printf("%s: %.2f\n", c.getType(), fare);
                total += fare;
            }
        }
        System.out.printf("Total: %.2f\n", total);
    }
}
