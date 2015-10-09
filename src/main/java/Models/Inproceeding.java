/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.Models;


/**
 *
 * @author teemu
 */
public class Inproceeding extends Reference {
    
    private String author; 
    private String title; 
    private String booktitle; 
    private Integer year;

    private String editor; 
    private String volume; //or number, 
    private Integer number;        
    private String series; 
    private String pages; 
    private String address; 
    private String month; 
    private String organization; 
    private String publisher; 
    private String note;
            
    public Inproceeding() {
    this.author = "";
    this.title = ""; 
    this.booktitle = ""; 
    this.year = Integer.MIN_VALUE;

    this.editor = ""; 
    this.volume = ""; 
    this.number = Integer.MIN_VALUE;        
    this.series = ""; 
    this.pages = ""; 
    this.address = ""; 
    this.month = ""; 
    this.organization = ""; 
    this.publisher = ""; 
    this.note = "";
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

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
