/**
 * SYST 17796 Project Base code. Students can modify and extend to implement
 * their game. Add your name as an author and the date!
 */
package ca.sheridancollege.project.objects.player;

import ca.sheridancollege.project.interfaces.player.PlayerActions;
import ca.sheridancollege.project.objects.card.Books;
import ca.sheridancollege.project.objects.card.HandCards;

import java.util.Objects;


/**
 * A class that models each Player in the game.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Wenya Guo 28-Jul-2022
 * @author Patrick Hogg
 */
public abstract class Player implements PlayerActions {
    private String name;
    private Books books;
    private HandCards handCards;

    protected Player() {
    }

    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */
    protected Player(String name) {
        this.name = name;
        this.books = new Books();
        this.handCards = new HandCards();
    }

    /**
     * Instantiates a new Player with provided arguments.
     *
     * @param name      the name of the player
     * @param books     the books of the player
     * @param handCards the hand cards of the player
     */
    protected Player(String name, Books books, HandCards handCards) {
        this.name = name;
        this.books = books;
        this.handCards = handCards;
    }

    /**
     * Gets name.
     *
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

    /**
     * Gets books.
     *
     * @return the books
     */
    public Books getBooks() {
        return books;
    }

    /**
     * Sets books.
     *
     * @param books the books
     */
    public void setBooks(Books books) {
        this.books = books;
    }

    /**
     * Gets hand cards.
     *
     * @return the hand cards
     */
    public HandCards getHandCards() {
        return handCards;
    }

    /**
     * Sets hand cards.
     *
     * @param handCards the hand cards
     */
    public void setHandCards(HandCards handCards) {
        this.handCards = handCards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Player player)) {
            return false;
        }
        return Objects.equals(name, player.name) && Objects.equals(books,
                                                                   player.books)
               && Objects.equals(handCards, player.handCards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, books, handCards);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Player{" + "name='").append(name).append("'\n");
        stringBuilder.append("Cards in Hand: {\n");
        handCards.getCards().forEach(
                card -> stringBuilder.append(card).append("\n"));
        stringBuilder.append("}\n");
        stringBuilder.append("Books Made: ={\n");
        books.getBookList().forEach(
                book -> stringBuilder.append(book).append("\n"));
        stringBuilder.append("}\n");

        return stringBuilder.toString();
    }
}

