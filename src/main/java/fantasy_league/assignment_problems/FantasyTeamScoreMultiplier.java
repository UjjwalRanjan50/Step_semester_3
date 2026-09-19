package fantasy_league.assignment_problems;

public class FantasyTeamScoreMultiplier {

    /**
     * Applies multipliers directly to the original array for Captain (2x) and Vice-Captain (1.5x).
     *
     * @param playerScores     The scores array to modify directly.
     * @param captainIndex     The index of the captain.
     * @param viceCaptainIndex The index of the vice-captain.
     */
    public static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        if (captainIndex >= 0 && captainIndex < playerScores.length) {
            playerScores[captainIndex] *= 2.0;
        }
        if (viceCaptainIndex >= 0 && viceCaptainIndex < playerScores.length) {
            playerScores[viceCaptainIndex] *= 1.5;
        }
    }
}
