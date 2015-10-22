/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import Models.Container;
import Models.Reference;
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
        Reference r = new Reference();
        r.setId(""+1);
        Container instance = new Container();
        instance.addReference(r);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        assertEquals(r, instance.getReferences().get(r.getId()));
    }

    /**
     * Test of deleteReference method, of class Container.
     */
    @Test
    public void testDeleteReference() {
        System.out.println("deleteReference");
        Reference r = new Reference();
        r.setId(""+1);
        Container instance = new Container();
        instance.addReference(r);
        instance.deleteReference(r);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(null, instance.getReferences().get(r.getId()));
    }

    /**
     * Test of listReferences method, of class Container.
     */
    @Test
    public void testListReferences() {
        System.out.println("listReferences");
        Container instance = new Container();
        Reference r = new Reference();
        r.setId(""+1);
        List<Reference> expResult = new ArrayList<Reference>();
        instance.addReference(r);
        expResult.add(r);

        assertEquals(expResult, instance.listReferences());


    }
    
}
