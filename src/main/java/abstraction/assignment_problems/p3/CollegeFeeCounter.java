package abstraction.assignment_problems.p3;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

interface BusUser {
    default double getTransportFee() {
        return 12000.0;
    }
}

abstract class Student {
    protected String name;
    public Student(String name) { this.name = name; }
    public abstract double getTuitionFee();
    public String getName() { return name; }
}

class DayScholar extends Student implements BusUser {
    public DayScholar(String name) { super(name); }
    public double getTuitionFee() { return 40000.0; }
}

class Hosteller extends Student {
    public Hosteller(String name) { super(name); }
    public double getTuitionFee() { return 40000.0 + 60000.0; }
}

class Scholar extends Student implements BusUser {
    public Scholar(String name) { super(name); }
    public double getTuitionFee() { return 20000.0; }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            switch (type) {
                case "DAY_SCHOLAR": students.add(new DayScholar(name)); break;
                case "HOSTELLER": students.add(new Hosteller(name)); break;
                case "SCHOLAR": students.add(new Scholar(name)); break;
            }
        }
        
        double totalCollected = 0;
        for (Student s : students) {
            double fee = s.getTuitionFee();
            if (s instanceof BusUser) {
                fee += ((BusUser) s).getTransportFee();
            }
            System.out.printf("%s: %.2f\n", s.getName(), fee);
            totalCollected += fee;
        }
        System.out.printf("Total Collected: %.2f\n", totalCollected);
    }
}
