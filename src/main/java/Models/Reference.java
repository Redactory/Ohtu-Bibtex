package main.java.Models;


import java.util.Date;
import java.util.UUID;
import main.java.Models.Generator;

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
    
    private String id;
    private Date timestamp;
    private Integer reference_id;
    
    public Reference() {
        this.id = UUID.randomUUID().toString();
        this.timestamp = new Date();
        reference_id = Generator.generateReferenceId();
    }
    
    public String getId() {
        return this.id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getReference_id() {
        return reference_id;
    }

    public void setReference_id(Integer reference_id) {
        this.reference_id = reference_id;
    }
    
    

    // OTHER METHODS
    
    public void print() {
        
    }    
}
