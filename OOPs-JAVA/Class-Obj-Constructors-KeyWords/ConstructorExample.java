// Class with a default constructor
class Student {
    String name;

    Student() {
        // default value assignment
        name = "Unknown";
    }

    void show() {
        System.out.println("Name: " + name);
    }
}

public class ConstructorExample {
    public static void main(String[] args) {
        // Create object using default constructor
        Student s1 = new Student();
        s1.show();
    }
}
