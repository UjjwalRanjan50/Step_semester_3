package fantasy_league.assignment_problems;

public class DuplicatePlayerPickChecker {

    /**
     * Checks a submitted lineup for a repeated player name.
     *
     * @param playerNames Array of player names to check.
     * @return Message indicating the duplicate or lack thereof.
     */
    public static String findDuplicatePick(String[] playerNames) {
        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }
}
