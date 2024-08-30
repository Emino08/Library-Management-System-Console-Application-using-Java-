import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {

    @Test
    public void testAddBook() {
        Inventory inventory = new Inventory();
        Author author = new Author("A001", "John Doe");
        Publisher publisher = new Publisher("P001", "Tech Books Inc.");
        Book book = new Book("1234", "Java Programming", author, publisher);

        inventory.addBook(book, 5);
        assertEquals(5, inventory.getQuantity(book));
    }

    @Test
    public void testRemoveBook() {
        Inventory inventory = new Inventory();
        Author author = new Author("A001", "John Doe");
        Publisher publisher = new Publisher("P001", "Tech Books Inc.");
        Book book = new Book("1234", "Java Programming", author, publisher);

        inventory.addBook(book, 5);
        inventory.removeBook(book, 2);
        assertEquals(3, inventory.getQuantity(book));

        inventory.removeBook(book, 3);
        assertEquals(0, inventory.getQuantity(book));
    }
}
