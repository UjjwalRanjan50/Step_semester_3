package sorting.assignment_problems;

/**
 * Problem 1: The Height Line-Up
 * 
 * Arranges students from shortest to tallest using adjacent swaps (Bubble Sort).
 * Prints the array after each sweep. Stops early if no swaps occurred.
 */
public class HeightLineUp {

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
     * Sorts the array in ascending order by comparing and swapping adjacent students.
     * Prints the line after every sweep from left to right.
     *
     * @param heights array of student heights
     */
    public static void lineUp(int[] heights) {
        if (heights == null || heights.length <= 1) {
            return;
        }

        int n = heights.length;
        for (int pass = 1; pass < n; pass++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1; j++) {
                if (heights[j] > heights[j + 1]) {
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    swapped = true;
                }
            }

            System.out.println("Pass " + pass + ": " + formatArray(heights));

            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Sample 1:");
        int[] heights1 = {4, 2, 5, 1};
        lineUp(heights1);

        System.out.println("\nSample 2:");
        int[] heights2 = {1, 3, 2, 4};
        lineUp(heights2);

        System.out.println("\nCustom Input (Reverse order):");
        int[] heightsCustom = {50, 40, 30, 20, 10};
        lineUp(heightsCustom);
    }
}
