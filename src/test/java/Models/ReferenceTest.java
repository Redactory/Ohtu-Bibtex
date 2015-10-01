package Models;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Models.Reference;
import org.junit.*;

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
    public void testGetId() {
        System.out.println("getId");
        Reference instance = new Reference();
        String expResult = "";
        String result = instance.getId();

        // TODO review the generated test code and remove the default call to fail.
        assertEquals(true, !result.isEmpty());
    }

    /**
     * Test of print method, of class Reference.
     */
    public void testPrint() {
        System.out.println("print");
        Reference instance = new Reference();
        instance.print();
        // TODO review the generated test code and remove the default call to fail.

    }

}