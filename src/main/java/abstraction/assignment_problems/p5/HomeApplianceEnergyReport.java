package abstraction.assignment_problems.p5;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

interface SaverModeCapable { }

abstract class Appliance {
    protected double hours;
    protected boolean saverModeRequested;

    public Appliance(double hours, boolean saverModeRequested) {
        this.hours = hours;
        this.saverModeRequested = saverModeRequested;
    }
    
    public double calculateUnits() {
        double units = (getPowerRating() * hours) / 1000.0;
        if (saverModeRequested && this instanceof SaverModeCapable) {
            units *= 0.75; // reduced by 25%
        }
        return units;
    }

    public double calculateCost() {
        return calculateUnits() * 8.0;
    }
    
    protected abstract double getPowerRating();
    public abstract String getType();
    public boolean getSaverModeRequested() { return saverModeRequested; }
}

class Fridge extends Appliance {
    public Fridge(double hours, boolean saverModeRequested) { super(hours, saverModeRequested); }
    protected double getPowerRating() { return 150.0; }
    public String getType() { return "FRIDGE"; }
}

class AC extends Appliance implements SaverModeCapable {
    public AC(double hours, boolean saverModeRequested) { super(hours, saverModeRequested); }
    protected double getPowerRating() { return 1500.0; }
    public String getType() { return "AC"; }
}

class TV extends Appliance {
    public TV(double hours, boolean saverModeRequested) { super(hours, saverModeRequested); }
    protected double getPowerRating() { return 100.0; }
    public String getType() { return "TV"; }
}

class Washer extends Appliance implements SaverModeCapable {
    public Washer(double hours, boolean saverModeRequested) { super(hours, saverModeRequested); }
    protected double getPowerRating() { return 500.0; }
    public String getType() { return "WASHER"; }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        List<Appliance> appliances = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine().trim();
            String[] parts = line.split("\\s+");
            String type = parts[0];
            double hours = Double.parseDouble(parts[1]);
            boolean saverMode = parts.length > 2 && parts[2].equals("SAVER");
            
            switch (type) {
                case "FRIDGE": appliances.add(new Fridge(hours, saverMode)); break;
                case "AC": appliances.add(new AC(hours, saverMode)); break;
                case "TV": appliances.add(new TV(hours, saverMode)); break;
                case "WASHER": appliances.add(new Washer(hours, saverMode)); break;
            }
        }
        
        double totalCost = 0;
        for (Appliance a : appliances) {
            if (a.getSaverModeRequested() && !(a instanceof SaverModeCapable)) {
                System.out.printf("%s: saver mode not supported\n", a.getType());
            } else {
                double units = a.calculateUnits();
                double cost = a.calculateCost();
                System.out.printf("%s: Units=%.2f Cost=%.2f\n", a.getType(), units, cost);
                totalCost += cost;
            }
        }
        System.out.printf("Total Cost: %.2f\n", totalCost);
    }
}
