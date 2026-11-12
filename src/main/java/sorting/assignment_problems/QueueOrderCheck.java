package sorting.assignment_problems;

/**
 * Problem 4: Is the Queue in Order?
 * 
 * Verifies if students in a queue stand in non-decreasing order of token numbers.
 * Identifies the position of the first student who breaks the ordered queue.
 */
public class QueueOrderCheck {

    /**
     * Finds the index of the first token that is smaller than the preceding token.
     *
     * @param tokens array of token numbers
     * @return index of the first break, or -1 if the queue is in order
     */
    public static int firstBreak(int[] tokens) {
        if (tokens == null || tokens.length <= 1) {
            return -1;
        }

        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i] < tokens[i - 1]) {
                return i;
            }
        }

        return -1;
    }

    public static void checkQueue(int[] tokens) {
        int idx = firstBreak(tokens);
        if (idx == -1) {
            System.out.println("-1");
        } else {
            System.out.println(idx + " (" + tokens[idx] + " comes after " + tokens[idx - 1] + ")");
        }
    }

    public static void main(String[] args) {
        System.out.println("Sample 1:");
        int[] tokens1 = {3, 5, 5, 8, 6, 9};
        checkQueue(tokens1);

        System.out.println("\nSample 2:");
        int[] tokens2 = {1, 2, 2, 7};
        checkQueue(tokens2);

        System.out.println("\nCustom Input (Unsorted at beginning):");
        int[] tokensCustom1 = {10, 5, 12, 15};
        checkQueue(tokensCustom1);

        System.out.println("\nCustom Input (Single element):");
        int[] tokensCustom2 = {42};
        checkQueue(tokensCustom2);
    }
}
