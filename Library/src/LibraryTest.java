/* LibraryTest.java
Library class tester for Library project.
Jack Margeson, 10/28/2019 */

import java.util.Scanner;

public class LibraryTest {
    // Create scanner.
    public static Scanner scanner = new Scanner(System.in);
    public static String s;

    public static void main(String[] args) {
        // Create library.
        // "The client can instantiate a book with a title and an author."
        Library library = new Library(155, 5);

        // Print library.
        // "The client can examine but not modify a book's title or author."
        System.out.println(library);

        // View book by title.
        // "The client can ask a patron whether it has borrowed a given book by title."
        System.out.println(library.viewBook(scanner.nextLine()));

        // Return book.
        // "The client can ask a patron to return a given book."
        s = library.returnBook(scanner.nextLine());
        System.out.println(library);
        System.out.println(s);

        // Let patron check out a new book.
        // "The client can tell a patron to borrow a given book."
        s = library.giveBook(Integer.parseInt(scanner.nextLine()));
        System.out.println(library);
        System.out.println(s);
    }
}
