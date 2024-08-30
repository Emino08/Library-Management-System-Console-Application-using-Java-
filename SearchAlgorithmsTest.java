import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class SearchAlgorithmsTest {

    @Test
    public void testBinarySearchFound() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("1234", "A Title", null, null));
        books.add(new Book("5678", "B Title", null, null));
        books.add(new Book("9012", "C Title", null, null));

        int index = SearchAlgorithms.binarySearch(books, "B Title");
        assertEquals(1, index);
    }

    @Test
    public void testBinarySearchNotFound() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("1234", "A Title", null, null));
        books.add(new Book("5678", "B Title", null, null));
        books.add(new Book("9012", "C Title", null, null));

        int index = SearchAlgorithms.binarySearch(books, "D Title");
        assertEquals(-1, index);
    }
}
