/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Models.Book;
import Models.Container;
import java.util.Scanner;

/**
 *
 * @author teemu
 */
public class UserInterface {
    
    // User interface container object.
    Container container;
    
    // Scanner object for reading input.
    Scanner scanner;
    
    public UserInterface() {
        container = new Container();
        scanner = new Scanner(System.in);
    }
    
    public Container getContainer() {
        return this.container;
    }
    
    public void start() {        
        System.out.println("MAIN MENU \n");
        System.out.println("You can perform following actions. "
                + "Press the key in the wave-bracket:");
        System.out.println("- Add a book reference (B) \n");
        System.out.println("- List existing references (L) \n");
        
        String answer = this.scanner.next();
        
        if (answer.equals("B")) {
            addBookReference();
        } else if (answer.equals("L")) {
            this.container.listReferences();
            start();
        } else {
            System.out.println("Program ends!");
            System.exit(0);
        }
    }
    
    // Method for adding book reference.
    public void addBookReference() {
        Book book = new Book();
        
        System.out.println("Input mandatory fields for book referece \n");
//        System.out.println("If you want to stop book creation, write 'halt' \n\n");
        System.out.println("Give year book is written: \n");
        
        // Add year to the book.
        Integer year = this.scanner.nextInt();
        book.setYear(year);
        
        // Add author
        System.out.println("Give book author:\n");
        String author = this.scanner.next();
        book.setAuthor(author);
        
        // Add title
        System.out.println("Give book title:\n");
        String title = this.scanner.next();
        book.setTitle(title);
        
        // Add publisher
        System.out.println("Give book publisher:\n");
        String publisher = this.scanner.next();
        book.setPublisher(publisher);
        
        container.addReference(book);
        
        System.out.println("new book reference has been created!");
        System.out.println("There are now " + this.container.getReferences().size() + 
                " references in the system.");
        
        start();
    }
}
