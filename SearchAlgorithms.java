import java.util.List;

/**
 * Provides search algorithms to be used in the library system.
 */
public class SearchAlgorithms {

    /**
     * Performs a binary search on a list of books to find a book by its title.
     * Assumes that the list is sorted by title in ascending order.
     * @param books The list of books to search.
     * @param targetTitle The title of the book to search for.
     * @return The index of the book in the list if found, or -1 if not found.
     */
    public static int binarySearch(List<Book> books, String targetTitle) {
        int left = 0;
        int right = books.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books.get(mid).getTitle().compareTo(targetTitle);

            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Book not found
    }
}
