package main.java.UI;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import main.java.IO.IO;
import main.java.Models.*;
import main.java.UI.AttributeAdditionMethods;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.



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
        System.out.println("- Add an article reference (A) \n");
        System.out.println("- Add an inproceeding reference (I) \n");
        System.out.println("- Update a reference (U) \n");
        System.out.println("- List existing references (L) \n");
        System.out.println("- Export existing references to file (export) \n");
        System.out.println("- End the program (press any other key) \n");

        String answer = this.scanner.nextLine();

        if (answer.equals("B")) {
            addBookReference();
        } else if (answer.equals("A")) {
            addArticleReference();
        } else if (answer.equals("I")) {
            addInproceedingReference();
        } else if (answer.equals("U")) {
            updateReference();
            start();
        } else if (answer.equals("L")) {
            for (Reference ref : this.container.listReferences()) {
                System.out.println(ReferenceConverter.toBibTex(ref));
            }
            start();
        } else if (answer.equals("export")) {
            System.out.println("Enter filename:");
            answer = "";
            answer = scanner.nextLine();
            IO.exportToBibTex(new File(answer), container.listReferences());
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

        System.out.println("Input mandatory fields for book reference \n");

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
//what is this?
//            System.out.println("Do you want to add either Volume or Number attribute? Press 'Y' for yes"
//                    + " or 'N' for no. \n");
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

        //SERIES
        while (ok == false) {
            System.out.println("Do you want to add Series attribute? \n");
            System.out.println("Press 'V' for series or \n");
            System.out.println("Press 'S' to not choose either. \n");

            choice = scanner.nextLine();

            if (choice.equals("V")) {
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
        //ADDRESS
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
        //EDITION
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
        //MONTH
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
        //NOTE
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
    private void addArticleReference() {
        boolean ok = false;
        String choice = "";
        Article article = new Article();

        System.out.println("Input mandatory fields for article reference: \n");

        // Add author
        String author = attributes.addAuthor();
        article.setAuthor(author);

        // Add title
        String title = attributes.addTitle();
        article.setTitle(title);

        // add journal
        String journal = attributes.addJournal();
        article.setJournal(journal);

        // add year
        String year = attributes.addYear();
        article.setYear(Integer.parseInt(year));

        // Choice for either adding optional fields or not.
        while (ok == false) {
            System.out.println("Do you want to add optional fields too? Press 'Y' for yes"
                    + " or 'N' for no. \n");
            choice = scanner.nextLine();

            if (choice.equals("Y")) {
                article = addOptionalArticleReferences(article);
                ok = true;
            } else if (choice.equals("N")) {
                ok = true;
            } else {
                System.out.println("Invalid choice, try again! \n");
            }

        }

        // Attribute definition ends, article is created.
        container.addReference(article);

        System.out.println("A new article reference has been created!");
        System.out.println("There are now " + this.container.getReferences().size()
                + " references in the system.");

        start();
    }

    // Method for adding optional article attributes.
    private Article addOptionalArticleReferences(Article article) {
        boolean ok = false;
        String choice = "";

        System.out.println("Input optional fields for article reference: \n");

        // Add volume
        while (ok == false) {
            System.out.println("Do you want to add attribute for volume? \n");
            System.out.println("Select (V) for yes and (S) to skip. \n");
            choice = scanner.nextLine();

            if (choice.equals("V")) {
                String volume = attributes.addVolume();
                article.setVolume(volume);
                ok = true;
            } else if (choice.equals("S")) {
                ok = true;
            } else {
                System.out.println("Invalid choice!\n");
            }
        }

        ok = false;
        choice = "";

        // Add number
        while (ok == false) {
            System.out.println("Do you want to add attribute for number? \n");
            System.out.println("Select (N) for yes and (S) to skip. \n");
            choice = scanner.nextLine();

            if (choice.equals("N")) {
                String number = attributes.addNumber();
                article.setNumber(Integer.parseInt(number));
                ok = true;
            } else if (choice.equals("S")) {
                ok = true;
            } else {
                System.out.println("Invalid choice!\n");
            }
        }

        ok = false;
        choice = "";

        // Add pages
        while (ok == false) {
            System.out.println("Do you want to add attribute for pages? \n");
            System.out.println("Select (P) for yes and (S) to skip. \n");
            choice = scanner.nextLine();

            if (choice.equals("P")) {
                String pages = attributes.addPages();
                article.setPages(pages);
                ok = true;
            } else if (choice.equals("S")) {
                ok = true;
            } else {
                System.out.println("Invalid choice!\n");
            }
        }

        ok = false;
        choice = "";

        // Add month
        while (ok == false) {
            System.out.println("Do you want to add attribute for month? \n");
            System.out.println("Select (M) for yes and (S) to skip. \n");
            choice = scanner.nextLine();

            if (choice.equals("M")) {
                String month = attributes.addMonth();
                article.setMonth(month);
                ok = true;
            } else if (choice.equals("S")) {
                ok = true;
            } else {
                System.out.println("Invalid choice!\n");
            }
        }

        ok = false;
        choice = "";

        // Add note
        while (ok == false) {
            System.out.println("Do you want to add attribute for note? \n");
            System.out.println("Select (N) for yes and (S) to skip. \n");
            choice = scanner.nextLine();

            if (choice.equals("N")) {
                String note = attributes.addNote();
                article.setNote(note);
                ok = true;
            } else if (choice.equals("S")) {
                ok = true;
            } else {
                System.out.println("Invalid choice!\n");
            }
        }

        return article;
    }

    // Method for adding inproceeding-references
    private void addInproceedingReference() {
        boolean ok = false;
        String choice = "";
        Inproceeding inproceeding = new Inproceeding();

        System.out.println("Input mandatory fields for inproceeding reference: \n");

        // Add author
        String author = attributes.addAuthor();
        inproceeding.setAuthor(author);

        // Add title
        String title = attributes.addTitle();
        inproceeding.setTitle(title);

        // add booktitle
        String booktitle = attributes.addBooktitle();
        inproceeding.setBooktitle(booktitle);

        // add year
        String year = attributes.addYear();
        inproceeding.setYear(Integer.parseInt(year));

        // Choice for either adding optional fields or not.
        while (ok == false) {
            System.out.println("Do you want to add optional fields too? Press 'Y' for yes"
                    + " or 'N' for no. \n");
            choice = scanner.nextLine();

            if (choice.equals("Y")) {
                inproceeding = addOptionalInproceedingReferences(inproceeding);
                ok = true;
            } else if (choice.equals("N")) {
                ok = true;
            } else {
                System.out.println("Invalid choice, try again! \n");
            }

        }

        // Attribute definition ends, article is created.
        container.addReference(inproceeding);

        System.out.println("A new inproceeding reference has been created!");
        System.out.println("There are now " + this.container.getReferences().size()
                + " references in the system.");

        start();
    }

    private Inproceeding addOptionalInproceedingReferences(Inproceeding inproceeding) {
        boolean ok = false;
        String choice = "";

        while (ok == false) {
            System.out.println("Do you want to add attribute for editor? \n");
            System.out.println("Select (E) for yes and (S) to skip. \n");
            choice = scanner.nextLine();

            if (choice.equals("E")) {
                String editor = attributes.addEditor();
                inproceeding.setEditor(editor);
                ok = true;
            } else if (choice.equals("S")) {
                ok = true;
            } else {
                System.out.println("Invalid choice!\n");
            }
        }

        ok = false;
        choice = "";

        while (ok == false) {
            System.out.println("Do you want to add attribute for volume or number or maybe skip? \n");
            System.out.println("Select (V) for volume, (N) for number or (S) to skip. \n");
            choice = scanner.nextLine();

            if (choice.equals("V")) {
                String volume = attributes.addVolume();
                inproceeding.setVolume(volume);
                ok = true;
            } else if (choice.equals("N")) {
                String number = attributes.addNumber();
                inproceeding.setNumber(Integer.parseInt(number));
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
            System.out.println("Do you want to add attribute for series? \n");
            System.out.println("Select (R) for yes and (S) to skip. \n");
            choice = scanner.nextLine();

            if (choice.equals("R")) {
                String series = attributes.addSeries();
                inproceeding.setSeries(series);
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
            System.out.println("Do you want to add attribute for pages? \n");
            System.out.println("Select (P) for yes and (S) to skip. \n");
            choice = scanner.nextLine();

            if (choice.equals("P")) {
                String pages = attributes.addPages();
                inproceeding.setPages(pages);
                ok = true;
            } else if (choice.equals("S")) {
                ok = true;
            } else {
                System.out.println("Invalid choice!\n");
            }
        }

        ok = false;
        choice = "";

        while (ok == false) {
            System.out.println("Do you want to add attribute for address? \n");
            System.out.println("Select (A) for yes and (S) to skip. \n");
            choice = scanner.nextLine();

            if (choice.equals("A")) {
                String address = attributes.addAddress();
                inproceeding.setAddress(address);
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
            System.out.println("Do you want to add attribute for month? \n");
            System.out.println("Select (M) for yes and (S) to skip. \n");
            choice = scanner.nextLine();

            if (choice.equals("M")) {
                String month = attributes.addMonth();
                inproceeding.setMonth(month);
                ok = true;
            } else if (choice.equals("S")) {
                ok = true;
            } else {
                System.out.println("Invalid choice!\n");
            }
        }

        ok = false;
        choice = "";

        while (ok == false) {
            System.out.println("Do you want to add attribute for organization? \n");
            System.out.println("Select (O) for yes and (S) to skip. \n");
            choice = scanner.nextLine();

            if (choice.equals("O")) {
                String organization = attributes.addOrganization();
                inproceeding.setOrganization(organization);
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
            System.out.println("Do you want to add attribute for publisher? \n");
            System.out.println("Select (P) for yes and (S) to skip. \n");
            choice = scanner.nextLine();

            if (choice.equals("P")) {
                String publisher = attributes.addPublisher();
                inproceeding.setPublisher(publisher);
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
            System.out.println("Do you want to add attribute for note? \n");
            System.out.println("Select (N) for yes and (S) to skip. \n");
            choice = scanner.nextLine();

            if (choice.equals("N")) {
                String note = attributes.addNote();
                inproceeding.setNote(note);
                ok = true;
            } else if (choice.equals("S")) {
                ok = true;
            } else {
                System.out.println("Invalid choice!\n");
            }
        }

        return inproceeding;
    }

    //metodin viitetietojen muokkaamista varten
    public void updateReference() {

        //kysytään mitä viitettä halutaan muokata
        //haetaan haluttu viite
        //kysytään mikä kohta halutaan muokta
        //kysytään niin kauan, kunnes käyttäjä sanoo, että haluaa poistua
        System.out.println("Give the reference ID you want to modify. \n");
        String choice = scanner.nextLine();

        // TODO Fix This after search method is available 
        List<Reference> list = container.listReferences();
        Reference ref = null;
        for (Reference r : list) {
            if (r.getClass() == Article.class) {
                ref = r;
            }
        }

        if (ref.getClass() == Article.class) {
            Article article = (Article) ref;
            Integer line = 1;
            
            while (line != 0) {
                System.out.println("Current data in article:");
                System.out.println("1) Author: " + article.getAuthor());
                System.out.println("2) Title: " + article.getTitle());
                System.out.println("3) Journal: " + article.getJournal());
                System.out.println("4) Year: " + article.getYear());
                System.out.println("5) Volume: " + article.getVolume());
                System.out.println("6) Number: " + article.getNumber());
                System.out.println("7) Pages: " + article.getPages());
                System.out.println("8) Month: " + article.getMonth());
                System.out.println("9) Note: " + article.getNote() + "\n");

                System.out.println("Which line (number 1-9) do you want to update or do you want to leave (0)? \n");
                line = scanner.nextInt();  
                String cr = scanner.nextLine();
                
                if (line < 0 || line > 9){
                    System.out.println("Give the line number (1-9) you want to update or give (0) if you want to leave. \n");
                    line = scanner.nextInt();
                }
                
                else if (line == 4 || line == 6) {
                    System.out.println("Give new value: ");
                    Integer number = scanner.nextInt();
                    cr = scanner.nextLine();
                    if (line == 4) {
                        article.setYear(number);
                    } else if (line == 6) {
                        article.setNumber(number);
                    }

                } else if (line > 0 && line < 4 || line == 5 || line > 6 && line < 10){
                    System.out.println("Give new value: ");
                    String value = scanner.nextLine();

                    if (line == 1) {
                        article.setAuthor(value);
                    } else if (line == 2) {
                        article.setTitle(value);
                    } else if (line == 3) {
                        article.setJournal(value);
                    } else if (line == 5) {
                        article.setVolume(value);
                    } else if (line == 7) {
                        article.setPages(value);
                    } else if (line == 8) {
                        article.setMonth(value);
                    } else if (line == 9) {
                        article.setNote(value);
                    }
                } 

            }
            
        } else if (ref.getClass() == Book.class) {
            System.out.println("Not yet implemented");
        } else if (ref.getClass() == Inproceeding.class) {
            System.out.println("Not yet implemented");
        }
    }
}
