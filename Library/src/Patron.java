/* Patron.java
Patron class for Library project.
Jack Margeson, 10/28/2019 */

public class Patron {
    // Private data.
    private String name;
    private Book[] books;

    // Constructors.
    // Default constructor.
    public Patron() {
        this.name = null;
        this.books = new Book[3];
        for (int i = 0; i < 3; i++) {
            this.books[i] = null;
        }
    }
    // Fill constructor.
    public Patron(String name, Book[] b1) {
        this.name = name;
        this.books = b1;
    }

    // Gets and sets.
    // Gets.
    public String getName() {
        return name;
    }
    public Book[] getBooks() {
        return books;
    }
    // Sets.
    public void setName(String name) {
        this.name = name;
    }
    public void setBooks(Book[] books) {
        this.books = books;
    }

    // Member functions.
    // toString()
    // Returns a string of all private data.
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        if (this.name != null) {
            s.append("Name: ").append(this.name).append("\n");
        } else {
            s.append("No name.").append("\n");
        }
        for (int i = 0; i < this.books.length; i++) {
            if (this.books[i] != null) {
                s.append(this.books[i].toString()).append("\n");
            } else {
                s.append("No book.").append("\n");
            }
        }
        return(s.toString());
    }
}
