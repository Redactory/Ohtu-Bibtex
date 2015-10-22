/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Models.Article;
import Models.Book;
import Models.Inproceeding;
import Models.Reference;
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

    /*
     REGEX-CHECK METHODS
     */
    // Regex-method for checking years.
    public boolean checkNumbers(String year) {
        regex = "[0-9]+";

        if (year.matches(regex)) {
            return true;
        } else {
            System.out.println("\nInvalid input\n");

            return false;
        }
    }

    // Regex-check for fields that have only alphabet-characters.
    private boolean checkFieldsWithoutNumbers(String field) {
//        regex = "([a-zA-Z[-]]+[\\s]*+[\\p{L}]+)+";
        
        regex = "([\\p{L}[-]]+[\\s]*)+";
        if (field.matches(regex)) {
            return true;
        } else {
            System.out.println("\nInvalid input\n");

            return false;
        }

    }

    // Regex-check for fields that have both characters and numbers.
    private boolean checkFieldsWithNumbers(String field) {
        //any letter(no special characters), numbers 0-9, char '-' and any number of spaces between any of them 
        regex = "([\\p{L}0-9[-]]+[\\s]*)+";
        

        if (field.matches(regex)) {
            return true;
        } else {
            System.out.println("\nInvalid input\n");

            return false;
        }
    }
       
    /*
     ATTRIBUTE ADDITION METHODS
     */
    //TODO: KÄYTÄ trim-metodia TRIMMAAMAAN MAHD. WHITESPACE POIS!!!!
    public String addYear() {
        String year = "";
        boolean ok = false;

        while (ok == false) {
            System.out.println("Give the year to be added: \n");
            year = this.scanner.nextLine();
            year = year.trim();
            ok = checkNumbers(year);
        }

        return year;
    }

    // Add author to reference.
    public String addAuthor() {
        String author = "";
        boolean ok = false;

        while (ok == false) {
            System.out.println("Give the author to be added: \n");
            author = this.scanner.nextLine();
            author = author.trim();
            ok = checkFieldsWithoutNumbers(author);
        }

        return author;
    }

    // Add title to reference.
    public String addTitle() {
        String title = "";
        boolean ok = false;

        while (ok == false) {
            System.out.println("Give the title to be added: \n");
            title = this.scanner.nextLine();
            title = title.trim();
            ok = checkFieldsWithNumbers(title);
        }

        return title;
    }
    
    // Add Booktitle to reference.
    public String addBooktitle() {
        String booktitle = "";
        boolean ok = false;

        while (ok == false) {
            System.out.println("Give the booktitle to be added: \n");
            booktitle = this.scanner.nextLine();
            booktitle = booktitle.trim();
            ok = checkFieldsWithNumbers(booktitle);
        }

        return booktitle;
    }


    // Add publisher to reference.
    public String addPublisher() {
        String publisher = "";
        boolean ok = false;

        while (ok == false) {
            System.out.println("Give the publisher to be added: \n");
            publisher = this.scanner.nextLine();
            publisher = publisher.trim();
            ok = checkFieldsWithoutNumbers(publisher);
        }

        return publisher;
    }

    // Add volume to the reference.
    public String addVolume() {
        String volume = "";
        boolean ok = false;

        while (ok == false) {
            System.out.println("Give the volume to be added: \n");
            volume = this.scanner.nextLine();
            volume = volume.trim();
            ok = checkFieldsWithNumbers(volume);
        }

        return volume;
    }

    // Add number to the reference.
    public String addNumber() {
        String number = "";
        boolean ok = false;

        while (ok == false) {
            System.out.println("Give the number to be added: \n");
            number = this.scanner.nextLine();
            number = number.trim();
            ok = checkNumbers(number);
        }

        return number;
    }

    // Add series to the reference.
    public String addSeries() {
        String series = "";
        boolean ok = false;

        while (ok == false) {
            System.out.println("Give the series to be added: \n");
            series = this.scanner.nextLine();
            series = series.trim();
            ok = checkFieldsWithNumbers(series);
        }

        return series;
    }

    // Add address to the reference.
    public String addAddress() {
        String address = "";
        boolean ok = false;

        while (ok == false) {
            System.out.println("Give the address to be added: \n");
            address = this.scanner.nextLine();
            address = address.trim();
            ok = checkFieldsWithNumbers(address);
        }

        return address;
    }

    // Add edition to the reference.
    public String addEdition() {
        String edition = "";
        boolean ok = false;

        while (ok == false) {
            System.out.println("Give the edition to be added: \n");
            edition = this.scanner.nextLine();
            edition = edition.trim();
            ok = checkFieldsWithNumbers(edition);
        }

        return edition;
    }

    // Add month to the reference.
    public String addMonth() {
        String month = "";
        boolean ok = false;

        while (ok == false) {
            System.out.println("Give the month to be added: \n");
            month = this.scanner.nextLine();
            month = month.trim();
            ok = checkFieldsWithoutNumbers(month);
        }

        return month;
    }

    // Add note to the reference.
    public String addNote() {
        String note = "";
        boolean ok = false;

        while (ok == false) {
            System.out.println("Give the note to be added: \n");
            note = this.scanner.nextLine();
            ok = checkFieldsWithNumbers(note);
        }

        return note;
    }

    // Add the name of a journal to the reference.
    public String addJournal() {
        String journal = "";
        boolean ok = false;

        while (ok == false) {
            System.out.println("Give the journal to be added: \n");
            journal = this.scanner.nextLine();
            journal = journal.trim();
            ok = checkFieldsWithNumbers(journal);
        }

        return journal;
    }

    // Add the page range to the reference.
    public String addPages() {
        String pages = "";
        boolean ok = false;

        while (ok == false) {
            System.out.println("Give the page numers: \n");
            pages = this.scanner.nextLine();
            pages = pages.trim();
            ok = checkFieldsWithNumbers(pages);
        }

        return pages;
    }
    
    // Add an organization to a reference.
    public String addOrganization() {
        String organization = "";
        boolean ok = false;

        while (ok == false) {
            System.out.println("Give the organization to be added: \n");
            organization = this.scanner.nextLine();
            organization.trim();
            ok = checkFieldsWithNumbers(organization);
        }

        return organization;        
    }
    
    // Add an editor to the reference.
    public String addEditor() {
        String editor = "";
        boolean ok = false;

        while (ok == false) {
            System.out.println("Give the editor to be added: \n");
            editor = this.scanner.nextLine();
            editor.trim();
            ok = checkFieldsWithNumbers(editor);
        }

        return editor; 
    }
}
