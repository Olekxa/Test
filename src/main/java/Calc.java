public class Calc {
    public static int add(int x, int y) {
        return x + y;
    }

    public static int minus(int x, int y) {
        return x - y;
    }

    public static int multiply(int x, int y) {
        return x * y;
    }

    public static int divide(int x, int y) {
        if (y == 0) {
            throw new ArithmeticException("/ by zero");
        }
        return x / y;
    }
}
