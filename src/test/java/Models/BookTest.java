package Models;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Models.Book;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author teemu
 */
public class BookTest {

    public BookTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of toBibTex method, of class Book.
     */
    @Test
    public void testToBibTex() {
        System.out.println("toBibTex");
        Book instance = new Book(2011, "Jaakko Murmi", "", "ACM");
        String s = instance.toBibTex();
        //test correct format without taking fields into account
    }
    
    @Test
    public void testToBibTexHasCorrectFormat() {
        System.out.println("toBibTex");
        Book instance = new Book(2011, "Jaakko Nurmi", "Teokset 2", "ACM");
        String s = instance.toBibTex();
        //GA03 is temporarily id for all books
        //regex matching
       boolean testVal = matchRegex(s, "@book[{]GA03,([\\s]*[a-zA-Z]+[\\s]*=" +
               "[\\s]*[{][^}]+[}],)+[\\s]*[}][\\s]*");
       assertTrue("String is not in BibTex format", testVal);
    }

    @Test
    public void testToBibTexFieldsHaveCorrectValues() {
        fail("The test case is a prototype.");
    }

    /**
     * Checks if the given string matches the given pattern. 
     * Returns true if the string matches exactly or false if it does not match.
     *
     * @param s
     * @param pattern
     * @return
     */
    private boolean matchRegex(String s, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(s);
        if (matcher.find()) {
            if (matcher.start() != 0) {
                return false;
            }
            return (matcher.end()==s.length());
        }
        return false;
    }
}
