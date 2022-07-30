package ca.sheridancollege.project.objects.card;

import java.util.List;

/**
 * This class +++ Insert class description here +++
 *
 * @author Wenya Guo
 */
public class HandCards {
    
    private List<Card> handCards;
    
    public HandCards(List<Card> handCards) {
        this.handCards = handCards;
    }
    
    public List<Card> getHandCards() {
        return this.handCards;
    }
    
    public void setHandCards(List<Card> handCards) {
        this.handCards = handCards;
    }
}
