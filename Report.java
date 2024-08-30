import java.util.List;

/**
 * Generates reports for the library, summarizing various aspects such as the number of books and patrons.
 */
public class Report {
    private Library library;

    /**
     * Constructor to initialize a Report object.
     * @param library The library for which the report is generated.
     */
    public Report(Library library) {
        this.library = library;
    }

    /**
     * Generates a summary report of the library.
     * The report includes the total number of books, patrons, available books, and borrowed books.
     * @return A string containing the summary report.
     */

    public String generateSummaryReport() {
        StringBuilder report = new StringBuilder();
        report.append("Library Summary Report\n");
        report.append("----------------------\n");
        List<Book> books = library.getBooks();
        List<Patron> patrons = library.getPatrons();
        int availableBooks = 0;
        int borrowedBooks = 0;
        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks++;
            } else {
                borrowedBooks++;
            }
        }

        report.append("Total Books: ").append(books.size()).append("\n");
        report.append("Total Patrons: ").append(patrons.size()).append("\n");
        report.append("Available Books: ").append(availableBooks).append("\n");
        report.append("Borrowed Books: ").append(borrowedBooks).append("\n");
        return report.toString();
    }

}