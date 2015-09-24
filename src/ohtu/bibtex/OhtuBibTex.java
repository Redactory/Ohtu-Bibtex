/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.bibtex;

import java.util.List;
import reference.Book;
import reference.Container;
import reference.Reference;

/**
 *
 * @author teemu
 */
public class OhtuBibTex {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //test
        Container cont = new Container();
        cont.addReference(new Book(1234,"Jaakko","Jaakon höpötykset","ACM"));
        cont.addReference(new Book(2001,"Martti Laaksonen","Taide","DELTA"));
        List<Reference> list = cont.listReferences();
        for (Reference ref : list) {
            System.out.println(ref.toBibTex());
        }
        System.out.println("////////////////////////////////////////////////");
        //real code
        
        //TODO komentoriviUI
        
    }
}
