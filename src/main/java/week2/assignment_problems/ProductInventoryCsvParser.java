package week2.assignment_problems;

public class ProductInventoryCsvParser {

    /**
     * Parses a CSV line into fields and prints a formatted record.
     *
     * @param csvLine A CSV line in the form "ProductName,SKU,Quantity".
     */
    public static void parseInventoryRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",");

        if (fields.length == 3) {
            System.out.println("Product: " + fields[0].trim() + 
                               " | SKU: " + fields[1].trim() + 
                               " | Qty: " + fields[2].trim());
        } else {
            System.out.println("Invalid Record");
        }
    }
}
