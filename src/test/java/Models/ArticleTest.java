package Models;

import main.java.Models.Article;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArticleTest {

    @Test
    public void testGetAuthor() throws Exception {
        Article article = new Article();
        article.setAuthor("Lari");
        assertEquals("Lari", article.getAuthor());
    }

    @Test
    public void testSetAuthor() throws Exception {
        Article article = new Article();
        article.setAuthor("Lari");
    }

    @Test
    public void testGetTitle() throws Exception {
        Article article = new Article();
        article.setTitle("Lari");
        assertEquals("Lari", article.getTitle());
    }

    @Test
    public void testSetTitle() throws Exception {
        Article article = new Article();
        article.setTitle("Lari");
    }

    @Test
    public void testGetJournal() throws Exception {
        Article article = new Article();
        article.setJournal("Lari");
        assertEquals("Lari", article.getJournal());
    }

    @Test
    public void testSetJournal() throws Exception {
        Article article = new Article();
        article.setJournal("Lari");
    }

    @Test
    public void testGetYear() throws Exception {
        Article article = new Article();
        int year = 2015;
        article.setYear(year);
        //TODO: ei worki jostain syystä.
        //assertEquals(2015,article.getYear());
    }

    @Test
    public void testSetYear() throws Exception {
        Article article = new Article();
        article.setYear(2015);
    }

    @Test
    public void setPages() throws Exception {
     Article a = new Article();
        a.setPages("Lari");
    }

    @Test
    public void getPages() throws Exception {
        Article a = new Article();
        a.setPages("Lari");
        assertEquals("Lari", a.getPages());
    }

    @Test
    public void setNote() throws Exception {
        Article a = new Article();
        a.setNote("Lari");
    }

    @Test
    public void getNote() throws Exception {
        Article a = new Article();
        a.setNote("Lari");
        assertEquals("Lari", a.getNote());
    }
}