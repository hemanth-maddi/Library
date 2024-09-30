package com.incedo.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LibraryService {
    private String libraryName;
    private String address;
    private List<Book> books;

    
    public LibraryService(String libraryName, String address) {
        this.libraryName = libraryName;
        this.address = address;
        this.books = new ArrayList<>();
        addDefaultBooks();
    }

    private void addDefaultBooks() {
        books.add(new Book(1, "ram", "om publication", 4289));
        books.add(new Book(2, "bheem", "om publication", 9982));
        books.add(new Book(3, "om", "lol publication", 8920));
        books.add(new Book(4, "ravi", "bheem", 89920));
        books.add(new Book(5, "raju", "vamsi", 8264));
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book);
    }

    public List<Book> removeBook(int isbn) {
        books = books.stream()
                     .filter(book -> book.getIsbn() != isbn)
                     .collect(Collectors.toList());
        System.out.println("Book removed with ISBN: " + isbn);
        return books; 
    }

    public Book findMaxPriceBookByPublisher(String publisher) {
        Optional<Book> maxPricedBook = books.stream()
            .filter(book -> book.getPublisher().equalsIgnoreCase(publisher))
            .max((book1, book2) -> Float.compare(book1.getPrice(), book2.getPrice()));

        return maxPricedBook.orElse(null);
    }
}
