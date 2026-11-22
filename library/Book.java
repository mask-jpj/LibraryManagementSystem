package library;

/**
 * Represents a library book.
 * @author abdullahshahid,nafay,muhammadabdullah
 */
public class Book {
    /** Book status. */
    public enum Status { AVAILABLE, ISSUED, RESERVED }

    private final String id;
    private String title, author;
    private Status status = Status.AVAILABLE;

    /**
     * Creates a book.
     * @param id unique ID
     * @param title book title
     * @param author book author
     */
    public Book(String id, String title, String author) {
        this.id = id; this.title = title; this.author = author;
    }

    /** @return the book ID */
    public String getId() { return id; }
    /** @return the title */
    public String getTitle() { return title; }
    /** @param title new title */
    public void setTitle(String title) { this.title = title; }
    /** @return the author */
    public String getAuthor() { return author; }
    /** @param author new author */
    public void setAuthor(String author) { this.author = author; }
    /** @return the status */
    public Status getStatus() { return status; }
    /** @param status new status */
    public void setStatus(Status status) { this.status = status; }
}