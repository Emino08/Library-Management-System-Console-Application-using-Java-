import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PatronTest {

    @Test
    public void testPatronCreation() {
        Patron patron = new Patron("P001", "Alice");
        assertEquals("P001", patron.getId());
        assertEquals("Alice", patron.getName());
    }

    @Test
    public void testBorrowBook() {
        Patron patron = new Patron("P001", "Alice");
        Author author = new Author("A001", "John Doe");
        Publisher publisher = new Publisher("P001", "Tech Books Inc.");
        Book book = new Book("1234", "Java Programming", author, publisher);

        patron.borrowBook(book);
        assertFalse(book.isAvailable());
        assertEquals(1, patron.getBorrowedBooks().size());
    }

    @Test
    public void testReturnBook() {
        Patron patron = new Patron("P001", "Alice");
        Author author = new Author("A001", "John Doe");
        Publisher publisher = new Publisher("P001", "Tech Books Inc.");
        Book book = new Book("1234", "Java Programming", author, publisher);

        patron.borrowBook(book);
        patron.returnBook(book);

        assertTrue(book.isAvailable());
        assertEquals(0, patron.getBorrowedBooks().size());
    }
}
