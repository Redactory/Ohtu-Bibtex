/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.Models;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author teemu
 */
public class Generator {
    
    private static AtomicInteger generator = new AtomicInteger();
    
    public Generator() {

    }
    
    public static Integer generateReferenceId() {
        if (generator == null) {
            System.out.println("ON null!");
        }
        
        Integer luku = generator.incrementAndGet();
        return luku;
    }
}
