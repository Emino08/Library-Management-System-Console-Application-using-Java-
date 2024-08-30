import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Performance tests for the SearchAlgorithms class.
 */
public class SearchAlgorithmsPerformanceTest {

    private static final int LARGE_NUMBER_OF_BOOKS = 100000;

    /**
     * Tests the performance of binary search on a large list of books.
     */
    @Test
    public void testBinarySearchPerformance() {
        List<Book> books = new ArrayList<>();
        Author author = new Author("A001", "John Doe");
        Publisher publisher = new Publisher("P001", "Tech Books Inc.");

        // Create a large number of books
        for (int i = 0; i < LARGE_NUMBER_OF_BOOKS; i++) {
            books.add(new Book("ISBN" + i, "Title" + i, author, publisher));
        }

        // Ensure the list is sorted by title
        books.sort(Comparator.comparing(Book::getTitle));

        long startTime = System.currentTimeMillis();

        int index = SearchAlgorithms.binarySearch(books, "Title" + (LARGE_NUMBER_OF_BOOKS - 1));

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;

        System.out.println("Time taken to perform binary search on " + LARGE_NUMBER_OF_BOOKS + " books: " + duration + " ms");

        assertEquals(LARGE_NUMBER_OF_BOOKS - 1, index);
    }
}
