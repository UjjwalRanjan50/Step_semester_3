package polymorphism.assignment_problems.p5;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

abstract class Subscription {
    protected String name;
    protected LocalDate startDate;
    public Subscription(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }
    public abstract LocalDate getRenewalDate();
    public String getName() { return name; }
}

class BasicPlan extends Subscription {
    public BasicPlan(String name, LocalDate startDate) { super(name, startDate); }
    public LocalDate getRenewalDate() { return startDate.plusDays(30); }
}

class StandardPlan extends Subscription {
    public StandardPlan(String name, LocalDate startDate) { super(name, startDate); }
    public LocalDate getRenewalDate() { return startDate.plusDays(90); }
}

class PremiumPlan extends Subscription {
    public PremiumPlan(String name, LocalDate startDate) { super(name, startDate); }
    public LocalDate getRenewalDate() { return startDate.plusDays(365); }
}

public class StreamingPlan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        List<Subscription> subscribers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            String dateStr = scanner.next();
            LocalDate startDate = LocalDate.parse(dateStr);
            
            switch (type) {
                case "BASIC": subscribers.add(new BasicPlan(name, startDate)); break;
                case "STANDARD": subscribers.add(new StandardPlan(name, startDate)); break;
                case "PREMIUM": subscribers.add(new PremiumPlan(name, startDate)); break;
            }
        }
        
        for (Subscription sub : subscribers) {
            System.out.printf("%s: %s\n", sub.getName(), sub.getRenewalDate().toString());
        }
    }
}
