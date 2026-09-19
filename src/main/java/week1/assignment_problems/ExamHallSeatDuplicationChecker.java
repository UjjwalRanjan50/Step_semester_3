package week1.assignment_problems;

public class ExamHallSeatDuplicationChecker {

    /**
     * Checks for duplicate seat numbers in an exam hall seating arrangement.
     *
     * @param seatNumbers the array of assigned seat numbers
     */
    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean duplicateFound = false;
        
        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    duplicateFound = true;
                    // We can either break to avoid printing the same pair multiple times,
                    // but the problem implies we can just print duplicates.
                    // For safety, let's break out of inner loop after finding the first match for seatNumbers[i]
                    break;
                }
            }
        }
        
        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }
}
