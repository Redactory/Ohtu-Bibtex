package UI;

import java.io.File;
import java.util.Map;
import java.util.Scanner;

import IO.IO;
import Models.*;
import java.util.Hashtable;
import java.util.List;
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

    // Object for search services.
    Search search;

    //current bibliography file
    private File bibFile;

    public UserInterface() {
        container = new Container();
        scanner = new Scanner(System.in, "ISO-8859-1");
        attributes = new AttributeAdditionMethods();
        bibFile = null;
        search = new Search();
    }

    public Container getContainer() {
        return this.container;
    }

    public void start() {
        String answer = "";
        Reference reference = new Reference();

        System.out.println("MAIN MENU \n");
        System.out.println("You can perform following actions. "
                + "Press the key in the wave-bracket:\n\n");
        System.out.println("- Add a book reference (B) \n");
        System.out.println("- Add an article reference (A) \n");
        System.out.println("- Add an inproceeding reference (I) \n");
        System.out.println("- Update a reference (U) \n");
        System.out.println("- List existing references (L) \n");
        System.out.println("- List existing references by writer (Lw) \n");
        System.out.println("- List existing references by publisher (Lp) \n");
        System.out.println("- Export references to a file (export) \n");
        System.out.println("- Change to a different bibtex bibliography saving any changes (C) \n");
        System.out.println("- find a reference though it's reference-id (find) \n");
        System.out.println("- Delete existing reference by it's id (delete) \n");
        System.out.println("- End the program (press any other key) \n");

        if (bibFile != null) {
            System.out.println("Currently modifying file: " + bibFile.getAbsolutePath() + "\n");
        }
//        String answer = this.scanner.nextLine();
        if (answer.isEmpty()) {
            answer = this.scanner.nextLine();
        }

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
        } else if(answer.equals("Lw")){
            System.out.println("Enter writer:");
            answer = "";
            answer = scanner.nextLine();
            getWriter(answer);
        } else if(answer.equals("Lp")){
            System.out.println("Enter publisher:");
            answer = "";
            answer = scanner.nextLine();
            getPublisher(answer);
        } else if (answer.equals("export")) {
            System.out.println("Enter filename:");
            answer = "";
            answer = scanner.nextLine();
            IO.exportToBibTex(new File(answer), container.listReferences());
            start();
        
        } else if (answer.equals("C")) {
            changeFile();
            start();
        } else if (answer.equals("find")) {
            reference = search.findReference();
        } else if (answer.equals("delete")) {
            search.deleteReference();
        } else {
            System.out.println("Program ends!");
            save();
            System.exit(0);
        }
    }

    public void save() {
        if (bibFile != null) {
            IO.exportToBibTex(bibFile, container.listReferences());
        }
    }

    public boolean changeFile() {

        boolean cont = true;
        while (cont) {
            System.out.println("Choose either to create new bibtex bibliography"
                    + " (N), modify an existing one (E) or abort (@abort)");
            String answer = "";
            answer = scanner.nextLine();
            if (answer.equals("N")) {
                boolean cont2 = true;
                while (cont2) {
                    System.out.println("Enter filepath or name if in the same directory; (@abort) to go back");
                    answer = "";
                    answer = scanner.nextLine();
                    File f = new File(answer.trim());
                    if (answer.equals("@abort")) {
                        cont2 = false;
                    } else if (!f.exists()) {
                        try {
                            f.createNewFile();
                        } catch (Exception e) {
                            System.out.println("Error when trying to create file");
                        }
                        save();
                        container = new Container();
                        bibFile = f;
                        cont = false;
                        cont2 = false;
                    } else {
                        System.out.println("File already exists, try again! \n");
                    }
                }
            } else if (answer.equals("E")) {
                System.out.println("List of .bib files in same directory:\n");
                List<String> files = IO.listFilesInDirectory(".");
                if (files != null) {
                    for (String file : files) {
                        System.out.println(file);
                    }
                }

                boolean cont2 = true;
                while (cont2) {
                    System.out.println("Enter filepath or name if in the same directory; (@abort) to go back");
                    answer = "";
                    answer = scanner.nextLine();
                    File f;
                    f = new File(answer.trim());
                    if (answer.equals("@abort")) {
                        cont = true;
                        cont2 = false;
                    } else if (f.exists()) {
                        String references = IO.readBibTexFile(f.getAbsoluteFile());
                        try {
                            List<Reference> refs = ReferenceConverter.bibTexToReference(references);
                            save();
                            //discard current container after saving
                            container = new Container();
                            for (Reference ref : refs) {
                                container.addReference(ref);
                            }
                            bibFile = f;
                            cont = false;
                            cont2 = false;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Selected file is not in bibtex format");
                            cont2 = false;
                        }

                    } else {
                        System.out.println("No such file, try again! \n");
                    }
                }
            } else if (answer.equals("@abort")) {
                return false;
            } else {
                System.out.println("Invalid choice, try again! \n");
            }
        }
        return true;
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
        // Add reference_id based on author name

        // Attribute definition ends, book is created.
        addToContainer(book);

        System.out.println("new book reference has been created!");
        System.out.println("There are now " + this.container.getReferences().size()
                + " references in the system.");

        start();
    }

    private void addToContainer(Reference ref) {
        container.addReference(ref);
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
        addToContainer(article);

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
        addToContainer(inproceeding);

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

    public void getWriter(String writer){
        Hashtable<String,Reference> r = container.getReferences();
        for(Map.Entry<String,Reference> reffi : r.entrySet()){
           String s = ReferenceConverter.toBibTex(reffi.getValue());
           String[] ss = s.split(",");
           String[] sss = ss[1].split(" ");
            // 4 ja 5
           String etu = sss[4].substring(1);
           String suku = sss[5].substring(0, sss[5].length() - 1);
           String kokonimi = etu.concat(" ").concat(suku);

           if(kokonimi.equals(writer)){
               System.out.println();
               System.out.println(ReferenceConverter
                       .toBibTex(
                               reffi.getValue()
                       )
               );
           }
        }
        start();
    }

    public void getPublisher(String publisher){
        Hashtable<String,Reference> r = container.getReferences();
        for(Map.Entry<String,Reference> reffi : r.entrySet()){
            String s = ReferenceConverter.toBibTex(reffi.getValue());
            String[] ss = s.split(",");
            String[] sss = ss[3].split(" ");
            //5
            String cleanBraces = sss[5]
                    .substring(1)
                    .substring(0, sss[5].length() -1);
            if(publisher.equals(cleanBraces)){
                System.out.println(
                        ReferenceConverter
                            .toBibTex(
                                    reffi.getValue()
                            )
                );
            }
        }
        start();
    }
    
    //metodin viitetietojen muokkaamista varten
    public void updateReference() {

        //kysytään mitä viitettä halutaan muokata
        //haetaan haluttu viite
        //kysytään mikä kohta halutaan muokta
        //kysytään niin kauan, kunnes käyttäjä sanoo, että haluaa poistua
        System.out.println("Give the reference ID you want to modify. \n");
        String choice = scanner.nextLine();

        Reference ref = container.getReference(choice);

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

                if (line == 4 || line == 6) {
                    System.out.println("Give new value: ");
                    Integer number = scanner.nextInt();
                    cr = scanner.nextLine();
                    if (line == 4) {
                        article.setYear(number);
                    } else if (line == 6) {
                        article.setNumber(number);
                    }

                } else if (line > 0 && line < 4 || line == 5 || line > 6 && line < 10) {
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
            Book book = (Book) ref;

            Integer line = 1;

            while (line != 0) {
                System.out.println("Current data in book reference:");
                System.out.println("1) Year: " + book.getYear());
                System.out.println("2) Author: " + book.getAuthor());
                System.out.println("3) Editor: " + book.getEditor());
                System.out.println("4) Title: " + book.getTitle());
                System.out.println("5) Publisher: " + book.getPublisher());
                System.out.println("6) Volume: " + book.getVolume());
                System.out.println("7) Number: " + book.getNumber());
                System.out.println("8) Series: " + book.getSeries());
                System.out.println("9) Address: " + book.getAddress());
                System.out.println("10) Edition: " + book.getEdition());
                System.out.println("11) Month: " + book.getMonth());
                System.out.println("12) Note: " + book.getNote() + "\n");

                System.out.println("Which line (number 1-12) do you want to update or do you want to leave (0)? \n");
                line = scanner.nextInt();
                String cr = scanner.nextLine();

                if (line == 1) {
                    System.out.println("Give new value: ");
                    Integer number = scanner.nextInt();
                    cr = scanner.nextLine();
                    book.setYear(number);

                } else if (line > 1 && line < 13) {
                    System.out.println("Give new value: ");
                    String value = scanner.nextLine();

                    if (line == 2) {
                        book.setAuthor(value);
                    } else if (line == 3) {
                        book.setEditor(value);
                    } else if (line == 4) {
                        book.setTitle(value);
                    } else if (line == 5) {
                        book.setPublisher(value);
                    } else if (line == 6) {
                        book.setVolume(value);
                    } else if (line == 7) {
                        book.setNumber(value);
                    } else if (line == 8) {
                        book.setSeries(value);
                    } else if (line == 9) {
                        book.setAddress(value);
                    } else if (line == 10) {
                        book.setEdition(value);
                    } else if (line == 11) {
                        book.setMonth(value);
                    } else if (line == 12) {
                        book.setNote(value);
                    }
                }
            }
        } else if (ref.getClass() == Inproceeding.class) {

            Inproceeding inproceeding = (Inproceeding) ref;

            Integer line = 1;

            while (line != 0) {
                System.out.println("Current data in Inproceeding:");
                System.out.println("1) Author: " + inproceeding.getAuthor());
                System.out.println("2) Title: " + inproceeding.getTitle());
                System.out.println("3) Booktitle: " + inproceeding.getBooktitle());
                System.out.println("4) Year: " + inproceeding.getYear());
                System.out.println("5) Editor: " + inproceeding.getEditor());
                System.out.println("6) Volume: " + inproceeding.getVolume());
                System.out.println("7) Number: " + inproceeding.getNumber());
                System.out.println("8) Series: " + inproceeding.getSeries());
                System.out.println("9) Pages: " + inproceeding.getPages());
                System.out.println("10) Address: " + inproceeding.getAddress());
                System.out.println("11) Month: " + inproceeding.getMonth());
                System.out.println("12) Organization: " + inproceeding.getOrganization());
                System.out.println("13) Publisher: " + inproceeding.getPublisher());
                System.out.println("14) Note: " + inproceeding.getNote() + "\n");
      
                System.out.println("Which line (number 1-14) do you want to update or do you want to leave (0)? \n");
                line = scanner.nextInt();
                String cr = scanner.nextLine();

                if (line == 4 || line == 7) {
                    System.out.println("Give new value: ");
                    Integer number = scanner.nextInt();
                    cr = scanner.nextLine();
                    if (line == 4) {
                        inproceeding.setYear(number);
                    } else if (line == 7) {
                        inproceeding.setNumber(number);
                    }

                } else if (line > 0 && line < 4 || line == 5 || line == 6 || line > 7 && line < 15) {
                    System.out.println("Give new value: ");
                    String value = scanner.nextLine();

                    if (line == 1) {
                        inproceeding.setAuthor(value);
                    } else if (line == 2) {
                        inproceeding.setTitle(value);
                    } else if (line == 3) {
                        inproceeding.setBooktitle(value);
                    } else if (line == 5) {
                        inproceeding.setEditor(value);
                    } else if (line == 6) {
                        inproceeding.setVolume(value);
                    } else if (line == 8) {
                        inproceeding.setSeries(value);
                    } else if (line == 9) {
                        inproceeding.setPages(value);
                    } else if (line == 10) {
                        inproceeding.setAddress(value);
                    } else if (line == 11) {
                        inproceeding.setMonth(value);
                    } else if (line == 12) {
                        inproceeding.setOrganization(value);
                    } else if (line == 13) {
                        inproceeding.setPublisher(value);
                    } else if (line == 14) {
                        inproceeding.setNote(value);
                    }
                }
            }
        }
    }
}
