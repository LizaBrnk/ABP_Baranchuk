import java.util.Scanner;
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
            double eps, sum = 0, result;
        System.out.print("Enter Epsilon: ");
            eps = in.nextDouble();
            result = eps;
        for (double i = 1; result >= eps; i++) {
            result = 1 / ((2 * i - 1) * (2 * i + 1));
            sum += result;
        }
        System.out.println("Sum = " + sum);
    }
}
