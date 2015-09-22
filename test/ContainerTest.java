/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
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
public class ContainerTest {
    
    public ContainerTest() {
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
     * Test of addReference method, of class Container.
     */
    @Test
    public void testAddReference() {
        System.out.println("addReference");
        Reference r = null;
        Container instance = new Container();
        instance.addReference(r);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteReference method, of class Container.
     */
    @Test
    public void testDeleteReference() {
        System.out.println("deleteReference");
        Reference r = null;
        Container instance = new Container();
        instance.deleteReference(r);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listReferences method, of class Container.
     */
    @Test
    public void testListReferences() {
        System.out.println("listReferences");
        Container instance = new Container();
        List<Reference> expResult = null;
        List<Reference> result = instance.listReferences();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
