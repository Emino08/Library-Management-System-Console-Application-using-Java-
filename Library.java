import java.util.*;

/**
 * Represents the Library, which manages a collection of books, patrons, and library events.
 * The library provides functionalities to add, remove, and search for books and patrons, handle book borrowings and returns, and manage reservations.
 */
public class Library {
    private final List<Book> books;                     // List of all books in the library
    private final Map<String, Patron> patrons;          // Map of patrons by their ID
    private final Inventory inventory;                  // The library's inventory of books
    private final List<LibraryEvent> events;            // List of events hosted by the library
    private final PriorityQueue<Reservation> reservations; // Queue of reservations, prioritized by reservation date

    /**
     * Constructor to initialize a Library object.
     * Initializes the collections for books, patrons, events, and reservations.
     */
    public Library() {
        this.books = new ArrayList<>();
        this.patrons = new HashMap<>();
        this.inventory = new Inventory();
        this.events = new ArrayList<>();
        this.reservations = new PriorityQueue<>(Comparator.comparing(Reservation::getReservationDate));
    }

    /**
     * Adds a book to the library's collection and updates the inventory.
     * @param book The book to be added.
     */
    public void addBook(Book book) {
        books.add(book);
        inventory.addBook(book, 1);
    }

    /**
     * Removes a book from the library's collection and updates the inventory.
     * @param book The book to be removed.
     */
    public void removeBook(Book book) {
        books.remove(book);
        inventory.removeBook(book, 1);
    }

    /**
     * Adds a patron to the library's collection.
     * @param patron The patron to be added.
     */
    public void addPatron(Patron patron) {
        patrons.put(patron.getId(), patron);
    }

    /**
     * Removes a patron from the library's collection.
     * @param patronId The ID of the patron to be removed.
     */
    public void removePatron(String patronId) {
        patrons.remove(patronId);
    }

    /**
     * Searches for a book by its ISBN in the library's collection.
     * @param isbn The ISBN of the book to search for.
     * @return The book if found, or null if not found.
     */
    public Book searchBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    /**
     * Searches for a patron by their ID in the library's collection.
     * @param id The ID of the patron to search for.
     * @return The patron if found, or null if not found.
     */
    public Patron searchPatron(String id) {
        return patrons.get(id);
    }

    /**
     * Allows a patron to borrow a book if it is available.
     * The book's availability is updated accordingly.
     * @param patronId The ID of the patron borrowing the book.
     * @param isbn The ISBN of the book to be borrowed.
     */
    public void borrowBook(String patronId, String isbn) {
        Patron patron = searchPatron(patronId);
        Book book = searchBook(isbn);

        if (patron != null && book != null && book.isAvailable()) {
            patron.borrowBook(book);
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Unable to borrow the book. Please check patron ID and book availability.");
        }
    }

    /**
     * Allows a patron to return a borrowed book.
     * The book's availability is updated accordingly.
     * @param patronId The ID of the patron returning the book.
     * @param isbn The ISBN of the book to be returned.
     */
    public void returnBook(String patronId, String isbn) {
        Patron patron = searchPatron(patronId);
        Book book = searchBook(isbn);

        if (patron != null && book != null && patron.getBorrowedBooks().contains(book)) {
            patron.returnBook(book);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Unable to return the book. Please check patron ID and borrowed books.");
        }
    }

    /**
     * Adds an event to the library's list of events.
     * @param event The event to be added.
     */
    public void addEvent(LibraryEvent event) {
        events.add(event);
    }

    /**
     * Retrieves the list of all books in the library.
     * @return A new list containing all books in the library.
     */
    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    /**
     * Retrieves the list of all patrons in the library.
     * @return A new list containing all patrons in the library.
     */
    public List<Patron> getPatrons() {
        return new ArrayList<>(patrons.values());
    }

    /**
     * Retrieves the list of all events hosted by the library.
     * @return A new list containing all events hosted by the library.
     */
    public List<LibraryEvent> getEvents() {
        return new ArrayList<>(events);
    }

    /**
     * Retrieves the library's inventory.
     * @return The library's inventory object.
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Searches for books by their title in the library's collection.
     * @param title The title or partial title to search for.
     * @return A list of books that match the search criteria.
     */
    public List<Book> searchBooksByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }

    /**
     * Sorts the library's books by title in ascending order.
     */
    public void sortBooksByTitle() {
        Collections.sort(books);
    }

    /**
     * Adds a reservation to the queue of reservations.
     * @param reservation The reservation to be added.
     */
    public void addReservation(Reservation reservation) {
        reservations.offer(reservation);
    }

    /**
     * Retrieves the next reservation in the queue, removing it from the queue.
     * @return The next reservation in the queue, or null if the queue is empty.
     */
    public Reservation getNextReservation() {
        return reservations.poll();
    }
}
