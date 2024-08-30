import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class LibraryEventTest {

    @Test
    public void testLibraryEventCreation() {
        Date date = new Date();
        LibraryEvent event = new LibraryEvent("E001", "Book Fair", date, "Annual Book Fair Event");

        assertEquals("E001", event.getId());
        assertEquals("Book Fair", event.getName());
        assertEquals(date, event.getDate());
        assertEquals("Annual Book Fair Event", event.getDescription());
    }

    @Test
    public void testGetEventDetails() {
        Date date = new Date();
        LibraryEvent event = new LibraryEvent("E001", "Book Fair", date, "Annual Book Fair Event");

        String expectedDetails = "Event ID: E001, Name: Book Fair, Date: " + date + ", Description: Annual Book Fair Event";
        assertEquals(expectedDetails, event.getDetails());
    }
}
