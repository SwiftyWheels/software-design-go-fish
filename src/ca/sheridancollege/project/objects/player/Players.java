package ca.sheridancollege.project.objects.player;

import java.util.ArrayList;
import java.util.List;

/**
 * This class +++ Insert class description here +++
 *
 * @author Wenya Guo
 */
public class Players {
    
    private List<Player> playerList;
    
    public Players(int n) {        
       this.playerList = new ArrayList<Player>(n);        
    }
    
    public void addPlayer(Player player) {
        this.playerList.add(player);
    }
    
    public List<Player> getPlayers() {
        return this.playerList;
    }

}
