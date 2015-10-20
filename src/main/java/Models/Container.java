package Models;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author teemu
 */
public class Container {

    private Hashtable<String, Reference> references;

    public Container() {
        this.references = new Hashtable<String, Reference>();
    }

    // Getter method for getting references-list.
    public Hashtable getReferences() {
        return references;
    }

    // Add reference to reference to database.
    public void addReference(Reference r) {

        if (r.getId() == null) {
            addIdToRef(r);
        }
        references.put(r.getId(), r);
    }

    // Remove wanted reference from database.
    public void deleteReference(Reference r) {
        this.references.remove(r.getId());
    }

    // Method for listing references in database.
    public List<Reference> listReferences() {
        List<Reference> l = new ArrayList<Reference>();
        for (String k : references.keySet()) {
            Reference r = references.get(k);
            l.add(r);
        }
        return l;
    }

    public Boolean containsId(String id) {
        return references.containsKey(id);
    }

    /**
     * Returns the first word from String with words. Words are separated by
     * either whitespace or comma.
     *
     * @param words
     */
    private String getFirstWord(String words) {
        return words.split("[\\s,]")[0];
    }

    /**
     * Adds unique id field to Reference
     *
     * @param ref
     */
    private void addIdToRef(Reference ref) {
        String name = "";

        if (ref.getClass().isAssignableFrom(Book.class
        )) {
            Book book = (Book) ref;
            name = book.getAuthor();
        } else if (ref.getClass().isAssignableFrom(Article.class)) {
            Article article = (Article) ref;
            name = article.getAuthor();
        } else if (ref.getClass().isAssignableFrom(Inproceeding.class)) {
            Inproceeding inproceeding = (Inproceeding) ref;
            name = inproceeding.getAuthor();
        }

        long atomicNumber = 1;
        String test = getFirstWord(name);
        while (references.contains(test + atomicNumber)) {
            atomicNumber++;
        }
        ref.setId(test + atomicNumber);
    }
}
