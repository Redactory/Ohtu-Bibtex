/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Models.Book;
import Models.Container;
import Models.Reference;
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
            for (Reference ref : this.container.listReferences()) {
                ref.print();
            }        
            start();
        } else {
            System.out.println("Program ends!");
            System.exit(0);
        }
    }

    // Method for adding book reference.
    public void addBookReference() {
        boolean ok = false;
        String choice = "";
        Book book = new Book();

        System.out.println("Input mandatory fields for book referece \n");
//        System.out.println("If you want to stop book creation, write 'halt' \n\n");

        // Add year to the book.
        String year = attributes.addYear();
        book.setYear(Integer.parseInt(year));

        // Add author or editor
        while (ok == false) {
            System.out.println("If you wish to add an author, press 'A'. \n");
            System.out.println("If you wish to add an editor, press 'E'. \n");
            choice = scanner.nextLine();

            if (choice.equals("A")) {
                String author = attributes.addAuthor();
                book.setAuthor(author);
                ok = true;
            } else if (choice.equals("E")) {
                String editor = attributes.addEditor();
                book.setEditor(editor);
                ok = true;
            } else {
                System.out.println("Invalid choice, try again! \n");
            }
        }

        ok = false;
        choice = "";

        String author = attributes.addAuthor();
        book.setAuthor(author);

        // Add title
        String title = attributes.addTitle();
        book.setTitle(title);

        // Add publisher
        String publisher = attributes.addPublisher();
        book.setPublisher(publisher);

        // Choice for either adding optional fields or not.
        while (ok == false) {
            System.out.println("Do you want to add optional fields too? Press 'Y' for yes"
                    + " or 'N' for no. \n");
            choice = scanner.nextLine();

            if (choice.equals("Y")) {
                book = addOptionalBookReferences(book);
                ok = true;
            } else if (choice.equals("N")) {
                ok = true;
            } else {
                System.out.println("Invalid choice, try again! \n");
            }

        }
        // Attribute definition ends, book is created.
        container.addReference(book);

        System.out.println("new book reference has been created!");
        System.out.println("There are now " + this.container.getReferences().size()
                + " references in the system.");

        start();
    }

    // Method for adding optional book references.
    private Book addOptionalBookReferences(Book book) {
        boolean ok = false;
        String choice = "";

        // Adding either volume or number to the reference.
        while (ok == false) {
            System.out.println("Do you want to add either Volume or Number attribute? Press 'Y' for yes"
                    + " or 'N' for no. \n");
            System.out.println("Press 'V' for volume or \n");
            System.out.println("Press 'N' for number or \n");
            System.out.println("Press 'S' to not choose either. \n");

            choice = scanner.nextLine();

            if (choice.equals("V")) {
                String volume = attributes.addVolume();
                book.setVolume(volume);
                ok = true;
            } else if (choice.equals("N")) {
                String number = attributes.addNumber();
                ok = true;
            } else if (choice.equals("S")) {
                ok = true;
            } else {
                System.out.println("Invalid choice, try again! \n");
            }

        }

        ok = false;
        choice = "";

        while (ok == false) {
            System.out.println("Do you want to add Series attribute? \n");
            System.out.println("Press 'V' for series or \n");
            System.out.println("Press 'S' to not choose either. \n");

            choice = scanner.nextLine();

            if (choice.equals("S")) {
                String series = attributes.addSeries();
                book.setSeries(series);
                ok = true;
            } else if (choice.equals("S")) {
                ok = true;
            } else {
                System.out.println("Invalid choice, try again! \n");
            }
        }
        
        ok = false;
        choice = "";

        while (ok == false) {
            System.out.println("Do you want to add Address attribute? \n");
            System.out.println("Press 'A' for address or \n");
            System.out.println("Press 'S' to skip. \n");

            choice = scanner.nextLine();

            if (choice.equals("A")) {
                String address = attributes.addAddress();
                book.setAddress(address);
                ok = true;
            } else if (choice.equals("S")) {
                ok = true;
            } else {
                System.out.println("Invalid choice, try again! \n");
            }
        }

        ok = false;
        choice = "";

        while (ok == false) {
            System.out.println("Do you want to add Edition attribute? \n");
            System.out.println("Press 'E' for edition or \n");
            System.out.println("Press 'S' to skip. \n");

            choice = scanner.nextLine();

            if (choice.equals("E")) {
                String edition = attributes.addEdition();
                book.setEdition(edition);
                ok = true;
            } else if (choice.equals("S")) {
                ok = true;
            } else {
                System.out.println("Invalid choice, try again! \n");
            }
        }

        ok = false;
        choice = "";

        while (ok == false) {
            System.out.println("Do you want to add Month attribute?. \n");
            System.out.println("Press 'M' for month or \n");
            System.out.println("Press 'S' to skip. \n");

            choice = scanner.nextLine();

            if (choice.equals("M")) {
                String month = attributes.addMonth();
                book.setMonth(month);
                ok = true;
            } else if (choice.equals("S")) {
                ok = true;
            } else {
                System.out.println("Invalid choice, try again! \n");
            }
        }

        ok = false;
        choice = "";

        while (ok == false) {
            System.out.println("Do you want to add Note attribute? \n");
            System.out.println("Press 'N' for note or \n");
            System.out.println("Press 'S' to skip. \n");

            choice = scanner.nextLine();

            if (choice.equals("N")) {
                String note = attributes.addNote();
                book.setNote(note);
                ok = true;
            } else if (choice.equals("S")) {
                ok = true;
            } else {
                System.out.println("Invalid choice, try again! \n");
            }
        }

        return book;
    }
    
    // Method for adding article-references.
    public void addArticleReference() {
        
    }
    
    // Method for adding inproceeding-references
    public void addInproceedingReference() {
        
    }
}
