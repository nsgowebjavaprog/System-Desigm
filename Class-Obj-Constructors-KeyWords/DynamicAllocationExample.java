// Constructor with parameter - dynamic allocation
class Book {
    String title;

    Book(String t) {
        title = t;
    }

    void show() {
        System.out.println("Book: " + title);
    }
}

public class DynamicAllocationExample {
    public static void main(String[] args) {
        // Memory allocated dynamically using new
        Book b1 = new Book("Java Programming with OOPs and LLD Design");
        b1.show();
    }
}
