package ISP;

// ISPExample.java

// ISP: Clients should not be forced to depend on interfaces they do not use.
// Split large interfaces into smaller, client-specific interfaces.

// Small interface for work
interface Workable {
    void work();
}

// Small interface for eating
interface Eatable {
    void eat();
}

// HumanWorker needs both work and eat abilities
class HumanWorker implements Workable, Eatable {
    @Override
    public void work() {
        System.out.println("Human working...");
    }

    @Override
    public void eat() {
        System.out.println("Human eating...");
    }
}

// RobotWorker only needs to work, does NOT need to eat
class RobotWorker implements Workable {
    @Override
    public void work() {
        System.out.println("Robot working...");
    }
}

public class ISPExample {
    public static void main(String[] args) {
        HumanWorker human = new HumanWorker();
        RobotWorker robot = new RobotWorker();

        System.out.println("--- ISP Demo ---");
        human.work();
        human.eat();

        robot.work();
        // robot.eat(); // Not allowed, robot does not implement Eatable
    }
}