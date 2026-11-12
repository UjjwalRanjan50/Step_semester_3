package sorting.assignment_problems;

/**
 * Problem 2: The Prize Table
 * 
 * Sorts marks in descending order using Selection Sort.
 * Finds the highest mark among the unsorted portion and swaps it into the current position.
 * Returns the number of swaps made (excluding rounds where the element was already in place).
 */
public class PrizeTable {

    public static String formatArray(int[] arr) {
        if (arr == null) return "null";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Sorts the marks in descending order and returns the number of swaps made.
     *
     * @param marks array of marks to sort
     * @return number of swaps performed
     */
    public static int prizeTable(int[] marks) {
        if (marks == null || marks.length <= 1) {
            return 0;
        }

        int swaps = 0;
        int n = marks.length;

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (marks[j] > marks[maxIndex]) {
                    maxIndex = j;
                }
            }

            if (maxIndex != i) {
                int temp = marks[i];
                marks[i] = marks[maxIndex];
                marks[maxIndex] = temp;
                swaps++;
            }
        }

        return swaps;
    }

    public static void displayPrizeTable(int[] marks) {
        int swaps = prizeTable(marks);
        System.out.println(formatArray(marks) + " swaps = " + swaps);
    }

    public static void main(String[] args) {
        System.out.println("Sample 1:");
        int[] marks1 = {45, 90, 60, 75};
        displayPrizeTable(marks1);

        System.out.println("\nSample 2:");
        int[] marks2 = {80, 70, 60};
        displayPrizeTable(marks2);

        System.out.println("\nCustom Input:");
        int[] marksCustom = {15, 30, 20, 50, 40};
        displayPrizeTable(marksCustom);
    }
}
