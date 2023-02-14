import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
            double a, b, c;
        System.out.print("Enter A, B and C: ");
            a = in.nextDouble();
            b = in.nextDouble();
            c = in.nextDouble();
        if (a > 1 && a < 3)
            System.out.println("A = " + a + " and is inside (1,3)");
        if (b > 1 && b < 3)
            System.out.println("B = " + b + " and is inside (1,3)");
        if (c > 1 && c < 3)
            System.out.println("C = " + c + " and is inside (1,3)");
    }
}
