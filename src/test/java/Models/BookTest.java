package Models;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Models.Book;
import Models.ReferenceConverter;
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
    public void testToBibTex() {
        System.out.println("toBibTex");
        Book instance = new Book(2011, "Jaakko Murmi", "", "ACM");
        //String s = instance.toBibTex();
        //test correct format without taking fields into account
    }  
}
