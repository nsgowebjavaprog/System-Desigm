// Abstract class - Abstraction
abstract class Animal {
    // Abstract method (no body)
    abstract void makeSound();

    // Concrete method
    void sleep() {
        System.out.println("Sleeping...");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Dog barks");
    }
}

public class Abstraction {
    public static void main(String[] args) {
        Animal a = new Dog();
        a.makeSound();  // Output: Dog barks
        a.sleep();      // Output: Sleeping...
    }
}
