/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.Models;

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
