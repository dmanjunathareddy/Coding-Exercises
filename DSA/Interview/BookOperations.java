package com.softgroup.dsa.interview;

import java.util.Arrays;
import java.util.List;

class Book {
    private String title;
    private String author;
    private String genre;
    private double rating;

    public Book(String title, String author, String genre, double rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }
}

public class BookOperations {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", 4.5),
                new Book("1984", "George Orwell", "Fiction", 4.3),
                new Book("Pride and Prejudice", "Jane Austen", "Romance", 4.6),
                new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 4.2),
                new Book("The Catcher in the Rye", "J.D. Salinger", "Fiction", 4.1)
        );

        // Filter books in the "Fiction" genre, map to authors, sort alphabetically, and convert to uppercase
        books.stream()
                .filter(book -> book.getGenre().equals("Fiction"))
                .map(Book::getAuthor)
                .sorted(String::compareToIgnoreCase)
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
