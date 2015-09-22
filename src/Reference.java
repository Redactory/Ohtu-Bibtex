
import java.util.Date;
import java.util.UUID;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author teemu
 */
public class Reference {
    
    String id;
    Date timestamp;
    
    public Reference() {
        this.id = UUID.randomUUID().toString();
        this.timestamp = new Date();
    }
    
    public String getId() {
        return this.id;
    }
    
    public void print() {
        
    }
}
