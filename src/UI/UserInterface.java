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
        String regex;
        System.out.println("Input mandatory fields for book referece \n");
//        System.out.println("If you want to stop book creation, write 'halt' \n\n");

        // Add year to the book.
        regex = "[0-9]+";
        while (true) {
            System.out.println("Give the year in which the book was published: \n");
            String year = this.scanner.nextLine();
            if (year.matches(regex)) {
                book.setYear(Integer.parseInt(year));
                break;
            }
            System.out.println("Invalid input");
        }

        // Add author
        regex = "([a-zA-Z]+[\\s]*)+";
        while (true) {
            System.out.println("Give book author:\n");
            String author = this.scanner.nextLine();
            if (author.matches(regex)) {
                book.setAuthor(author);
                break;
            }
            System.out.println("Invalid input");

        }
        // Add title
        while (true) {
            System.out.println("Give book title:\n");
            String title = this.scanner.nextLine();
            if (title.matches(regex)) {
                book.setTitle(title);
                break;
            }
            System.out.println("Invalid input");
        }
        // Add publisher
        while (true) {
            System.out.println("Give book publisher:\n");
            String publisher = this.scanner.nextLine();
            if (publisher.matches(regex)) {
                book.setPublisher(publisher);
                break;
            }
            System.out.println("Invalid input");
        }
        container.addReference(book);

        System.out.println("new book reference has been created!");
        System.out.println("There are now " + this.container.getReferences().size()
                + " references in the system.");

        start();
    }
}
