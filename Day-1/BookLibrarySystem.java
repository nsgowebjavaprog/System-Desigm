//      | Concept                       | How It's Shown                                                            |
//      | ----------------------------- | ------------------------------------------------------------------------- |
//      | **OOP Principles**            | Classes (`Book`, `Library`), encapsulation, abstraction                   |
//      | **Responsibility Separation** | `Book` = data, `Library` = behavior                                       |
//      | **LLD Real-World Thinking**   | Scalable for user system, database, and features like fines or categories |
//      | **Testable Design**           | Easy to add unit tests and mocks                                          |



// ------- Book Library System in One File -------

import java.util.ArrayList;
import java.util.List;

// Main class that contains all logic and entry point
public class BookLibrarySystem {

    // Book class to represent a book entity
    static class Book {
        private String id;
        private String title;
        private String author;
        private boolean isAvailable = true;

        // Constructor to initialize book details
        public Book(String id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
        }

        // Check if the book is available
        public boolean isAvailable() {
            return isAvailable;
        }

        // Mark book as borrowed
        public void borrow() {
            isAvailable = false;
        }

        // Mark book as returned
        public void returned() {
            isAvailable = true;
        }

        // Get book title
        public String getTitle() {
            return title;
        }

        // Optional: Get book details
        @Override
        public String toString() {
            return "[" + id + "] " + title + " by " + author + (isAvailable ? " (Available)" : " (Borrowed)");
        }
    }

    // Library class to manage a collection of books
    static class Library {
        private List<Book> books = new ArrayList<>();

        // Add a new book to the library
        public void addBook(Book b) {
            books.add(b);
        }

        // Borrow a book by its title
        public Book borrowBook(String title) {
            for (Book book : books) {
                if (book.getTitle().equalsIgnoreCase(title) && book.isAvailable()) {
                    book.borrow();
                    return book;
                }
            }
            return null; // Book not found or not available
        }

        // Return a book
        public void returnBook(Book b) {
            b.returned();
        }

        // Display all books in the library
        public void showBooks() {
            System.out.println("\nLibrary Book List:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    // Main method to run the system
    public static void main(String[] args) {
        Library library = new Library();

        // Add books to the library
        Book book1 = new Book("1", "Java Basics", "John Doe");
        Book book2 = new Book("2", "Data Structures", "Alice Smith");
        Book book3 = new Book("3", "System Design", "Robert Martin");

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Show all books
        library.showBooks();

        // Try to borrow a book
        Book issued = library.borrowBook("Java Basics");
        if (issued != null) {
            System.out.println("\nBorrowed: " + issued.getTitle());
        } else {
            System.out.println("\nBook not available.");
        }

        // Show books after borrowing
        library.showBooks();

        // Return the book
        library.returnBook(issued);
        System.out.println("\nReturned: " + issued.getTitle());

        // Final book status
        library.showBooks();
    }
}