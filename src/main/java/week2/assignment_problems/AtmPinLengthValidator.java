package week2.assignment_problems;

public class AtmPinLengthValidator {

    /**
     * Checks that the PIN is exactly 4 digits long.
     *
     * @param pin The ATM PIN as a string.
     */
    public static void checkPinLength(String pin) {
        if (pin != null && pin.length() == 4) {
            System.out.println("PIN length OK.");
        } else {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        }
    }
}
