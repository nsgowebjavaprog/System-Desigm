package DIP;

// DIPExample.java

// DIP: High-level modules should not depend on low-level modules; both should depend on abstractions.

// Abstraction for database operations
interface Database {
    void save(String data);
}

// Low-level module: MySQL implementation
class MySQLDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println("Saving '" + data + "' to MySQL database");
    }
}

// Low-level module: MongoDB implementation
class MongoDBDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println("Saving '" + data + "' to MongoDB database");
    }
}

// High-level module depends on abstraction, not concrete implementations
class UserService {
    private Database database;

    // Dependency Injection via constructor
    public UserService(Database database) {
        this.database = database;
    }

    public void saveUser(String userName) {
        database.save(userName);
    }
}

public class DIPExample {
    public static void main(String[] args) {
        System.out.println("--- DIP Demo ---");

        // Inject MySQL database implementation
        Database mySQL = new MySQLDatabase();
        UserService userServiceMySQL = new UserService(mySQL);
        userServiceMySQL.saveUser("Alice");

        // Inject MongoDB database implementation
        Database mongoDB = new MongoDBDatabase();
        UserService userServiceMongo = new UserService(mongoDB);
        userServiceMongo.saveUser("Bob");
    }
}