package encapsulation.assignment_problems;

public class TrafficLight {
    private final String id;
    private String color;

    public TrafficLight(String id) {
        this.id = id;
        this.color = "RED";
    }

    public void next() {
        if ("RED".equals(color)) {
            color = "GREEN";
        } else if ("GREEN".equals(color)) {
            color = "YELLOW";
        } else if ("YELLOW".equals(color)) {
            color = "RED";
        }
    }

    public String getColor() {
        return color;
    }
    
    public String getId() {
        return id;
    }
}
