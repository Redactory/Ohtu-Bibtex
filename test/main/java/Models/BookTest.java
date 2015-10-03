/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.Models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    
     @Test
    public void testEmptyConstructor(){
        new Book();
    }

    @Test
    public void testAddFieldsLater(){
        Book b = new Book();
        b.setAuthor("Rali");
        b.setPublisher("Ralin kustantamo");
        b.setTitle("Lisaa minusta");
        b.setYear(1010);
    }

    @Test
    public void testPrint(){
        Book b = new Book();
        b.print();
    }

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
    
}
