public class PassByValueExample {
    void change(int num) {
        // Only local copy of num is changed
        num = num + 10;
    }

    public static void main(String[] args) {
        int a = 5;

        // Create object to call method
        PassByValueExample obj = new PassByValueExample();
        obj.change(a);

        // a remains unchanged
        System.out.println("Value after method call: " + a);
    }
}
