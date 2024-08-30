import java.util.Date;

/**
 * Represents an Event hosted by the library.
 * Each event has a unique ID, a name, a date, and a description.
 */
public class LibraryEvent {
    private String id;            // Unique identifier for the event
    private String name;          // Name of the event
    private Date date;            // Date when the event takes place
    private String description;   // Description of the event

    /**
     * Constructor to initialize a LibraryEvent object.
     * @param id The unique identifier for the event.
     * @param name The name of the event.
     * @param date The date when the event takes place.
     * @param description A brief description of the event.
     */
    public LibraryEvent(String id, String name, Date date, String description) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.description = description;
    }

    /**
     * Retrieves the ID of the event.
     * @return The ID of the event.
     */
    public String getId() {
        return id;
    }

    /**
     * Retrieves the name of the event.
     * @return The name of the event.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the date of the event.
     * @return The date of the event.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Retrieves the description of the event.
     * @return The description of the event.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Retrieves the details of the event, including ID, name, date, and description.
     * @return A string containing the details of the event.
     */
    public String getDetails() {
        return "Event ID: " + id + ", Name: " + name + ", Date: " + date + ", Description: " + description;
    }
}
