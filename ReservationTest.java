import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReservationTest {

    @org.junit.Test
    @Test
    public void testReservationCreation() {
        Author author = new Author("A001", "John Doe");
        Publisher publisher = new Publisher("P001", "Tech Books Inc.");
        Book book = new Book("1234", "Java Programming", author, publisher);
        Patron patron = new Patron("P001", "Alice");

        Reservation reservation = new Reservation("R001", book, patron);

        assertEquals("R001", reservation.getId());
        assertEquals(book, reservation.getBook());
        assertEquals(patron, reservation.getPatron());
        assertNotNull(reservation.getReservationDate());
    }

    @Test
    public void testCancelReservation() {
        Author author = new Author("A001", "John Doe");
        Publisher publisher = new Publisher("P001", "Tech Books Inc.");
        Book book = new Book("1234", "Java Programming", author, publisher);
        Patron patron = new Patron("P001", "Alice");
        Reservation reservation = new Reservation("R001", book, patron);

        patron.addReservation(reservation);
        assertEquals(1, patron.getReservations().size());

        reservation.cancel();
        assertEquals(0, patron.getReservations().size());
    }
}
