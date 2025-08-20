// User entity: only responsible for user data management
class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// UserRepository: only responsible for persisting user data
class UserRepository {
    public void save(User user) {
        System.out.println("Saving user '" + user.getName() + "' to database");
    }
}

// Usage
public class SRPDemo {
    public static void main(String[] args) {
        User user = new User("Alice");
        UserRepository repo = new UserRepository();

        repo.save(user);

        user.setName("Bob");
        repo.save(user);
    }
}
