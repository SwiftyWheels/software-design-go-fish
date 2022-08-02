package ca.sheridancollege.project.objects.card;

import ca.sheridancollege.project.enums.CardValue;
import ca.sheridancollege.project.interfaces.book.BooksActions;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * This class +++ Insert class description here +++
 *
 * @author Wenya Guo
 * @author Patrick Hogg
 */
public class Books implements BooksActions {

    /**
     * The Book list.
     */
    List<Book> bookList;

    /**
     * Instantiates a new Books object with an empty bookList.
     */
    public Books() {
        this.bookList = new ArrayList<>();
    }

    /**
     * Instantiates a new Books object with a list of Books.
     *
     * @param bookList the book list
     */
    public Books(List<Book> bookList) {
        this.bookList = bookList;
    }

    /**
     * Gets book list.
     *
     * @return the book list
     */
    public List<Book> getBookList() {
        return bookList;
    }

    /**
     * Sets book list.
     *
     * @param bookList the book list
     */
    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public void createBook(List<Card> cardList, CardValue cardValue) {
        // Loop through all cards in the list provided
        for (Card card : cardList) {
            // If the card values do not match
            if (card.getCardValue() != cardValue) {
                // Exit out of the loop and method
                return;
            }
        }
        System.out.println("Creating a book with: " + cardList);
        // Otherwise, create a new book using the provided list of Cards
        getBookList().add(new Book(cardList));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Books books)) {
            return false;
        }
        return Objects.equals(bookList, books.bookList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookList);
    }

    @Override
    public String toString() {
        return "Books{" + "size: " + bookList.size() + " bookList=" + bookList
               + '}';
    }
}

