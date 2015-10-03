package main.java.Models;


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
            r.print();
            l.add(r);
        }
        return l;
    }
}
