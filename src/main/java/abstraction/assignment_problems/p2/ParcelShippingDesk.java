package abstraction.assignment_problems.p2;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

interface Insurable {
    double calculateInsurance();
}

abstract class Parcel {
    protected double weightKg;
    protected double declaredValue;
    public Parcel(double weightKg, double declaredValue) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }
    public abstract double calculateCharge();
    public abstract String getType();
}

class StandardParcel extends Parcel {
    public StandardParcel(double weightKg, double declaredValue) { super(weightKg, declaredValue); }
    public double calculateCharge() { return 40.0 + 10.0 * weightKg; }
    public String getType() { return "STANDARD"; }
}

class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weightKg, double declaredValue) { super(weightKg, declaredValue); }
    public double calculateCharge() { return 80.0 + 15.0 * weightKg; }
    public double calculateInsurance() { return declaredValue * 0.02; }
    public String getType() { return "EXPRESS"; }
}

class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double weightKg, double declaredValue) { super(weightKg, declaredValue); }
    public double calculateCharge() { return 40.0 + 10.0 * weightKg + 50.0; }
    public double calculateInsurance() { return declaredValue * 0.02; }
    public String getType() { return "FRAGILE"; }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        List<Parcel> parcels = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double declaredValue = scanner.nextDouble();
            switch (type) {
                case "STANDARD": parcels.add(new StandardParcel(weight, declaredValue)); break;
                case "EXPRESS": parcels.add(new ExpressParcel(weight, declaredValue)); break;
                case "FRAGILE": parcels.add(new FragileParcel(weight, declaredValue)); break;
            }
        }
        
        double grandTotal = 0;
        for (Parcel p : parcels) {
            double charge = p.calculateCharge();
            double insurance = 0.0;
            if (p instanceof Insurable) {
                insurance = ((Insurable) p).calculateInsurance();
            }
            double total = charge + insurance;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f\n", p.getType(), charge, insurance, total);
            grandTotal += total;
        }
        System.out.printf("Grand Total: %.2f\n", grandTotal);
    }
}
