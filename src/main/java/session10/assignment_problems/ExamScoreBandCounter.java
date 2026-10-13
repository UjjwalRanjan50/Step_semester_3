package session10.assignment_problems;

/**
 * Problem 4: Exam Score Band Counter
 * 
 * Complexity:
 * - Linear scan: Time O(n), Space O(1). For n = 10^6 and frequent queries, O(q * n) is far too slow.
 * - Binary search solution: Time O(log n) per query, Space O(1).
 * 
 * Handling duplicate values at band edges:
 * - Lower bound: Finds the first index i such that scores[i] >= low.
 * - Upper bound: Finds the first index j such that scores[j] > high.
 * - The count of scores in [low, high] is j - i.
 */
public class ExamScoreBandCounter {

    /**
     * Counts the number of scores in the inclusive range [low, high].
     *
     * @param scores sorted array of exam scores in ascending order
     * @param low    lower bound of score range
     * @param high   upper bound of score range
     * @return number of scores within [low, high]
     */
    public static int countInBand(int[] scores, int low, int high) {
        if (scores == null || scores.length == 0 || low > high) {
            return 0;
        }

        int lowerIndex = lowerBound(scores, low);
        int upperIndex = upperBound(scores, high);

        return upperIndex - lowerIndex;
    }

    /**
     * Finds the first position where scores[i] >= target.
     */
    private static int lowerBound(int[] scores, int target) {
        int left = 0;
        int right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    /**
     * Finds the first position where scores[i] > target.
     */
    private static int upperBound(int[] scores, int target) {
        int left = 0;
        int right = scores.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};

        System.out.println(countInBand(scores, 42, 58)); // Expected: 6
        System.out.println(countInBand(scores, 90, 100)); // Expected: 0
    }
}
