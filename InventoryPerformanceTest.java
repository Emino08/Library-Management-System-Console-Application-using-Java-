import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Performance tests for the Inventory class.
 */
public class InventoryPerformanceTest {

    private static final int LARGE_NUMBER_OF_OPERATIONS = 10000;

    /**
     * Tests the performance of adding and removing books from Inventory.
     */
    @Test
    public void testAddAndRemoveBooksPerformance() {
        Inventory inventory = new Inventory();
        Author author = new Author("A001", "John Doe");
        Publisher publisher = new Publisher("P001", "Tech Books Inc.");
        Book book = new Book("1234", "Java Programming", author, publisher);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < LARGE_NUMBER_OF_OPERATIONS; i++) {
            inventory.addBook(book, 1);
            inventory.removeBook(book, 1);
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("Time taken to add and remove a book " + LARGE_NUMBER_OF_OPERATIONS + " times: " + duration + " ms");
    }
}
