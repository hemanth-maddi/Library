package com.incedo.library;

import java.util.List;
import java.util.Scanner;

public class LibraryHack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryService library = new LibraryService("Mind Free Library", "Gachibowli Hyderabad");

        System.out.println("User Type (admin/customer): ");
        String userType = sc.nextLine();

        if (userType.equalsIgnoreCase("admin")) {
            System.out.println("Admin options:\n1. View all books\n2. Add new book\n3. Delete book\n4. Find most expensive book by publisher");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    
                    library.getBooks().forEach(System.out::println);
                    break;

                case 2:
                    
                    System.out.println("Enter book details (ISBN, Author, Publisher, Price): ");
                    int isbn = sc.nextInt();
                    sc.nextLine(); 
                    String author = sc.nextLine();
                    String publisher = sc.nextLine();
                    float price = sc.nextFloat();
                    library.addBook(new Book(isbn, author, publisher, price));
                    System.out.println("Updated list of books after adding:");
                    library.getBooks().forEach(System.out::println);
                    break;

                case 3:
                    
                    System.out.println("Enter the ISBN of the book to remove: ");
                    int bookIsbn = sc.nextInt();
                    List<Book> updatedBooks = library.removeBook(bookIsbn);
                    System.out.println("Updated list of books:");
                    updatedBooks.forEach(System.out::println);
                    break;

                case 4:
                    
                    System.out.println("Enter the publisher name: ");
                    String pub = sc.nextLine();
                    Book maxPricedBook = library.findMaxPriceBookByPublisher(pub);
                    System.out.println(maxPricedBook != null ? maxPricedBook : "No books found for this publisher.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } else if (userType.equalsIgnoreCase("customer")) {
            System.out.println("Customer options:\n1. View all books\n2. Find most expensive book by publisher");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                   
                    library.getBooks().forEach(System.out::println);
                    break;

                case 2:
                    
                    System.out.println("Enter the publisher name: ");
                    String pub = sc.nextLine();
                    Book maxPricedBook = library.findMaxPriceBookByPublisher(pub);
                    System.out.println(maxPricedBook != null ? maxPricedBook : "No books found for this publisher.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } else {
            System.out.println("Invalid user type.");
        }

        sc.close();
    }
}

