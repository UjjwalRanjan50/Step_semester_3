package sorting.assignment_problems;

/**
 * Problem 5: The Dice Throw Tally
 * 
 * Implements Counting Sort for dice rolls (values 1 to 6).
 * Tallies frequencies without comparing elements directly, prints the frequency counts,
 * and reconstructs the sorted output array.
 */
public class DiceThrowTally {

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
     * Counts frequencies of dice throws from 1 to 6, prints the tally,
     * and returns the results in sorted non-decreasing order.
     *
     * @param rolls array of dice roll outcomes (1-6)
     * @return sorted array of rolls
     */
    public static int[] diceSort(int[] rolls) {
        if (rolls == null) {
            return new int[0];
        }

        int[] count = new int[7];
        for (int roll : rolls) {
            if (roll >= 1 && roll <= 6) {
                count[roll]++;
            }
        }

        // Print counts: "Counts: 1:2 2:1 3:0 4:3 5:0 6:1"
        StringBuilder countsStr = new StringBuilder("Counts: ");
        for (int v = 1; v <= 6; v++) {
            countsStr.append(v).append(":").append(count[v]);
            if (v < 6) {
                countsStr.append(" ");
            }
        }
        System.out.println(countsStr.toString());

        // Reconstruct sorted array
        int[] sorted = new int[rolls.length];
        int idx = 0;
        for (int v = 1; v <= 6; v++) {
            for (int c = 0; c < count[v]; c++) {
                sorted[idx++] = v;
            }
        }

        System.out.println("Sorted: " + formatArray(sorted));
        return sorted;
    }

    public static void main(String[] args) {
        System.out.println("Sample 1:");
        int[] rolls1 = {4, 1, 6, 4, 2, 1, 4};
        diceSort(rolls1);

        System.out.println("\nCustom Input (Various dice throws):");
        int[] rollsCustom = {6, 5, 5, 3, 2, 1, 1, 6, 2};
        diceSort(rollsCustom);
    }
}
