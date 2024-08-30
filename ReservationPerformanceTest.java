import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Performance tests for the Reservation class.
 */
public class ReservationPerformanceTest {

    private static final int LARGE_NUMBER_OF_RESERVATIONS = 10000;

    /**
     * Tests the performance of creating and canceling a large number of Reservations.
     */
    @Test
    public void testCreateAndCancelReservationsPerformance() {
        Patron patron = new Patron("P001", "Alice");
        Author author = new Author("A001", "John Doe");
        Publisher publisher = new Publisher("P001", "Tech Books Inc.");
        Book book = new Book("1234", "Java Programming", author, publisher);
        List<Reservation> reservations = new ArrayList<>();

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < LARGE_NUMBER_OF_RESERVATIONS; i++) {
            Reservation reservation = new Reservation("R" + i, book, patron);
            patron.addReservation(reservation);
            reservations.add(reservation);
        }

        for (Reservation reservation : reservations) {
            reservation.cancel();
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("Time taken to create and cancel " + LARGE_NUMBER_OF_RESERVATIONS + " reservations: " + duration + " ms");

        assertTrue(patron.getReservations().isEmpty());
    }
}
