package Models;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReferenceConverterTest {

    @Test
    public void testToBibTex() throws Exception {

    }

    @Test
    public void testInproceedingToBibTex() throws Exception {

    }

    @Test
    public void testArticleToBibTex() throws Exception {

    }

    @Test
    public void testBookToBibTex() throws Exception {

    }

    /**
     * Checks if the given string matches the given pattern. Returns true if the
     * string matches exactly or false if it does not match.
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
            return (matcher.end() == s.length());
        }
        return false;
    }

    @Test
    public void testInproceedingsToBibTexHasCorrectFormat() {
        System.out.println("toBibTex");
        Inproceeding instance = new Inproceeding();
        instance.setAuthor("Minna Juoni");
        instance.setId("Minna1");
        instance.setTitle("Hiton Bibtex");
        instance.setBooktitle("latex markkinat");
        instance.setYear(12345678);
        instance.setVolume("5.");
        instance.setNumber(9);
        instance.setPages("10");
        instance.setMonth("Lokakuu");
        instance.setNote("Juuh...sellasta");
        
        String s = ReferenceConverter.inproceedingToBibTex(instance);
        //regex matching
        boolean testVal = matchRegex(s, "@inproceedings[{][\\p{L}]+[0-9]+,([\\s]*[a-zA-Z]+[\\s]*="
                + "[\\s]*[{][^}]+[}],)+[\\s]*[}][\\s]*");
        assertTrue("String is not in BibTex format", testVal);
    }
    
    @Test
    public void testArticleToBibTexHasCorrectFormat() {
        System.out.println("toBibTex");
        Article instance = new Article();
        instance.setAuthor("Minna Juoni");
        instance.setId("Minna1");
        instance.setTitle("Hiton Bibtex");
        instance.setJournal("kinostuksen ässälehti");
        instance.setYear(12345678);
        instance.setVolume("5.");
        instance.setNumber(9);
        instance.setPages("10");
        instance.setMonth("Lokakuu");
        instance.setNote("Juuh...");
        
        String s = ReferenceConverter.articleToBibTex(instance);
        //regex matching
        boolean testVal = matchRegex(s, "@article[{][\\p{L}]+[0-9]+,([\\s]*[a-zA-Z]+[\\s]*="
                + "[\\s]*[{][^}]+[}],)+[\\s]*[}][\\s]*");
        assertTrue("String is not in BibTex format", testVal);
    }

    @Test
    public void testBookToBibTexHasCorrectFormat() {
        System.out.println("toBibTex");
        Book instance = new Book(2011, "Jaakko Nurmi", "Teokset 2", "ACM");
        instance.setId("Jaakko1");
        String s = ReferenceConverter.bookToBibTex(instance);
        //regex matching
        boolean testVal = matchRegex(s, "@book[{][\\p{L}]+[0-9]+,([\\s]*[a-zA-Z]+[\\s]*="
                + "[\\s]*[{][^}]+[}],)+[\\s]*[}][\\s]*");
        assertTrue("String is not in BibTex format", testVal);
    }
}
