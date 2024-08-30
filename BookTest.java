import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    @Test
    public void testBookCreation() {
        Author author = new Author("A001", "John Doe");
        Publisher publisher = new Publisher("P001", "Tech Books Inc.");
        Book book = new Book("1234", "Java Programming", author, publisher);

        assertEquals("1234", book.getIsbn());
        assertEquals("Java Programming", book.getTitle());
        assertEquals(author, book.getAuthor());
        assertEquals(publisher, book.getPublisher());
        assertTrue(book.isAvailable());
    }

    @Test
    public void testSetAvailability() {
        Author author = new Author("A001", "John Doe");
        Publisher publisher = new Publisher("P001", "Tech Books Inc.");
        Book book = new Book("1234", "Java Programming", author, publisher);

        book.setAvailable(false);
        assertFalse(book.isAvailable());
    }

    @Test
    public void testCompareTo() {
        Author author = new Author("A001", "John Doe");
        Publisher publisher = new Publisher("P001", "Tech Books Inc.");
        Book book1 = new Book("1234", "Java Programming", author, publisher);
        Book book2 = new Book("5678", "Data Structures", author, publisher);

        assertTrue(book1.compareTo(book2) < 0);
    }
}
