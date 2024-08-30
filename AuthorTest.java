import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AuthorTest {

    @Test
    public void testAuthorCreation() {
        Author author = new Author("A001", "John Doe");
        assertEquals("A001", author.getId());
        assertEquals("John Doe", author.getName());
    }

    @Test
    public void testAddBook() {
        Author author = new Author("A001", "John Doe");
        Publisher publisher = new Publisher("P001", "Tech Books Inc.");
        Book book = new Book("1234", "Java Programming", author, publisher);

        author.addBook(book);
        assertEquals(1, author.getBooks().size());
        assertEquals(book, author.getBooks().get(0));
    }
}
