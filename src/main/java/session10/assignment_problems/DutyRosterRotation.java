package session10.assignment_problems;

import java.util.Arrays;

/**
 * Problem 8: Duty Roster Rotation
 * 
 * Complexity:
 * - Time Complexity: O(n), where n is the number of names.
 * - Space Complexity: O(n) to construct the rotated array (or O(1) auxiliary if done in-place).
 * 
 * Note on large k:
 * Rotating one place at a time, k times, requires O(k * n) time.
 * When k is up to 10^9, this requires ~10^11 operations, which will cause Time Limit Exceeded (TLE).
 * Using effective rotation k % n ensures we only rotate within [0, n - 1], completing in O(n) time.
 */
public class DutyRosterRotation {

    /**
     * Rotates the roster to the right by k places.
     *
     * @param names array of names in the roster
     * @param k     number of places to rotate
     * @return new rotated array of names
     */
    public static String[] rotateRoster(String[] names, long k) {
        if (names == null || names.length == 0) {
            return names;
        }

        int n = names.length;
        int effectiveK = (int) (k % n);
        if (effectiveK == 0) {
            return Arrays.copyOf(names, n);
        }

        String[] rotated = new String[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + effectiveK) % n] = names[i];
        }

        return rotated;
    }

    public static void main(String[] args) {
        String[] names1 = {"A", "B", "C", "D", "E"};
        System.out.println(Arrays.toString(rotateRoster(names1, 2))); // Expected: [D, E, A, B, C]

        String[] names2 = {"A", "B", "C", "D", "E"};
        System.out.println(Arrays.toString(rotateRoster(names2, 7))); // Expected: [D, E, A, B, C]
    }
}
