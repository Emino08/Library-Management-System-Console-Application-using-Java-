import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Patron of the library.
 * Each patron has a unique ID, a name, a list of borrowed books, reservations, and fines.
 */
public class Patron {
    private String id;                     // Unique identifier for the patron
    private String name;                   // Name of the patron
    private List<Book> borrowedBooks;      // List of books borrowed by the patron
    private List<Reservation> reservations; // List of reservations made by the patron
    private List<Fine> fines;              // List of fines owed by the patron

    /**
     * Constructor to initialize a Patron object.
     * @param id The unique identifier for the patron.
     * @param name The name of the patron.
     */
    public Patron(String id, String name) {
        this.id = id;
        this.name = name;
        this.borrowedBooks = new ArrayList<>(); // Initialize the list of borrowed books as empty
        this.reservations = new ArrayList<>();  // Initialize the list of reservations as empty
        this.fines = new ArrayList<>();         // Initialize the list of fines as empty
    }

    /**
     * Retrieves the ID of the patron.
     * @return The ID of the patron.
     */
    public String getId() {
        return id;
    }

    /**
     * Retrieves the name of the patron.
     * @return The name of the patron.
     */
    public String getName() {
        return name;
    }

    /**
     * Adds a book to the list of books borrowed by the patron.
     * Marks the book as unavailable.
     * @param book The book to be borrowed.
     */
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        book.setAvailable(false);
    }

    /**
     * Removes a book from the list of books borrowed by the patron.
     * Marks the book as available.
     * @param book The book to be returned.
     */
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        book.setAvailable(true);
    }

    /**
     * Adds a reservation to the list of reservations made by the patron.
     * @param reservation The reservation to be added.
     */
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    /**
     * Removes a reservation from the list of reservations made by the patron.
     * @param reservation The reservation to be removed.
     */
    public void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
    }

    /**
     * Adds a fine to the list of fines owed by the patron.
     * @param fine The fine to be added.
     */
    public void addFine(Fine fine) {
        fines.add(fine);
    }

    /**
     * Removes a fine from the list of fines owed by the patron.
     * @param fine The fine to be removed.
     */
    public void removeFine(Fine fine) {
        fines.remove(fine);
    }

    /**
     * Retrieves the list of books borrowed by the patron.
     * @return A new list containing the books borrowed by the patron.
     */
    public List<Book> getBorrowedBooks() {
        return new ArrayList<>(borrowedBooks);
    }

    /**
     * Retrieves the list of reservations made by the patron.
     * @return A new list containing the reservations made by the patron.
     */
    public List<Reservation> getReservations() {
        return new ArrayList<>(reservations);
    }

    /**
     * Retrieves the list of fines owed by the patron.
     * @return A new list containing the fines owed by the patron.
     */
    public List<Fine> getFines() {
        return new ArrayList<>(fines);
    }

    /**
     * Retrieves the details of the patron, including ID, name, number of borrowed books, reservations, and fines.
     * @return A string containing the details of the patron.
     */
    public String getDetails() {
        return "ID: " + id + ", Name: " + name + ", Borrowed Books: " + borrowedBooks.size() +
                ", Reservations: " + reservations.size() + ", Fines: " + fines.size();
    }
}
