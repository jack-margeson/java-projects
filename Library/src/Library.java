/* Library.java
Library class for Library project.
Jack Margeson, 10/28/2019 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Library {
    // Private data.
    private Book[] books;
    private Patron[] patrons;

    // Constructors.
    // Default constructors.
    public Library() {
        this.books = loadBooks(0);
        this.patrons = loadPatrons(0);
    }
    // Fill constructor.
    public Library(int books, int patrons) {
        this.books = loadBooks(books);
        this.patrons = loadPatrons(patrons);
    }

    // Member functions.
    // loadBooks()
    // Loads books from file.
    private Book[] loadBooks(int c) {
        Book[] books = new Book[c];
        try {
            Scanner scanner = new Scanner(new File("books.txt"));
            int j = 0;
            while (scanner.hasNextLine() && j < c) {
                String s = scanner.nextLine();
                books[j] = new Book(s.split("-")[0], s.split("-")[1]);
                j++;
            }
        } catch (FileNotFoundException err) {
            err.printStackTrace();
        }
        return(books);
    }
    // loadPatrons()
    // Load patrons from file and assigns them 0-3 books.
    private Patron[] loadPatrons(int c) {
        Patron[] patrons = new Patron[c];
        // Generate patron names.
        String[] first = new String[100];
        String[] last = new String[100];
        String[] name = new String[100];

        // Load first names from file.
        try {
            Scanner scanner = new Scanner(new File("first.txt"));
            int j = 0;
            while (scanner.hasNextLine()) {
                first[j] = scanner.nextLine();
                j++;
            }
        } catch (FileNotFoundException err) {
            err.printStackTrace();
        }
        // Load last names from file.
        try {
            Scanner scanner = new Scanner(new File("last.txt"));
            int j = 0;
            while (scanner.hasNextLine()) {
                last[j] = scanner.nextLine();
                j++;
            }
        } catch (FileNotFoundException err) {
            err.printStackTrace();
        }
        // Combine first and last.
        for (int i = 0; i < 100; i++) {
            name[i] = first [i] + " " + last[i];
        }

        // Random number.
        Random r = new Random();
        // Create patrons.
        for (int i = 0; i < c; i++) {
            patrons[i] = new Patron(name[r.nextInt(100)], new Book[]{this.books[r.nextInt(this.books.length)], this.books[r.nextInt(this.books.length)], new Book()});
            // TSystem.out.println(patrons[i].getBooks()[0].getTitle());
        }
        return(patrons);
    }
    // viewBook()
    // Returns information about a book based on search.
    public String viewBook(String title) {
       for(Patron patron:this.patrons) {
           for (Book book:patron.getBooks()) {
               if (title.equals(book.getTitle())) {
                   return("Book title: " + book.getTitle() + "\n" +
                           "Book author: " + book.getAuthor() + "\n" +
                           "This book is already checked out by " + patron.getName() + ".");
               }
           }
       }
       return("Book title: " + title + "\n" + "This book is not checked out.");
    }
    // returnBook()
    // Forces patron to return a book by title.
    public String returnBook(String title) {
        for(Patron patron:this.patrons) {
            for (Book book:patron.getBooks()) {
                if (title.equals(book.getTitle())) {
                    book.setTitle(null);
                    book.setAuthor(null);
                    return("Book title: " + title + "\n" +
                            "The book checked out by " + patron.getName() + " has been returned.");
                }
            }
        }
        return("Book title: " + title + "\n" + "This book is not checked out.");
    }
    // giveBook()
    // Gives a book to the selected patron.
    public String giveBook(int patron) {
        Random r = new Random();

        for (Book book:this.patrons[patron].getBooks()) {
            if (book.getTitle() == null) {
                Book tempbook = this.books[r.nextInt(this.books.length)];
                book.setTitle(tempbook.getTitle());
                book.setAuthor(tempbook.getAuthor());
                return(this.patrons[patron].getName() + " has now checked out a copy of " + tempbook.getTitle() + ".");
            }
        }
        return("This patron has already checked out the maximum number of books.");
    }
    // toString()
    // Returns a string of the tester variables.
    @Override
    public String toString() {
       StringBuilder s = new StringBuilder();
       for (int i = 0; i < patrons.length; i++) {
           s.append(patrons[i]).append("\n");
       }
       s.append("Currently there are ").append(this.patrons.length).append(" patrons and the library owns ").append(this.books.length).append(" books.").append("\n");
       return(s.toString());
    }
}
