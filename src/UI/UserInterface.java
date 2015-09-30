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

    // Object for managing attribute addition to references.
    AttributeAdditionMethods attributes;
    
    public UserInterface() {
        container = new Container();
        scanner = new Scanner(System.in);
        attributes = new AttributeAdditionMethods();
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

        String answer = this.scanner.nextLine();

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

        // Add year to the book.
        String year = attributes.addYear();
        book.setYear(Integer.parseInt(year));

        // Add author
        String author = attributes.addAuthor();
        book.setAuthor(author);
       
        // Add title
        String title = attributes.addTitle();
        book.setTitle(title);
                
        // Add publisher
        String publisher = attributes.addPublisher();
        book.setPublisher(publisher);
        
        // Attribute definition ends, book is created.
        container.addReference(book);

        System.out.println("new book reference has been created!");
        System.out.println("There are now " + this.container.getReferences().size()
                + " references in the system.");

        start();
    }
}
