package LSP;

class Bird {
    public void fly() {
        System.out.println("Bird is flying");
    }
}

class Sparrow extends Bird {
    public void fly() {
        System.out.println("Sparrow is flying");
    }
}

class Ostrich extends Bird {
    public void fly() {
        throw new UnsupportedOperationException("Ostrich cannot fly!");
    }
}

// Usage
public class LSPDemo {
    public static void makeBirdFly(Bird bird) {
        bird.fly();
    }

    public static void main(String[] args) {
        Bird sparrow = new Sparrow();
        Bird ostrich = new Ostrich();

        makeBirdFly(sparrow); // Works fine
        makeBirdFly(ostrich); // Throws exception - violates LSP
    }
}
