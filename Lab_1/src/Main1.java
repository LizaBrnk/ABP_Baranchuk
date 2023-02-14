import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
            double x, y, result;
        System.out.println("Enter X and Y : ");
            x = in.nextDouble();
            y = in.nextDouble();
            result = (Math.abs(Math.sin(x) - y) + 2 * x) / Math.sqrt(1 + Math.abs(x * y));
        System.out.println("Result: " + result);
    }
}