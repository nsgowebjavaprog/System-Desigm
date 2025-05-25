// Abstraction using abstract class
abstract class Car {
    protected String brand;

    public Car(String brand) {
        this.brand = brand;
    }

    abstract void start();

    abstract void stop();
}

// Encapsulation: Engine class hides temperature logic
class Engine {
    private int temperature;

    public void setTemperature(int temp) {
        if (temp >= 0 && temp <= 120) {
            this.temperature = temp;
        }
    }

    public int getTemperature() {
        return this.temperature;
    }
}

// Inheritance and Method Overriding
class ModernCar extends Car {
    Engine engine = new Engine();

    public ModernCar(String brand) {
        super(brand);
    }

    @Override
    void start() {
        engine.setTemperature(70);
        System.out.println(brand + " Modern Car started. Temp: " + engine.getTemperature());
    }

    @Override
    void stop() {
        System.out.println(brand + " Modern Car stopped.");
    }
}

// Polymorphism via method overriding
class ElectricCar extends ModernCar {
    public ElectricCar(String brand) {
        super(brand);
    }

    @Override
    void start() {
        System.out.println(brand + " Electric Car started silently.");
    }

    public void chargeBattery() {
        System.out.println(brand + " Battery charging...");
    }
}

// Driver Class
public class LLD_Car_Project {
    public static void main(String[] args) {
        Car tesla = new ElectricCar("Tesla"); // Polymorphic behavior
        tesla.start(); // Calls overridden method
        tesla.stop();

        Car honda = new ModernCar("Honda");
        honda.start();
        honda.stop();
    }
}
