/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Lutikka
 */
public final class ReferenceConverter {

    private static StringBuilder str;

    private ReferenceConverter() {

    }

    /**
     * Returns the reference in BibTex-formatted string
     *
     * @param ref
     * @return
     */
    public static String toBibTex(Reference ref) {
        if (ref.getClass().isAssignableFrom(Book.class)) {
            return bookToBibTex((Book) ref);
        } else if (ref.getClass().isAssignableFrom(Article.class)) {
            return articleToBibTex((Article) ref);
        } else if (ref.getClass().isAssignableFrom(Inproceeding.class)) {
            return inproceedingToBibTex((Inproceeding) ref);
        }
        return null;
    }

    public static String inproceedingToBibTex(Inproceeding i) {
        begin("inproceedings", i.getReference_id().toString());
        add("author", i.getAuthor());
        add("title", i.getTitle());
        add("booktitle", i.getBooktitle());
        if (i.getYear() != Integer.MIN_VALUE) {
            add("year", "" + i.getYear());
        }
        add("editor", i.getEditor());
        add("volume", i.getVolume());
        if (i.getNumber() != Integer.MIN_VALUE) {
            add("number", "" + i.getNumber());
        }
        add("series", i.getSeries());
        add("pages", i.getPages());
        add("address", i.getAddress());
        add("publisher", i.getPublisher());
        add("organization", i.getOrganization());
        add("month", i.getMonth());
        add("note", i.getNote());
        //add("key", i.getKey());
        return end();
    }

    public static String articleToBibTex(Article a) {
        begin("article", a.getReference_id().toString());
        //class incomplete
        add("author", a.getAuthor());
        add("title", a.getTitle());
        add("journal", a.getJournal());
        if (a.getYear() != Integer.MIN_VALUE) {
            add("year", "" + a.getYear());
        }
        add("volume", a.getVolume());
        if (a.getNumber() != Integer.MIN_VALUE) {
            add("number", "" + a.getNumber());
        }
        add("pages", a.getPages());
        add("month", a.getMonth());
        add("note", a.getNote());
        //add("key", a.getKey());
        return end();
    }

    /**
     * Returns the Model Book in BibTex-format.
     *
     * @param b
     * @return
     */
    public static String bookToBibTex(Book b) {
        begin("book", b.getReference_id().toString());
        add("author", b.getAuthor());
        add("editor", b.getEditor());
        add("title", b.getTitle());
        add("publisher", b.getPublisher());
        if (b.getYear() != Integer.MIN_VALUE) {
            add("year", "" + b.getYear());
        }
        add("volume", b.getVolume());
        add("number", b.getNumber());
        add("series", b.getSeries());
        add("address", b.getAddress());
        add("edition", b.getEdition());
        add("month", b.getMonth());
        add("note", b.getNote());
        return end();
    }

    public static List<Reference> bibTexToReference(String bibTex) {
        //split by @ char
        String[] publications = bibTex.split("@");
        List<Reference> refs = new LinkedList();
        
        for (int i = 1; i < publications.length; i++) {
            String publication = publications[i];
            String[] lines = publication.split("\\n");

            //extract ref name and id into refAndId array from first line
            String[] refAndId = lines[0].split("\\{");
            refAndId[1] = refAndId[1].replaceAll(",", "").trim();

            //extract attributes from the rest of the lines
            for (int j = 1; j < lines.length; j++) {
                lines[j] = lines[j].replaceAll("\\{|\\}", "").trim();
                if (lines[j].length() > 0 && lines[j].charAt(lines[j].length() - 1) == ',') {
                    lines[j] = lines[j].substring(0, lines[j].length() - 1);
                }
            }
            //construct Reference model
            if (refAndId[0].equals("book")) {
                Book b = new Book();
                for (int j = 1; j < lines.length - 1; j++) {
                    String[] attrs = lines[j].split("=");
                    attrs[0] = attrs[0].trim();
                    attrs[1] = attrs[1].trim();
                    addFieldToBook(b, attrs[0], attrs[1]);
                }
                refs.add(b);
            } else if (refAndId[0].equals("inproceedings")) {
                Inproceeding in = new Inproceeding();
                for (int j = 1; j < lines.length - 1; j++) {
                    String[] attrs = lines[j].split("=");
                    attrs[0] = attrs[0].trim();
                    attrs[1] = attrs[1].trim();
                    addFieldToInproceedings(in, attrs[0], attrs[1]);
                }
                refs.add(in);
            } else if (refAndId[0].equals("article")) {
                Article a = new Article();
                for (int j = 1; j < lines.length - 1; j++) {
                    String[] attrs = lines[j].split("=");
                    attrs[0] = attrs[0].trim();
                    attrs[1] = attrs[1].trim();
                    addFieldToArticle(a, attrs[0], attrs[1]);
                }
                refs.add(a);
            }
        }
        return refs;
    }

    private static void addFieldToInproceedings(Inproceeding i, String attr, String val) {
        if (attr.equals("year")) {
            i.setYear(Integer.parseInt(val));
        } else if (attr.equals("author")) {
            i.setAuthor(val);
        } else if (attr.equals("editor")) {
            i.setEditor(val);
        } else if (attr.equals("title")) {
            i.setTitle(val);
        } else if (attr.equals("booktitle")) {
            i.setBooktitle(val);
        } else if (attr.equals("publisher")) {
            i.setPublisher(val);
        } else if (attr.equals("volume")) {
            i.setVolume(val);
        } else if (attr.equals("number")) {
            i.setNumber(Integer.parseInt(val));
        } else if (attr.equals("series")) {
            i.setSeries(val);
        } else if (attr.equals("pages")) {
            i.setPages(val);
        } else if (attr.equals("address")) {
            i.setAddress(val);
        } else if (attr.equals("organization")) {
            i.setOrganization(val);
        } else if (attr.equals("month")) {
            i.setMonth(val);
        } else if (attr.equals("note")) {
            i.setNote(val);
        } else {
            System.out.println("Unspecified attribute name: " + attr);
        }
    }

    private static void addFieldToArticle(Article a, String attr, String val) {
        if (attr.equals("year")) {
            a.setYear(Integer.parseInt(val));
        } else if (attr.equals("author")) {
            a.setAuthor(val);
        } else if (attr.equals("title")) {
            a.setTitle(val);
        } else if (attr.equals("journal")) {
            a.setJournal(val);
        } else if (attr.equals("volume")) {
            a.setVolume(val);
        } else if (attr.equals("number")) {
            a.setNumber(Integer.parseInt(val));
        } else if (attr.equals("pages")) {
            a.setPages(val);
        } else if (attr.equals("month")) {
            a.setMonth(val);
        } else if (attr.equals("note")) {
            a.setNote(val);
        } else {
            System.out.println("Unspecified attribute name: " + attr);
        }
    }

    private static void addFieldToBook(Book b, String attr, String val) {
        if (attr.equals("year")) {
            b.setYear(Integer.parseInt(val));
        } else if (attr.equals("author")) {
            b.setAuthor(val);
        } else if (attr.equals("editor")) {
            b.setEditor(val);
        } else if (attr.equals("title")) {
            b.setTitle(val);
        } else if (attr.equals("publisher")) {
            b.setPublisher(val);
        } else if (attr.equals("volume")) {
            b.setVolume(val);
        } else if (attr.equals("number")) {
            b.setNumber(val);
        } else if (attr.equals("series")) {
            b.setSeries(val);
        } else if (attr.equals("address")) {
            b.setAddress(val);
        } else if (attr.equals("edition")) {
            b.setEdition(val);
        } else if (attr.equals("month")) {
            b.setMonth(val);
        } else if (attr.equals("note")) {
            b.setNote(val);
        } else {
            System.out.println("Unspecified attribute name: " + attr);
        }
    }

    /**
     * Adds a field to the Reference. Does not add anything if the field is
     * empty.
     *
     * @param attrName Such as author, title, series...
     * @param val Value of the attribute.
     */
    private static void add(String attrName, String val) {
        if (val.isEmpty()) {
            return;
        }
        str.append("  ");
        str.append(attrName);
        str.append(" = {");
        str.append(val);
        str.append("}, \n");
    }

    /**
     * Begins a new reference.
     *
     * @param referenceName Such as book, article, manual....
     * @param referenceId Id of the reference used to cite.
     */
    private static void begin(String referenceName, String referenceId) {
        str = new StringBuilder(256);
        str.append("@");
        str.append(referenceName);
        str.append("{");
        str.append(referenceId);
        str.append(",\n");
    }

    /**
     * Ends the reference and returns it.
     *
     * @return String in BibTex format
     */
    private static String end() {
        if (str == null) {
            return null;
        }
        str.append("} \n");
        String returnString = str.toString();
        str = null;
        return returnString;
    }

}
