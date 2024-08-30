import java.util.Date;

/**
 * Represents a Reservation made by a patron for a specific book.
 * Each reservation has a unique ID, the book being reserved, the patron making the reservation, and the reservation date.
 */
public class Reservation {
    private String id;                // Unique identifier for the reservation
    private Book book;                // The book being reserved
    private Patron patron;            // The patron making the reservation
    private Date reservationDate;     // The date when the reservation was made

    /**
     * Constructor to initialize a Reservation object.
     * The reservation date is set to the current date and time.
     * @param id The unique identifier for the reservation.
     * @param book The book being reserved.
     * @param patron The patron making the reservation.
     */
    public Reservation(String id, Book book, Patron patron) {
        this.id = id;
        this.book = book;
        this.patron = patron;
        this.reservationDate = new Date(); // Set the reservation date to the current date and time
    }

    /**
     * Retrieves the ID of the reservation.
     * @return The ID of the reservation.
     */
    public String getId() {
        return id;
    }

    /**
     * Retrieves the book associated with the reservation.
     * @return The book associated with the reservation.
     */
    public Book getBook() {
        return book;
    }

    /**
     * Retrieves the patron who made the reservation.
     * @return The patron who made the reservation.
     */
    public Patron getPatron() {
        return patron;
    }

    /**
     * Retrieves the date when the reservation was made.
     * @return The reservation date.
     */
    public Date getReservationDate() {
        return reservationDate;
    }

    /**
     * Cancels the reservation by removing it from the patron's list of reservations.
     */
    public void cancel() {
        patron.removeReservation(this);
    }
}
