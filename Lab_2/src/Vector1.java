import java.util.Scanner;
public class Vector1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
            int choice = 0;
            Vector v1 = new Vector();
            Vector v2 = new Vector();

        System.out.print("Input x, y and z coordinates for Vector 1: ");
            v1.X = in.nextDouble();
            v1.Y = in.nextDouble();
            v1.Z = in.nextDouble();

        System.out.print("Input x, y and z coordinates for Vector 2: ");
            v2.X = in.nextDouble();
            v2.Y = in.nextDouble();
            v2.Z = in.nextDouble();

        System.out.println("V1: " + v1.X + ", " + v1.Y + ", " + v1.Z);
        System.out.println("V2: " + v2.X + ", " + v2.Y + ", " + v2.Z);

        while (true) {
            System.out.println("Choose the number:" +
                    "\n1 - Module\n2 - Sum\n3 - Scalar product\n4 - Vector product\n5 - Multiply vector\n6 - To close the window");
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("V1 module: " + v1.GetModule());
                    System.out.println("V2 module: " + v2.GetModule());
                    break;
                case 2:
                    Vector sum = v1.Sum(v2);
                    System.out.println("Sum of v1 and v2: " + sum.X + ", " + sum.Y + ", " + sum.Z);
                    break;
                case 3:
                    System.out.println("Scalar product: " + v1.ScalarProduct(v2));
                    break;
                case 4:
                    Vector v3 = v1.VectorProduct(v2);
                    System.out.println("Vector product: " + v3.X + ", " + v3.Y + ", " + v3.Z);
                    break;
                case 5:
                    System.out.print("Input number to multiply vector: ");
                    double num = in.nextDouble();
                    Vector mv1 = v1.MultiplyByNumber(num);
                    Vector mv2 = v2.MultiplyByNumber(num);
                    System.out.println("V1: " + mv1.X + ", " + mv1.Y + ", " + mv1.Z);
                    System.out.println("V2: " + mv2.X + ", " + mv2.Y + ", " + mv2.Z);
                    break;
                case 6:
                    System. exit(0);
            }
        }
    }
}

class Vector {
    double X;
    double Y;
    double Z;

    Vector() {
        X = 0;
        Y = 0;
        Z = 0;
    }

    Vector(double x, double y, double z) {
        X = x;
        Y = y;
        Z = z;
    }

    public double GetModule() {
        return Math.pow(X * X + Y * Y + Z * Z, 0.5);
    }

    Vector Sum(Vector v) {
        return new Vector(X + v.X, Y + v.Y, Z + v.Z);
    }

    double ScalarProduct(Vector v) {
        return X * v.X + Y * v.Y + Z * v.Z;
    }

    Vector VectorProduct(Vector v) {
        return new Vector(Y * v.Z - Z * v.Y, Z * v.X - X * v.Z, X * v.Y - Y * v.X);
    }

    Vector MultiplyByNumber(double a) {
        return new Vector(X * a, Y * a, Z * a);
    }
}