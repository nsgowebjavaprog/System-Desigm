class Employee {
    // Instance variables
    int id;
    String name;

    void display() {
        System.out.println(id + " : " + name);
    }
}

public class InstanceVariableExample {
    public static void main(String[] args) {
        // New object with different instance data
        Employee e1 = new Employee();
        e1.id = 56;
        e1.name = "NS";
        e1.display();
    }
}
