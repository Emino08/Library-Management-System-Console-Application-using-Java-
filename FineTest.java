import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FineTest {

    @Test
    public void testFineCreation() {
        Patron patron = new Patron("P001", "Alice");
        Fine fine = new Fine("F001", patron, 50.0, "Late return");

        assertEquals("F001", fine.getId());
        assertEquals(patron, fine.getPatron());
        assertEquals(50.0, fine.getAmount());
        assertEquals("Late return", fine.getReason());
    }

    @Test
    public void testPayFine() {
        Patron patron = new Patron("P001", "Alice");
        Fine fine = new Fine("F001", patron, 50.0, "Late return");

        patron.addFine(fine);
        assertEquals(1, patron.getFines().size());

        fine.pay(30.0);
        assertEquals(20.0, fine.getAmount());

        fine.pay(20.0);
        assertEquals(0, patron.getFines().size());
    }
}
