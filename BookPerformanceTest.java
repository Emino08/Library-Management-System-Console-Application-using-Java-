import org.junit.jupiter.api.Test;

/**
 * Performance tests for the Book class.
 */
public class BookPerformanceTest {

    private static final int LARGE_NUMBER_OF_OPERATIONS = 1000000;

    /**
     * Tests the performance of creating a large number of Book objects.
     */
    @Test
    public void testBookCreationPerformance() {
        Author author = new Author("A001", "John Doe");
        Publisher publisher = new Publisher("P001", "Tech Books Inc.");

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < LARGE_NUMBER_OF_OPERATIONS; i++) {
            new Book("ISBN" + i, "Title" + i, author, publisher);
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("Time taken to create " + LARGE_NUMBER_OF_OPERATIONS + " books: " + duration + " ms");
    }
}
