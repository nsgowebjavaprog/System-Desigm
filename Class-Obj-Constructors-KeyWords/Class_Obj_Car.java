// Class  & Object

class Car {
    // Model and Speed
    String model;
    float speed;

    void display() {
        System.out.println("Model: " + model + " Speed of Car: " + speed);
    }
}

public class Class_Obj_Car {
    public static void main(String[] args) {
        // Create the Obj
        Car car_1 = new Car();
        car_1.model = "BMW";
        car_1.speed = 245.5f;
        car_1.display();
    }
}