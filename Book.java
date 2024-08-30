import java.util.ArrayList;
import java.util.List;
/**
 * Represents a Book in the library.
 * Each book has an ISBN, title, author, publisher, and availability status.
 */
public class Book implements Comparable<Book> {
    private String isbn;      // Unique identifier for the book
    private String title;     // Title of the book
    private Author author;    // Author of the book
    private Publisher publisher;  // Publisher of the book
    private boolean isAvailable;  // Availability status of the book

    /**
     * Constructor to initialize a Book object.
     * @param isbn The unique identifier for the book.
     * @param title The title of the book.
     * @param author The author of the book.
     * @param publisher The publisher of the book.
     */
    public Book(String isbn, String title, Author author, Publisher publisher) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isAvailable = true; // By default, a new book is available
    }
    /**
     * Retrieves the ISBN of the book.
     * @return The ISBN of the book.
     */
    public String getIsbn() {
        return isbn;
    }
    /**
     * Retrieves the title of the book.
     * @return The title of the book.
     */
    public String getTitle() {
        return title;
    }
    /**
     * Retrieves the author of the book.
     * @return The author of the book.
     */
    public Author getAuthor() {
        return author;
    }
    /**
     * Retrieves the publisher of the book.
     * @return The publisher of the book.
     */
    public Publisher getPublisher() {
        return publisher;
    }
    /**
     * Checks if the book is available for borrowing.
     * @return true if the book is available, false otherwise.
     */
    public boolean isAvailable() {
        return isAvailable;
    }
    /**
     * Sets the availability status of the book.
     * @param available The new availability status.
     */
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // Getters and setters with corresponding documentation

    /**
     * Retrieves the details of the book.
     * @return A string containing details of the book including ISBN, title, author, publisher, and availability.
     */
    public String getDetails() {
        return "ISBN: " + isbn + ", Title: " + title + ", Author: " + author.getName() +
               ", Publisher: " + publisher.getName() + ", Available: " + isAvailable;
    }

    /**
     * Compares this book with another based on title.
     * @param other The other book to compare with.
     * @return A negative integer, zero, or a positive integer if this book's title is less than, equal to, or greater than the other book's title.
     */
    @Override
    public int compareTo(Book other) {
        return this.getTitle().compareTo(other.getTitle());
    }
}
