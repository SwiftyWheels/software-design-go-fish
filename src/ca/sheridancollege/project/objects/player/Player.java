/**
 * SYST 17796 Project Base code. Students can modify and extend to implement
 * their game. Add your name as an author and the date!
 */
package ca.sheridancollege.project.objects.player;

import ca.sheridancollege.project.objects.card.Books;
import ca.sheridancollege.project.objects.card.HandCards;


/**
 * A class that models each Player in the game. 
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Wenya Guo 28-Jul-2022
 */
public abstract class Player {

    private String name; //the unique name for this player
    private Books books;
    private HandCards handcards;

    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */
    protected Player(String name, Books books, HandCards handcards) {
        this.name = name;
        this.books = books;
        this.handcards = handcards;
    }

    /**
     * @return the player name
     */
    public String getName() {
        return name;
    }

    /**
     * Ensure that the playerID is unique
     *
     * @param name the player name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
     public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    public HandCards getHandcards() {
        return handcards;
    }

    public void setHandcards(HandCards handcards) {
        this.handcards = handcards;
    }



}

