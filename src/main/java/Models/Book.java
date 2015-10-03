package main.java.Models;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import main.java.Models.Generator;

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

    private String id;
    private Integer reference_id;

    //  REQUIRED FIELDS
    private Integer year;
    private String author;//or editor
    private String title;
    private String publisher;
    private String editor;

    //  OPTIONAL FIELDS
    private String volume;
    private String number;
    private String series;
    private String address;
    private String edition;
    private String month;
    private String note;

    public Book() {
        this.reference_id = Generator.generateReferenceId();
        this.id = UUID.randomUUID().toString();
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
        this.reference_id = Generator.generateReferenceId();
        this.year = year;
        this.author = author;
        this.title = title;
        this.publisher = publisher;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
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

    @Override
    public Integer getReference_id() {
        return this.reference_id;
    }

    /**
     *
     * @return the book in BibTex format
     */
    public String toBibTex() {
        return "  " + getReference_id() + ", \n"
                + "  author = {" + this.author + "}, \n"
                + "  title = {" + this.title + "}, \n"
                + "  publisher = {" + this.publisher + "}, \n"
                + "  year = {" + this.year + "}, \n"
                + "} \n";
    }

    @Override
    public void print() {
        System.out.println(toBibTex());
    }
}
