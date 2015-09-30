/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.util.Scanner;

/**
 *
 * @author teemu
 */
public class AttributeAdditionMethods {

    private String regex;
    private Scanner scanner;

    public AttributeAdditionMethods() {
        regex = "";
        scanner = new Scanner(System.in);
    }

    // Add year to the reference.
    public String addYear() {
        regex = "[0-9]+";
        String year = "";

        while (true) {
            System.out.println("Give the year to be added: \n");
            year = this.scanner.nextLine();
            if (year.matches(regex)) {
                break;
            }
            System.out.println("\nInvalid input\n");
        }

        return year;
    }

    // Add author to reference.
    public String addAuthor() {
        regex = "([a-zA-Z]+[\\s]*)+";
        String author;
        
        while (true) {
            System.out.println("Give book author:\n");
            author = this.scanner.nextLine();
            if (author.matches(regex)) {
                break;
            }
            System.out.println("\nInvalid input\n");

        }

        return author;
    }

    // Add title to reference.
    public String addTitle() {
        regex = "([a-zA-Z0-9]+[\\s]*)+";
        String title = "";
        
        while (true) {
            System.out.println("Give book title:\n");
            title = this.scanner.nextLine();
            if (title.matches(regex)) {
                break;
            }
            System.out.println("\nInvalid input\n");
        }

        return title;
    }
    
    // Add publisher to reference.
    public String addPublisher() {
        String publisher = "";    
        
        while (true) {
            System.out.println("Give book publisher:\n");
            publisher = this.scanner.nextLine();
            if (publisher.matches(regex)) {
                break;
            }
            System.out.println("\nInvalid input\n");
        }
    
        return publisher;
    }
}
