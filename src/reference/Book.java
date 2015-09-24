package reference;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author teemu
 */
public class Book extends Reference{
    //  REQUIRED FIELDS
    private int year;
    private String author;//or editor
    private String title;
    private String publisher;
    //  OPTIONAL FIELDS
    //volume or number
    //series
    //address
    //edition
    //month
    //note
    
    public Book(int year, String author, String title,
                String publisher) {
        this.year = year;
        this.author = author;
        this.title = title;
        this.publisher = publisher;
    }
    /**
     * 
     * @return the book in BibTex format
     */
    @Override
    public String toBibTex() {        
        return "@book{GA03,\n"
                + "  author = {" + this.author + "}, \n"
                + "  title = {" + this.title + "}, \n"
                + "  publisher = {" + this.publisher + "}, \n"
                + "  year = {" + this.year + "}, \n"
                + "} \n";
    }
    
    //parempi antaa komentorivin koodin printata
    /*
    @Override
    public String print() {        
        System.out.println("@book{GA03,\n"
                + "  author = {" + this.author + "}, \n"
                + "  title = {" + this.title + "}, \n"
                + "  publisher = {" + this.publisher + "}, \n"
                + "  year = {" + this.year + "}, \n"
                + "} \n");
    }
    */
}
