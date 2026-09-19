package fantasy_league.assignment_problems;

import java.util.Arrays;

public class Player implements Comparable<Player> {
    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    /**
     * Checks if a player is draftable based strictly on experience.
     */
    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    /**
     * Checks if a player is draftable based on combined matches and fitness.
     */
    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    @Override
    public int compareTo(Player other) {
        // Rank by fantasy points (represented here by battingAverage) descending
        return Double.compare(other.battingAverage, this.battingAverage);
    }

    /**
     * Filters and ranks players according to auto-draft rules.
     */
    public static String draftAndRank(Player[] players) {
        // Count valid players to size our array precisely (as per 'no collections' spirit, 
        // though we could use ArrayList, manual sizing shows good array practice)
        int draftableCount = 0;
        for (Player p : players) {
            if (isDraftable(p.matchesPlayed) || isDraftable(p.matchesPlayed, p.injured)) {
                draftableCount++;
            }
        }

        Player[] draftable = new Player[draftableCount];
        int index = 0;
        for (Player p : players) {
            if (isDraftable(p.matchesPlayed) || isDraftable(p.matchesPlayed, p.injured)) {
                draftable[index++] = p;
            }
        }

        Arrays.sort(draftable);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < draftable.length; i++) {
            if (i > 0) sb.append(" | ");
            sb.append(i + 1).append(". ").append(draftable[i].name);
        }

        return sb.toString();
    }
}
