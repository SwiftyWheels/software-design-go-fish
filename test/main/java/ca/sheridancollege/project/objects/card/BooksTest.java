/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package main.java.ca.sheridancollege.project.objects.card;

import ca.sheridancollege.project.enums.CardValue;
import ca.sheridancollege.project.objects.card.Book;
import ca.sheridancollege.project.objects.card.Books;
import ca.sheridancollege.project.objects.card.Card;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Peter Dropulic
 */
public class BooksTest {
    
    public BooksTest() {
    }
    
    /**
     *Good Test of getBookList method, of class Books.
     */
    @Test
    public void testGetBookListGood() {
        System.out.println("getBookListGood");
        Books instance = new Books();
        List<Book> expResult = new ArrayList<>();
        List<Book> result = instance.getBookList();
        assertEquals(expResult, result);
    }

    /**
     *Bad Test of equals method, of class Books.
     */
    @Test
    public void testEqualsBad() {
        System.out.println("equalsBad");
        Object o = null;
        Books instance = new Books();
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertNotEquals(expResult, result);
    }
    
    /**
     *Good Test of equals method, of class Books.
     */
    @Test
    public void testEqualsGood() {
        System.out.println("equalsGood");
        Object o = new Books();
        Books instance = new Books();
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

}
