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
    
    private int year;
    private String author;
    private String title;
    private String publisher;
    
    public Book(int year, String author, String title,
                String publisher) {
        this.year = year;
        this.author = author;
        this.title = title;
        this.publisher = publisher;
    }
    
    @Override
    public void print() {
        
        System.out.println("@book{GA03,\n"
                + "author = {" + this.author + "}, \n"
                + "title = {" + this.title + "}, \n"
                + "publisher = {" + this.publisher + "}, \n"
                + "year = {" + this.year + "}, \n"
                + "} \n");
    }
}
