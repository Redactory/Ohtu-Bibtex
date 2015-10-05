package main.java.Models;

import org.junit.Test;

import javax.naming.InsufficientResourcesException;

import static org.junit.Assert.*;

public class InproceedingTest {

    @Test
    public void testGetAuthor() throws Exception {
        Inproceeding i = new Inproceeding();
        i.setAuthor("Lari");
        assertEquals("Lari", i.getAuthor());
    }

    @Test
    public void testSetAuthor() throws Exception {
        Inproceeding i = new Inproceeding();
        i.setAuthor("Lari");
        assertEquals("Lari", i.getAuthor());
    }

    @Test
    public void testGetAndSetTitle() throws Exception {
        Inproceeding i = new Inproceeding();
        i.setTitle("Lari");
        assertEquals("Lari", i.getTitle());
    }

    @Test
    public void testGetAndSetBooktitle() throws Exception {
        Inproceeding i = new Inproceeding();
        i.setBooktitle("Lari");
        assertEquals("Lari", i.getBooktitle());
    }

    @Test
    public void testGetAndsetYear() throws Exception {
        Inproceeding i = new Inproceeding();
        i.setYear(2015);
        //TODO: ambiguous method blaa
    }

    @Test
    public void testGetAndSetEditor() throws Exception {
        Inproceeding i = new Inproceeding();
        i.setEditor("Lari");
        assertEquals("Lari", i.getEditor());
    }

    @Test
    public void testGetAndSetVolume() throws Exception {
        Inproceeding i = new Inproceeding();
        i.setVolume("Lari");
        assertEquals("Lari",i.getVolume());
    }

    @Test
    public void testGetAndSetNumber() throws Exception {
        Inproceeding i = new Inproceeding();
        i.setNumber(1);
       //TODO: ambiguous method
        //assertEquals(1,i.getNumber());
    }

    @Test
    public void testGetSeries() throws Exception {
        Inproceeding i = new Inproceeding();
        i.setSeries("Lari");
        assertEquals("Lari",i.getSeries());
    }

    @Test
    public void testGetAndSetPages() throws Exception {
        Inproceeding i = new Inproceeding();
        i.setPages("Lari");
        assertEquals("Lari", i.getPages());
    }

    @Test
    public void testGetAndSetAddress() throws Exception {
        Inproceeding i = new Inproceeding();
        i.setAddress("Lari");
        assertEquals("Lari", i.getAddress());
    }

    @Test
    public void testGetAndSetMonth() throws Exception {
        Inproceeding i = new Inproceeding();
        i.setMonth("Lari");
        assertEquals("Lari", i.getMonth());
    }

    @Test
    public void testGetAndSetOrganization() throws Exception {
        Inproceeding i = new Inproceeding();
        i.setOrganization("Lari");
        assertEquals("Lari", i.getOrganization());
    }

    @Test
    public void testGetAndSetPublisher() throws Exception {
        Inproceeding i = new Inproceeding();
        i.setPublisher("Lari");
        assertEquals("Lari", i.getPublisher());
    }

    @Test
    public void testGetAndSetNote() throws Exception {
        Inproceeding i = new Inproceeding();
        i.setNote("Lari");
        assertEquals("Lari", i.getNote());
    }
}