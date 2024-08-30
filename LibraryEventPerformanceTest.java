import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

/**
 * Performance tests for the LibraryEvent class.
 */
public class LibraryEventPerformanceTest {

    private static final int LARGE_NUMBER_OF_EVENTS = 10000;

    /**
     * Tests the performance of creating a large number of LibraryEvents.
     */
    @Test
    public void testCreateLibraryEventsPerformance() {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < LARGE_NUMBER_OF_EVENTS; i++) {
            new LibraryEvent("E" + i, "Event" + i, new Date(), "Description" + i);
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("Time taken to create " + LARGE_NUMBER_OF_EVENTS + " library events: " + duration + " ms");
    }
}
