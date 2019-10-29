/* Book.java
Book class for Library project.
Jack Margeson, 10/28/2019 */

public class Book {
    // Private data.
    private String title;
    private String author;

    // Constructors.
    // Default constructor.
    public Book() {
        this.title = null;
        this.author = null;
    }
    // Fill constructor.
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Gets and sets.
    // Gets.
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    // Sets.
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    // Member functions.
    // toString()
    // Returns a string of all private data.
    @Override
    public String toString() {
        if (this.title != null) {
            return (this.title + " by " + this.author);
        } else {
            return ("No book.");
        }
    }
}
