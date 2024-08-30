import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.IntStream;

public class LibraryPerformanceTest {

    @Test
    public void testLargeScaleBookSortingPerformance() {
        Library library = new Library();

        IntStream.range(0, 10000).forEach(i -> {
            Author author = new Author("A" + i, "Author " + i);
            Publisher publisher = new Publisher("P" + i, "Publisher " + i);
            Book book = new Book(String.valueOf(i), "Title " + i, author, publisher);
            library.addBook(book);
        });

        long startTime = System.currentTimeMillis();
        library.sortBooksByTitle();
        long endTime = System.currentTimeMillis();

        System.out.println("Sorting time: " + (endTime - startTime) + " ms");

        assertTrue((endTime - startTime) < 2000); // Example threshold
    }
}
