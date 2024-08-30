import java.util.List;
/**
 * Manages the Library System, including initializing the library, handling user input, and executing library operations.
 */
public class LibraryManager {
    private final Library library;
    private final UserInterface userInterface;

    /**
     * Constructor to initialize a LibraryManager object.
     * Initializes the library and sets up the user interface.
     */
    public LibraryManager() {
        this.library = new Library();
        this.userInterface = new UserInterface();
        initializeLibrary();
    }

    /**
     * Initializes the library with some initial books and patrons.
     */
    private void initializeLibrary() {
        Author author1 = new Author("A001", "John Doe");
        Author author2 = new Author("A002", "Jane Smith");
        Publisher publisher1 = new Publisher("P001", "Tech Books Inc.");
        Publisher publisher2 = new Publisher("P002", "Literary Press");

        Book book1 = new Book("1234", "Java Programming", author1, publisher1);
        Book book2 = new Book("5678", "Data Structures", author2, publisher1);
        Book book3 = new Book("9012", "Great Novel", author2, publisher2);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.addPatron(new Patron("P001", "Alice"));
        library.addPatron(new Patron("P002", "Bob"));
    }


    /**
     * Runs the main loop of the library management system, allowing the user to select options from the menu.
     */
    public void run() {
        boolean running = true;
        while (running) {
            userInterface.displayMenu();
            String choice = userInterface.getUserInput();

            try {
                switch (choice) {
                    case "1":
                        addBook();
                        break;
                    case "2":
                        removeBook();
                        break;
                    case "3":
                        addPatron();
                        break;
                    case "4":
                        removePatron();
                        break;
                    case "5":
                        borrowBook();
                        break;
                    case "6":
                        returnBook();
                        break;
                    case "7":
                        searchBook();
                        break;
                    case "8":
                        displayAvailableBooks();
                        break;
                    case "9":
                        displayAllBooks();
                        break;
                    case "10":
                        displayAllPatrons();
                        break;
                    case "11":
                        generateReport();
                        break;
                    case "12":
                        searchBookByTitle();
                        break;
                    case "13":
                        sortAndSearchBook();
                        break;
                    case "0":
                        running = false;
                        userInterface.displayMessage("Thank you for using the Library Management System. Goodbye!");
                        break;
                    default:
                        userInterface.displayMessage("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                userInterface.displayMessage("An error occurred: " + e.getMessage());
            }
        }
    }

    /**
     * Adds a new book to the library.
     */
    void addBook() {
        try {
            userInterface.displayMessage("Enter book details:");
            String isbn = userInterface.getUserInput("ISBN: ").trim();
            if (isbn.isEmpty()) throw new IllegalArgumentException("ISBN cannot be empty.");

            String title = userInterface.getUserInput("Title: ").trim();
            if (title.isEmpty()) throw new IllegalArgumentException("Title cannot be empty.");

            String authorName = userInterface.getUserInput("Author Name: ").trim();
            if (authorName.isEmpty()) throw new IllegalArgumentException("Author Name cannot be empty.");

            String publisherName = userInterface.getUserInput("Publisher Name: ").trim();
            if (publisherName.isEmpty()) throw new IllegalArgumentException("Publisher Name cannot be empty.");

            Author author = new Author("A" + System.currentTimeMillis(), authorName);
            Publisher publisher = new Publisher("P" + System.currentTimeMillis(), publisherName);
            Book book = new Book(isbn, title, author, publisher);

            library.addBook(book);
            userInterface.displayMessage("Book added successfully.");
        } catch (IllegalArgumentException e) {
            userInterface.displayMessage("Error: " + e.getMessage());
        } catch (Exception e) {
            userInterface.displayMessage("An unexpected error occurred while adding the book.");
        }
    }



    /**
     * Removes an existing book from the library.
     */
    void removeBook() {
    try {
        String isbn = userInterface.getUserInput("Enter ISBN of the book to remove: ").trim();
        if (isbn.isEmpty()) throw new IllegalArgumentException("ISBN cannot be empty.");

        Book book = library.searchBook(isbn);
        if (book != null) {
            library.removeBook(book);
            userInterface.displayMessage("Book removed successfully.");
        } else {
            userInterface.displayMessage("Book not found.");
        }
    } catch (IllegalArgumentException e) {
        userInterface.displayMessage("Error: " + e.getMessage());
    } catch (Exception e) {
        userInterface.displayMessage("An unexpected error occurred while removing the book.");
    }
}


    /**
     * Adds a new patron to the library.
     */
    void addPatron() {
        try {
            userInterface.displayMessage("Enter patron details:");
            String id = userInterface.getUserInput("Patron ID: ").trim();
            if (id.isEmpty()) throw new IllegalArgumentException("Patron ID cannot be empty.");

            String name = userInterface.getUserInput("Patron Name: ").trim();
            if (name.isEmpty()) throw new IllegalArgumentException("Patron Name cannot be empty.");

            Patron patron = new Patron(id, name);
            library.addPatron(patron);
            userInterface.displayMessage("Patron added successfully.");
        } catch (IllegalArgumentException e) {
            userInterface.displayMessage("Error: " + e.getMessage());
        } catch (Exception e) {
            userInterface.displayMessage("An unexpected error occurred while adding the patron.");
        }
    }


    /**
     * Removes an existing patron from the library.
     */
    void removePatron() {
    try {
        String id = userInterface.getUserInput("Enter ID of the patron to remove: ").trim();
        if (id.isEmpty()) throw new IllegalArgumentException("Patron ID cannot be empty.");

        Patron patron = library.searchPatron(id);
        if (patron != null) {
            library.removePatron(id);
            userInterface.displayMessage("Patron removed successfully.");
        } else {
            userInterface.displayMessage("Patron not found.");
        }
    } catch (IllegalArgumentException e) {
        userInterface.displayMessage("Error: " + e.getMessage());
    } catch (Exception e) {
        userInterface.displayMessage("An unexpected error occurred while removing the patron.");
    }
}


    /**
     * Allows a patron to borrow a book from the library.
     */
    void borrowBook() {
        try {
            String patronId = userInterface.getUserInput("Enter patron ID: ").trim();
            String isbn = userInterface.getUserInput("Enter ISBN of the book to borrow: ").trim();

            if (patronId.isEmpty()) throw new IllegalArgumentException("Patron ID cannot be empty.");
            if (isbn.isEmpty()) throw new IllegalArgumentException("ISBN cannot be empty.");

            library.borrowBook(patronId, isbn);
        } catch (IllegalArgumentException e) {
            userInterface.displayMessage("Error: " + e.getMessage());
        } catch (Exception e) {
            userInterface.displayMessage("An unexpected error occurred while borrowing the book.");
        }
    }


    /**
     * Allows a patron to return a borrowed book to the library.
     */
    void returnBook() {
    try {
        String patronId = userInterface.getUserInput("Enter patron ID: ").trim();
        String isbn = userInterface.getUserInput("Enter ISBN of the book to return: ").trim();

        if (patronId.isEmpty()) throw new IllegalArgumentException("Patron ID cannot be empty.");
        if (isbn.isEmpty()) throw new IllegalArgumentException("ISBN cannot be empty.");

        library.returnBook(patronId, isbn);
    } catch (IllegalArgumentException e) {
        userInterface.displayMessage("Error: " + e.getMessage());
    } catch (Exception e) {
        userInterface.displayMessage("An unexpected error occurred while returning the book.");
    }
}


    /**
     * Searches for a book in the library by its ISBN.
     *
     */
    List<Book> searchBook() {
    try {
        String isbn = userInterface.getUserInput("Enter ISBN of the book to search: ").trim();
        if (isbn.isEmpty()) throw new IllegalArgumentException("ISBN cannot be empty.");

        Book book = library.searchBook(isbn);
        if (book != null) {
            userInterface.displayMessage("Book found: " + book.getDetails());
        } else {
            userInterface.displayMessage("Book not found.");
        }
    } catch (IllegalArgumentException e) {
        userInterface.displayMessage("Error: " + e.getMessage());
    } catch (Exception e) {
        userInterface.displayMessage("An unexpected error occurred while searching for the book.");
    }
        return null;
    }



    /**
     * Displays all available (not borrowed) books in the library.
     */
private void displayAvailableBooks() {
    try {
        List<Book> availableBooks = library.getBooks();
        if (availableBooks.isEmpty()) {
            userInterface.displayMessage("No available books found.");
            return;
        }

        userInterface.displayMessage("Available books:");
        for (Book book : availableBooks) {
            if (book.isAvailable()) {
                userInterface.displayMessage(book.getDetails());
            }
        }
    } catch (Exception e) {
        userInterface.displayMessage("An unexpected error occurred while displaying available books.");
    }
}


    /**
     * Displays all books in the library, regardless of availability.
     */
    private void displayAllBooks() {
        try {
            List<Book> allBooks = library.getBooks();
            if (allBooks.isEmpty()) {
                userInterface.displayMessage("No books found in the library.");
                return;
            }

            userInterface.displayMessage("All books:");
            for (Book book : allBooks) {
                userInterface.displayMessage(book.getDetails());
            }
        } catch (Exception e) {
            userInterface.displayMessage("An unexpected error occurred while displaying all books.");
        }
    }


    /**
     * Displays all patrons registered in the library.
     */
    private void displayAllPatrons() {
        try {
            List<Patron> allPatrons = library.getPatrons();
            if (allPatrons.isEmpty()) {
                userInterface.displayMessage("No patrons found in the library.");
                return;
            }

            userInterface.displayMessage("All patrons:");
            for (Patron patron : allPatrons) {
                userInterface.displayMessage(patron.getDetails());
            }
        } catch (Exception e) {
            userInterface.displayMessage("An unexpected error occurred while displaying all patrons.");
        }
    }


    /**
     * Generates a summary report of the library, including total books and patrons.
     *
     */
    String generateReport() {
        try {
            Report report = new Report(library);
            String reportSummary = report.generateSummaryReport();
            userInterface.displayMessage(reportSummary);
        } catch (Exception e) {
            userInterface.displayMessage("An unexpected error occurred while generating the report.");
        }
        return null;
    }



    /**
     * Searches for books by their title in the library.
     */
    private void searchBookByTitle() {
        try {
            String title = userInterface.getUserInput("Enter the title to search: ").trim();
            if (title.isEmpty()) throw new IllegalArgumentException("Title cannot be empty.");

            List<Book> foundBooks = library.searchBooksByTitle(title);
            if (foundBooks.isEmpty()) {
                userInterface.displayMessage("No books found with the given title.");
            } else {
                userInterface.displayMessage("Books found:");
                for (Book book : foundBooks) {
                    userInterface.displayMessage(book.getDetails());
                }
            }
        } catch (IllegalArgumentException e) {
            userInterface.displayMessage("Error: " + e.getMessage());
        } catch (Exception e) {
            userInterface.displayMessage("An unexpected error occurred while searching books by title.");
        }
    }


    /**
     * Sorts books by title and searches for a specific book by its exact title.
     *
     */
    Book sortAndSearchBook() {
        try {
            library.sortBooksByTitle();
            String title = userInterface.getUserInput("Enter the exact title to search: ").trim();
            if (title.isEmpty()) throw new IllegalArgumentException("Title cannot be empty.");

            int index = SearchAlgorithms.binarySearch(library.getBooks(), title);
            if (index != -1) {
                userInterface.displayMessage("Book found: " + library.getBooks().get(index).getDetails());
            } else {
                userInterface.displayMessage("Book not found.");
            }
        } catch (IllegalArgumentException e) {
            userInterface.displayMessage("Error: " + e.getMessage());
        } catch (Exception e) {
            userInterface.displayMessage("An unexpected error occurred while sorting and searching the book.");
        }
        return null;
    }

    /**
     * The main method to run the Library Management System.
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();
        manager.run();
    }
}
