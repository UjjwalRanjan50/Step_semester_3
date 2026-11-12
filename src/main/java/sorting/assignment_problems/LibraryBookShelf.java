package sorting.assignment_problems;

/**
 * Problem 3: The Library Book Shelf
 * 
 * Sorts books in ascending order using Insertion Sort.
 * Simulates placing books onto a shelf one by one and inserting each new book into its correct place.
 * Prints the shelf after each book (from the second book onwards) is placed.
 */
public class LibraryBookShelf {

    public static String formatArray(int[] arr) {
        if (arr == null) return "null";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Sorts the books array in increasing order and prints after placing each book.
     *
     * @param books array of book numbers
     */
    public static void shelf(int[] books) {
        if (books == null || books.length <= 1) {
            return;
        }

        for (int i = 1; i < books.length; i++) {
            int key = books[i];
            int j = i - 1;

            while (j >= 0 && books[j] > key) {
                books[j + 1] = books[j];
                j--;
            }
            books[j + 1] = key;

            System.out.println("After placing " + key + ": " + formatArray(books));
        }
    }

    public static void main(String[] args) {
        System.out.println("Sample 1:");
        int[] books1 = {30, 10, 40, 20};
        shelf(books1);

        System.out.println("\nCustom Input:");
        int[] booksCustom = {55, 25, 65, 15, 35};
        shelf(booksCustom);
    }
}
