// Compile-time Polymorphism (Method Overloading)
class MathOperation {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }
}

// Runtime Polymorphism (Method Overriding)
class Animal {
    void speak() {
        System.out.println("Animal speaks");
    }
}

class Cat extends Animal {
    @Override
    void speak() {
        System.out.println("Cat meows");
    }
}

public class Polymorphism {
    public static void main(String[] args) {
        MathOperation op = new MathOperation();
        System.out.println(op.add(2, 3)); // Output: 5
        System.out.println(op.add(2.5, 3.5)); // Output: 6.0

        Animal a = new Cat();
        a.speak(); // Output: Cat meows
    }
}
