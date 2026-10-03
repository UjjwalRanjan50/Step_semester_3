package abstraction.assignment_problems.p1;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

abstract class Ticket {
    protected int count;
    public Ticket(int count) {
        this.count = count;
    }
    public double calculateAmount() {
        return (getSeatPrice() + 20.0) * count;
    }
    protected abstract double getSeatPrice();
    public abstract String getType();
}

class RegularTicket extends Ticket {
    public RegularTicket(int count) { super(count); }
    protected double getSeatPrice() { return 150.0; }
    public String getType() { return "REGULAR"; }
}

class PremiumTicket extends Ticket {
    public PremiumTicket(int count) { super(count); }
    protected double getSeatPrice() { return 250.0; }
    public String getType() { return "PREMIUM"; }
}

class ReclinerTicket extends Ticket {
    public ReclinerTicket(int count) { super(count); }
    protected double getSeatPrice() { return 400.0; }
    public String getType() { return "RECLINER"; }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int count = scanner.nextInt();
            switch (type) {
                case "REGULAR": tickets.add(new RegularTicket(count)); break;
                case "PREMIUM": tickets.add(new PremiumTicket(count)); break;
                case "RECLINER": tickets.add(new ReclinerTicket(count)); break;
            }
        }
        
        double grandTotal = 0;
        for (Ticket t : tickets) {
            double amount = t.calculateAmount();
            System.out.printf("%s: %.2f\n", t.getType(), amount);
            grandTotal += amount;
        }
        System.out.printf("Total: %.2f\n", grandTotal);
    }
}
