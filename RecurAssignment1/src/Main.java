public class Main {
    public static long fib(long n) {
        if (n == 0) return 0; if (n == 1) return 1; else return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        for (int i = 0; i <= 30;i++) {
            System.out.println( i + ": " + fib(i));
        }
    }
}