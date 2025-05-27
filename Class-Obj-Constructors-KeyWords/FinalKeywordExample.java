// Final class can't be extended
final class Vehicle {
    // Final variable - constant
    final int wheels = 4;

    // Final method - can't be overridden
    final void showType() {
        System.out.println("Four-wheeler vehicle");
    }
}

public class FinalKeywordExample {
    public static void main(String[] args) {
        Vehicle v = new Vehicle();
        System.out.println("Wheels: " + v.wheels);
        v.showType();
    }
}
