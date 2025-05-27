public class WrapperClassExample {
    public static void main(String[] args) {
        int num = 100;

        // Primitive to Object (Boxing)
        Integer obj = Integer.valueOf(num);

        // Object to Primitive (Unboxing)
        int val = obj.intValue();

        System.out.println("Wrapped: " + obj);
        System.out.println("Unwrapped: " + val);
    }
}
