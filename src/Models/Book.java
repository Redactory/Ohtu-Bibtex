package Models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author teemu
 */
public class Book extends Reference {
    
    private String id;
    //  REQUIRED FIELDS
    private Integer year;
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
    
    public Book() {
        id = super.id;
        this.year = Integer.MIN_VALUE;
        this.author = "No Author";
        this.title = "Book of Empty";
        this.publisher = "Emptiness";
    }
    
    public Book(int year, String author, String title,
                String publisher) {
        this.year = year;
        this.author = author;
        this.title = title;
        this.publisher = publisher;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    /**
     * 
     * @return the book in BibTex format
     */
    public String toBibTex() {        
        return "@book{GA03,\n"
                + "  author = {" + this.author + "}, \n"
                + "  title = {" + this.title + "}, \n"
                + "  publisher = {" + this.publisher + "}, \n"
                + "  year = {" + this.year + "}, \n"
                + "} \n";
    }
    
    @Override
    public void print() {       
        System.out.println(toBibTex());
    }
}
