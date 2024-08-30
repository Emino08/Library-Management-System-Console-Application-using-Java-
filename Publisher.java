// File: Publisher.java
import java.util.ArrayList;
import java.util.List;
/**
 * Represents a Publisher who publishes books.
 * Each publisher has a unique ID, a name, and a list of books they have published.
 */
public class Publisher {
    private String id; // Unique identifier for the publisher
    private String name; // Name of the publisher
    private List<Book> books; // List of books published by the publisher

    public Publisher(String id, String name) {
        this.id = id;
        this.name = name;
        this.books = new ArrayList<>();
    }
    /**
     * Retrieves the ID of the publisher.
     * @return The ID of the publisher.
     */
    public String getId() {
        return id;
    }
    /**
     * Retrieves the name of the publisher.
     * @return The name of the publisher.
     */
    public String getName() {
        return name;
    }
    /**
     * Adds a book to the list of books published by the publisher.
     * @param book The book to be added.
     */
    public void addBook(Book book) {
        books.add(book);
    }
    /**
     * Retrieves the list of books published by the publisher.
     * @return A new list containing the books published by the publisher.
     */
    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }
}
