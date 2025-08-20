// SingletonExamples.java
public class SingletonExamples {

    // 1. Eager Initialization
    static class EagerSingleton {
        private static final EagerSingleton instance = new EagerSingleton();

        private EagerSingleton() {
        }

        public static EagerSingleton getInstance() {
            return instance;
        }
    }

    // 2. Lazy Initialization (Not Thread-Safe)
    static class LazySingleton {
        private static LazySingleton instance;

        private LazySingleton() {
        }

        public static LazySingleton getInstance() {
            if (instance == null) {
                instance = new LazySingleton();
            }
            return instance;
        }
    }

    // 3. Thread-Safe with synchronized
    static class ThreadSafeSingleton {
        private static ThreadSafeSingleton instance;

        private ThreadSafeSingleton() {
        }

        public static synchronized ThreadSafeSingleton getInstance() {
            if (instance == null) {
                instance = new ThreadSafeSingleton();
            }
            return instance;
        }
    }

    // 4. Double-Checked Locking
    static class DCLSingleton {
        private static volatile DCLSingleton instance;

        private DCLSingleton() {
        }

        public static DCLSingleton getInstance() {
            if (instance == null) {
                synchronized (DCLSingleton.class) {
                    if (instance == null) {
                        instance = new DCLSingleton();
                    }
                }
            }
            return instance;
        }
    }

    // 5. Bill Pugh Singleton
    static class BillPughSingleton {
        private BillPughSingleton() {
        }

        private static class Holder {
            private static final BillPughSingleton INSTANCE = new BillPughSingleton();
        }

        public static BillPughSingleton getInstance() {
            return Holder.INSTANCE;
        }
    }

    // 6. Enum Singleton
    enum EnumSingleton {
        INSTANCE;

        public void doSomething() {
            System.out.println("Singleton using Enum!");
        }
    }

    // Test main
    public static void main(String[] args) {
        System.out.println("Eager: " + EagerSingleton.getInstance());
        System.out.println("Lazy: " + LazySingleton.getInstance());
        System.out.println("Thread-Safe: " + ThreadSafeSingleton.getInstance());
        System.out.println("DCL: " + DCLSingleton.getInstance());
        System.out.println("Bill Pugh: " + BillPughSingleton.getInstance());
        EnumSingleton.INSTANCE.doSomething();
    }
}
