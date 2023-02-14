import java.util.Scanner;
import java.util.Random;
public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random random = new Random();
            int arr[] = new int[16];
            int arr2[] = new int[8];
        for (int i = 0; i < 16; i++) {
            arr[i] = random.nextInt(25);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
            int min = Integer.MAX_VALUE;
        for (int i = 0; i < 16 / 2; i++) {
            arr2[i] = arr[i] * arr[8 + i];
            if (arr2[i] < min)
                min = arr2[i];
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
        System.out.println("Min value: " + min);
    }
}
