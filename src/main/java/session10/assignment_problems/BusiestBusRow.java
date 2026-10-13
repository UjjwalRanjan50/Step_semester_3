package session10.assignment_problems;

/**
 * Problem 10: Busiest Bus Row
 * 
 * Complexity:
 * - Time Complexity: O(r * c), where r is the number of rows and c is the number of columns.
 *   We visit each seat in the grid exactly once.
 * - Auxiliary Space Complexity: O(1), as we only track the row index and running maximums.
 */
public class BusiestBusRow {

    /**
     * Finds the index of the row with the largest total number of students.
     * Ties are broken by choosing the smaller row index.
     *
     * @param grid 2D array representing student counts in each seat
     * @return an array of two integers: [bestRowIndex, maxTotal]
     */
    public static int[] busiestRow(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return new int[]{-1, 0};
        }

        int bestRowIndex = 0;
        int maxTotal = -1;

        for (int r = 0; r < grid.length; r++) {
            int rowTotal = 0;
            for (int c = 0; c < grid[r].length; c++) {
                rowTotal += grid[r][c];
            }

            // Update only when strictly larger to keep the smaller index on ties
            if (rowTotal > maxTotal) {
                maxTotal = rowTotal;
                bestRowIndex = r;
            }
        }

        return new int[]{bestRowIndex, maxTotal};
    }

    public static String busiestRowSummary(int[][] grid) {
        int[] result = busiestRow(grid);
        return "Row " + result[0] + ", Total " + result[1];
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };

        System.out.println(busiestRowSummary(grid)); // Expected: Row 1, Total 7
    }
}
