package ca.sheridancollege.project.objects.player;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Wenya Guo
 * @author Patrick Hogg
 */
public class Players {
    private List<GoFishPlayer> playerList;

    /**
     * Instantiates a new Players.
     */
    public Players() {
       this.playerList = new ArrayList<>();
    }

    /**
     * Gets player list.
     *
     * @return the player list
     */
    public List<GoFishPlayer> getPlayerList() {
        return playerList;
    }

    /**
     * Sets player list.
     *
     * @param playerList the player list
     */
    public void setPlayerList(List<GoFishPlayer> playerList) {
        this.playerList = playerList;
    }

    /**
     * Gets player from the list of players.
     *
     * @param player the player
     * @return the player
     */
    public GoFishPlayer getPlayer(GoFishPlayer player) {
        // Checks to see if the player list contains the provided player
        if (getPlayerList().contains(player)) {
            // Loop through all the players in the player list
            for (GoFishPlayer playerToFind : getPlayerList()) {
                // If the current player element is equal to the provided player
                if (playerToFind.equals(player)) {
                    // Return the current player element as it is the player
                    // that is being searched for
                    return playerToFind;
                }
            }
        }
        // otherwise return null as this player doesn't exist
        return null;
    }

    /**
     * Add player.
     *
     * @param player the player
     */
    public void addPlayer(GoFishPlayer player) {
        this.playerList.add(player);
    }

    /**
     * Remove player.
     *
     * @param player the player
     */
    public void removePlayer(GoFishPlayer player) {
        this.playerList.remove(player);
    }
}
