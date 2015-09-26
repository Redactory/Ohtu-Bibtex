/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.bibtex;

import Models.Book;
import Models.Container;
import UI.UserInterface;

/**
 *
 * @author teemu
 */
public class OhtuBibTex {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        UserInterface userInterface = new UserInterface();
        
        Container container = userInterface.getContainer();
        
        // Adding some book references.
        Book book1 = new Book(1997, "Jennifer Lowett", "I Burn For You", "Harlequin");
        Book book2 = new Book(1889, "Don Rosa", "Life and Times of Scrooge McDuck", "Nothington");
        Book book3 = new Book(2000, "Steve Hackwell", "Fount east of Altaria", "Baen");
        
        container.addReference(book1);
        container.addReference(book2);
        container.addReference(book3);
        
//        userInterface.getContainer().listReferences();
        userInterface.start();
        
    }
    
}
