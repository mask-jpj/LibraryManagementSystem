package library;

import java.util.*;

/**
 * Manages books and validates input.
 * @author abdullahshahid,nafay,muhammadabdullah
 */
public class LibraryManager {
    private final Map<String, Book> books = new LinkedHashMap<>();

    private void check(String s, String name) {
        if (s == null || s.trim().isEmpty())
            throw new IllegalArgumentException(name + " cannot be empty");
    }

    /**
     * Adds a book.
     * @param id book ID
     * @param title title
     * @param author author
     * @throws IllegalArgumentException if a field is empty or ID is duplicate
     */
    public void add(String id, String title, String author) {
        check(id, "ID"); check(title, "Title"); check(author, "Author");
        id = id.trim();
        if (books.containsKey(id))
            throw new IllegalArgumentException("Book ID already exists");
        books.put(id, new Book(id, title.trim(), author.trim()));
    }

    /** @return all books in insertion order */
    public List<Book> getAll() { return new ArrayList<>(books.values()); }

    /**
     * Updates a book.
     * @param id book ID
     * @param title new title
     * @param author new author
     * @param status new status
     * @throws IllegalArgumentException if not found or fields empty
     */
    public void update(String id, String title, String author, Book.Status status) {
        Book b = books.get(id == null ? "" : id.trim());
        if (b == null) throw new IllegalArgumentException("Book not found");
        check(title, "Title"); check(author, "Author");
        b.setTitle(title.trim()); b.setAuthor(author.trim()); b.setStatus(status);
    }

    /**
     * Deletes a book.
     * @param id book ID
     * @throws IllegalArgumentException if not found
     */
    public void delete(String id) {
        if (id == null || books.remove(id.trim()) == null)
            throw new IllegalArgumentException("Book not found");
    }
}