// Inheritance Example
class Vehicle {
    void move() {
        System.out.println("Vehicle is moving");
    }
}

class Bike extends Vehicle {
    void soundHorn() {
        System.out.println("Bike horn sounds");
    }
}

public class Inheritance {
    public static void main(String[] args) {
        Bike b = new Bike();
        b.move();        // Output: Vehicle is moving
        b.soundHorn();   // Output: Bike horn sounds
    }
}
