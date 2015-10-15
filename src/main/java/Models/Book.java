package Models;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import Models.Generator;

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

    //  REQUIRED FIELDS
    private Integer year;
    private String author;
    private String editor;
    private String title;
    private String publisher;

    //  OPTIONAL FIELDS
    private String volume;
    private String number;
    private String series;
    private String address;
    private String edition;
    private String month;
    private String note;

    public Book() {
        this.year = Integer.MIN_VALUE;
        this.author = "";
        this.title = "";
        this.publisher = "";
        this.editor = "";
        this.volume = "";
        this.number = "";
        this.series = "";
        this.address = "";
        this.edition = "";
        this.month = "";
        this.note = "";
    }

    public Book(int year, String author, String title,
            String publisher) {
        this.year = year;
        this.author = author;
        this.title = title;
        this.publisher = publisher;
        this.editor = "";
        this.volume = "";
        this.number = "";
        this.series = "";
        this.address = "";
        this.edition = "";
        this.month = "";
        this.note = "";
    }
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    /**
     *
     * @return the book in BibTex format
     * 
     */
//    public String toBibTex() {
//        return ReferenceConverter.bookToBibTex(this);
//        return "@book{GA03,\n"
//                + "  author = {" + this.author + "}, \n"
//                + "  title = {" + this.title + "}, \n"
//                + "  publisher = {" + this.publisher + "}, \n"
//                + "  year = {" + this.year + "}, \n"
//                + "} \n";
//    }
//
//    @Override
//    public void print() {
//        System.out.println(toBibTex());
//    }
}
