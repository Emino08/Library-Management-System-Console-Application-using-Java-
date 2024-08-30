import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Performance tests for the Fine class.
 */
public class FinePerformanceTest {

    private static final int LARGE_NUMBER_OF_FINES = 10000;

    /**
     * Tests the performance of adding and paying fines for a Patron.
     */
    @Test
    public void testAddAndPayFinesPerformance() {
        Patron patron = new Patron("P001", "Alice");
        List<Fine> fines = new ArrayList<>();

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < LARGE_NUMBER_OF_FINES; i++) {
            Fine fine = new Fine("F" + i, patron, 10.0, "Late fee");
            patron.addFine(fine);
            fines.add(fine);
        }

        for (Fine fine : fines) {
            fine.pay(10.0);
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("Time taken to add and pay " + LARGE_NUMBER_OF_FINES + " fines: " + duration + " ms");

        assertTrue(patron.getFines().isEmpty());
    }
}
