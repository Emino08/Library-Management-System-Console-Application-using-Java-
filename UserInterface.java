import java.util.Scanner;

/**
 * Handles user interaction for the Library Management System, including displaying menus and collecting input.
 */
public class UserInterface {
    private Scanner scanner; // Scanner object for reading user input

    /**
     * Constructor to initialize a UserInterface object.
     * Initializes the scanner for reading user input.
     */
    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Displays the main menu of the Library Management System.
     */
    public void displayMenu() {
        System.out.println("\nLibrary Management System");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. Add Patron");
        System.out.println("4. Remove Patron");
        System.out.println("5. Borrow Book");
        System.out.println("6. Return Book");
        System.out.println("7. Search Book by ISBN");
        System.out.println("8. Display Available Books");
        System.out.println("9. Display All Books");
        System.out.println("10. Display All Patrons");
        System.out.println("11. Generate Report");
        System.out.println("12. Search Book by Title");
        System.out.println("13. Sort Books and Search by Title");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    /**
     * Retrieves user input as a string.
     * @return The user's input.
     */
    public String getUserInput() {
        return scanner.nextLine().trim();
    }

    /**
     * Retrieves user input as a string with a prompt message.
     * @param prompt The prompt message to display.
     * @return The user's input.
     */
    public String getUserInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    /**
     * Displays a message to the user.
     * @param message The message to display.
     */
    public void displayMessage(String message) {
        System.out.println(message);
    }
}
