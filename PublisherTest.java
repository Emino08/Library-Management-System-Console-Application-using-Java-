import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PublisherTest {

    @Test
    public void testPublisherCreation() {
        Publisher publisher = new Publisher("P001", "Tech Books Inc.");
        assertEquals("P001", publisher.getId());
        assertEquals("Tech Books Inc.", publisher.getName());
    }

    @Test
    public void testAddBook() {
        Publisher publisher = new Publisher("P001", "Tech Books Inc.");
        Author author = new Author("A001", "John Doe");
        Book book = new Book("1234", "Java Programming", author, publisher);

        publisher.addBook(book);
        assertEquals(1, publisher.getBooks().size());
        assertEquals(book, publisher.getBooks().get(0));
    }
}
