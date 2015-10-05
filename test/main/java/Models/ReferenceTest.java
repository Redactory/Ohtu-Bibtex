/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.Models;

import java.util.Date;
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
public class ReferenceTest {
    
    public ReferenceTest() {
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
     * Test of getId method, of class Reference.
     */
    @Test
    public void testGetId() throws Exception {
        System.out.println("getId");
        Reference instance = new Reference();
        String expResult = "";
        String result = instance.getId();

        assertEquals(true, !result.isEmpty());
    }

    /**
     * Test of print method, of class Reference.
     */
    @Test
    public void testPrint() throws Exception {
        System.out.println("print");
        Reference instance = new Reference();
        instance.print();
    }

    @Test
    public void testSetTimestamp() throws Exception {
        Reference r = new Reference();
        r.setTimestamp(new Date());
    }

    @Test
    public void testSetReferenceId() throws Exception {
        Reference r = new Reference();
        r.setReference_id(1);
    }
    
}
