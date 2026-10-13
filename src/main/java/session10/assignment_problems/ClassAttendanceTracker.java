package session10.assignment_problems;

/**
 * Problem 6: Class Attendance Tracker
 * 
 * Complexity:
 * - Time Complexity: O(n), where n is the number of days recorded.
 *   Both the total count and the longest streak are computed in a single pass.
 * - Auxiliary Space Complexity: O(1), as only running counters are stored.
 */
public class ClassAttendanceTracker {

    /**
     * Calculates the total number of present days and the longest unbroken streak of attendance.
     *
     * @param days array where 1 represents present and 0 represents absent
     * @return an array of two integers: [totalPresent, longestStreak]
     */
    public static int[] attendanceSummary(int[] days) {
        if (days == null || days.length == 0) {
            return new int[]{0, 0};
        }

        int totalPresent = 0;
        int longestStreak = 0;
        int currentStreak = 0;

        for (int day : days) {
            if (day == 1) {
                totalPresent++;
                currentStreak++;
                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }
            } else {
                currentStreak = 0;
            }
        }

        return new int[]{totalPresent, longestStreak};
    }

    public static String formatSummary(int[] days) {
        int[] result = attendanceSummary(days);
        return "Present: " + result[0] + ", Longest streak: " + result[1];
    }

    public static void main(String[] args) {
        int[] days1 = {1, 1, 0, 1, 1, 1, 0, 1};
        System.out.println(formatSummary(days1)); // Expected: Present: 6, Longest streak: 3

        int[] days2 = {0, 0, 0};
        System.out.println(formatSummary(days2)); // Expected: Present: 0, Longest streak: 0
    }
}
