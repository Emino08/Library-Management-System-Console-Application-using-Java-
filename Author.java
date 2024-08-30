// File: Author.java
import java.util.ArrayList;
import java.util.List;
/**
 * Represents an Author who writes books.
 * Each author has a unique ID, a name, and a list of books they have written.
 */
public class Author {
    private String id; // Unique identifier for the author
    private String name; // Name of the author
    private List<Book> books; // List of books written by the author
    /**
     * Constructor to initialize an Author object.
     * @param id The unique identifier for the author.
     * @param name The name of the author.
     */
    public Author(String id, String name) {
        this.id = id;
        this.name = name;
        this.books = new ArrayList<>();
    }
    /**
     * Retrieves the ID of the author.
     * @return The ID of the author.
     */
    public String getId() {
        return id;
    }
    /**
     * Retrieves the name of the author.
     * @return The name of the author.
     */
    public String getName() {
        return name;
    }
    /**
     * Adds a book to the list of books written by the author.
     * @param book The book to be added.
     */
    public void addBook(Book book) {
        books.add(book);
    }
    /**
     * Retrieves the list of books written by the author.
     * @return A new list containing the books written by the author.
     */
    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }
}
