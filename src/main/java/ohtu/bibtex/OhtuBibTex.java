/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.ohtu.bibtex;

import java.io.File;
import java.util.List;
import main.java.IO.IO;
import main.java.Models.Container;
import main.java.Models.Reference;
import main.java.Models.ReferenceConverter;
import main.java.UI.UserInterface;


/**
 *
 * @author teemu
 */
public class OhtuBibTex {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {     
        UserInterface userInterface = new UserInterface();
        
        Container container = userInterface.getContainer();
        //Adding some book references
        String string = IO.readBibTexFile(new File("bib_data.bib"));
        List<Reference> refs = ReferenceConverter.bibTexToReference(string);
        for (Reference ref : refs) {
            container.addReference(ref);
        }
//        Book book1 = new Book(1997, "Jennifer Lowett", "I Burn For You", "Harlequin");
//        Book book2 = new Book(1889, "Don Rosa", "Life and Times of Scrooge McDuck", "Nothington");
//        Book book3 = new Book(2000, "Steve Hackwell", "Fount east of Altaria", "Baen");
//        book3.setNumber("2");
//        container.addReference(new Book(1896,"Jaakko","Jaakon selitykset","ACM"));
//        container.addReference(new Book(2001,"Martti Laaksonen","Taide","DELTA"));
//        Article a = new Article();
//        a.setAuthor("Tapio Kunnas");
//        a.setTitle("Ne laulut");
//        a.setYear(1995);
//        a.setJournal("Juu");
//        a.setPages("2");
//        
//        Inproceeding i = new Inproceeding();
//        i.setAuthor("Mikko Kuningas");
//        i.setTitle("Night coding");
//        i.setBooktitle("Progz");
//        i.setYear(2012);
//        i.setNote("note1");
//        container.addReference(i);
//        container.addReference(a);
//        
//        container.addReference(book1);
//        container.addReference(book2);
//        container.addReference(book3);
//        userInterface.getContainer().listReferences();
        userInterface.start();    
    }
}
