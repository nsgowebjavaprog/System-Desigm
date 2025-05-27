// Class with constructor and new keyword usage
class Laptop {
    String brand;

    Laptop(String brand) {
        this.brand = brand;
    }

    void display() {
        System.out.println("Brand: " + brand);
    }
}

public class NewKeywordExample {
    public static void main(String[] args) {
        // Using new keyword to create object
        Laptop l1 = new Laptop("Dell");
        l1.display();
    }
}
