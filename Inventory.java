import java.util.HashMap;
import java.util.Map;

/**
 * Represents the Inventory of the library, which keeps track of the quantity of each book available.
 */
public class Inventory {
    private Map<String, Integer> books; // Map of book ISBNs to their quantities in the library

    /**
     * Constructor to initialize an Inventory object.
     * Initializes the map of books.
     */
    public Inventory() {
        this.books = new HashMap<>();
    }

    /**
     * Adds a specified quantity of a book to the inventory.
     * If the book already exists, its quantity is increased.
     * @param book The book to be added.
     * @param quantity The quantity to be added.
     */
    public void addBook(Book book, int quantity) {
        books.put(book.getIsbn(), books.getOrDefault(book.getIsbn(), 0) + quantity);
    }

    /**
     * Removes a specified quantity of a book from the inventory.
     * If the resulting quantity is less than or equal to zero, the book is removed from the inventory.
     * @param book The book to be removed.
     * @param quantity The quantity to be removed.
     */
    public void removeBook(Book book, int quantity) {
        int currentQuantity = books.getOrDefault(book.getIsbn(), 0);
        if (currentQuantity > quantity) {
            books.put(book.getIsbn(), currentQuantity - quantity);
        } else {
            books.remove(book.getIsbn());
        }
    }

    /**
     * Retrieves the quantity of a specific book in the inventory.
     * @param book The book to check.
     * @return The quantity of the book in the inventory, or 0 if the book is not in the inventory.
     */
    public int getQuantity(Book book) {
        return books.getOrDefault(book.getIsbn(), 0);
    }
}
