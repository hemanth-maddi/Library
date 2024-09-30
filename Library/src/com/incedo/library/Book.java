package com.incedo.library;
public class Book {
    private int isbn;
    private String author;
    private String publisher;
    private float price;


    public Book(int isbn, String author, String publisher, float price) {
        this.isbn = isbn;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
    }


    public int getIsbn() {
        return isbn;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "ISBN: " + isbn + ", Author: " + author + ", Publisher: " + publisher + ", Price: $" + price;
    }
}
