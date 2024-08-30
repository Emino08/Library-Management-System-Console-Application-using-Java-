import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    @Test
    public void testAddBook() {
        Library library = new Library();
        Author author = new Author("A001", "John Doe");
        Publisher publisher = new Publisher("P001", "Tech Books Inc.");
        Book book = new Book("1234", "Java Programming", author, publisher);

        library.addBook(book);
        assertEquals(1, library.getBooks().size());
        assertEquals(book, library.getBooks().get(0));
    }

    @Test
    public void testSearchBookByIsbn() {
        Library library = new Library();
        Author author = new Author("A001", "John Doe");
        Publisher publisher = new Publisher("P001", "Tech Books Inc.");
        Book book = new Book("1234", "Java Programming", author, publisher);

        library.addBook(book);
        Book foundBook = library.searchBook("1234");

        assertNotNull(foundBook);
        assertEquals(book, foundBook);
    }
}
