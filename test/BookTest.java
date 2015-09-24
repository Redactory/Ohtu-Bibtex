/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import reference.Book;
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
     * Test of print method, of class Book.
     */
    @Test
    public void testToBibTex() {
        System.out.println("toBibTex");
        Book instance = new Book(2011, "Jaakko Murmi", "", "ACM");
        String s = instance.toBibTex();
        //test correct format without taking fields into account

        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testToBibTexHasCorrectFormat() {
        System.out.println("toBibTex");
        Book instance = new Book(2011, "Jaakko Murmi", "Teokset 2", "ACM");
        String s = instance.toBibTex();
        //GA03 is temporarily id for all books
        //regex matching
        int ret = matchRegex(s, "@book[{]GA03,([\\s]*[a-zA-Z]+[\\s]*=[\\s]*[{][^}]+[}],)+[\\s]*[}][\\s]*");
        assertTrue("String is not in correct format", ret==s.length()-1);
    }

    @Test
    public void testToBibTexFieldsHaveCorrectValues() {
        fail("The test case is a prototype.");
    }

    
    /**
     * Checks if the given string matches the given pattern and returns the 
     * last index of the match. returns -1 if the pattern does not match.
     *
     * @param s
     * @param pattern
     * @return
     */
    private int matchRegex(String s, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(s);
        if (matcher.find()) {
            if (matcher.start() != 0) {
                return -1;
            }
            return matcher.end()-1;
        }
        return -1;
    }
}
