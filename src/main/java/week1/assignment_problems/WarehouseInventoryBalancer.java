package week1.assignment_problems;

public class WarehouseInventoryBalancer {

    /**
     * Balances inventory across two sections and finds the highest quantity.
     *
     * @param sectionA array of item quantities in Section A
     * @param sectionB array of item quantities in Section B
     */
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA == null || sectionB == null || sectionA.length != sectionB.length) {
            System.out.println("Invalid input arrays.");
            return;
        }

        int totalA = 0;
        int totalB = 0;
        
        int maxQuantity = -1;
        String maxSection = "";
        int maxIndex = -1;

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            totalB += sectionB[i];

            if (sectionA[i] > maxQuantity) {
                maxQuantity = sectionA[i];
                maxSection = "Section A";
                maxIndex = i;
            }
            if (sectionB[i] > maxQuantity) {
                maxQuantity = sectionB[i];
                maxSection = "Section B";
                maxIndex = i;
            }
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        System.out.println("Section A Total: " + totalA + " | Section B Total: " + totalB + " | Status: " + status + 
                           " | Highest Quantity: " + maxQuantity + " (" + maxSection + ", Item " + (maxIndex + 1) + ")");
    }
}
