
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
        
    }
    
    // Add reference to reference list
    public void addReference(Reference r) {
        this.references.put(r.getId(), r);
    }
    
    public void deleteReference(Reference r) {
        this.references.remove(r.getId());
    }
    
    public List<Reference> listReferences() {
        
        return null;
    }
}
