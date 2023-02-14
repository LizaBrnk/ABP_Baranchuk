import java.util.Scanner;
public class Main5 {
    public static double function(int x) {
        return x - Math.pow(x, 3) / 6 + Math.pow(x, 5) / 120;
    }
    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            System.out.println("f(" + i + ") = " + function(i));
        }
    }
}
