public class GarbageCollectionExample {

    // Called by Garbage Collector before object is destroyed
    protected void finalize() {
        System.out.println("Object is garbage collected");
    }

    public static void main(String[] args) {
        // Create object
        GarbageCollectionExample obj = new GarbageCollectionExample();

        // Make object eligible for garbage collection
        obj = null;

        // Request JVM to run Garbage Collector
        System.gc();
    }
}

// Output: Object is garbage collected