import java.util.Scanner;

interface Run {
    String GetName();
    double GetCurrentSpeed();
    int GetWeight();
    int GetPassengers();
    int GetWheels();
}
abstract class Machine implements Run{
    final String name;
    protected double Speed;
    final static double MAX_SPEED = 300;
    final static double MIN_SPEED = 1;
    public static int MIN_PASSAMOUNT = 0;
    public static int MAX_PASSAMOUNT = 4;
    Scanner s = new Scanner(System.in);

    Machine() {
        System.out.print("\n Введіть назву машини: ");
        while(!s.hasNextLine())
        {
            System.out.print("Введіть коректне значення: ");
            s.next();
        }
        this.name = s.nextLine();

        System.out.print("\n Введіть швидкість машини: ");
        while(!s.hasNextDouble())
        {
            System.out.print("Введіть коректне значення: ");
            s.next();
        }
        double speed = s.nextDouble();

        if (speed <= MAX_SPEED && speed >= MIN_SPEED){
            this.Speed = speed;
        } else {
            this.Speed = 0;
        }
    }
    public String GetName() {
        return this.name;
    }
}
class Auto extends Machine {
    int weight;
    int passengers;
    int wheels;

    Auto(){
        super();
        System.out.print("\n Введіть вагу машини: ");
        while(!s.hasNextInt())
        {
            System.out.print("Введіть коректне значення: ");
            s.next();
        }
        this.weight = s.nextInt();

        System.out.print("\n Введіть кількість пасажирів: ");
        while(!s.hasNextInt())
        {
            System.out.print("Введіть коректне значення: ");
            s.next();
        }
        int Passengers = s.nextInt();
        if (Passengers >= MIN_PASSAMOUNT && Passengers<=MAX_PASSAMOUNT){
            this.passengers = Passengers;
        } else {
            this.passengers = 0;
        }

        System.out.print("\n Введіть кількість коліс машини: ");
        while(!s.hasNextInt())
        {
            System.out.print("Введіть коректне значення: ");
            s.next();
        }
        this.wheels = s.nextInt();
    }

    public double GetCurrentSpeed(){
        return this.Speed;
    }
    public int GetWeight(){
        return this.weight;
    }
    public int GetPassengers(){
        return this.passengers;
    }
    public int GetWheels(){
        return this.wheels;
    }
    void Information() {
        System.out.println("ІМ'Я: " + name + "  ШВИДКІСТЬ: " + Speed + "  ВАГА: " + weight +
                "  КІЛЬКІСТЬ ПАСАЖИРІВ: " + passengers  + "  КІЛЬКІСТЬ КОЛІС: " + wheels);
    }
}

public class Main {
    public static void main(String[] args) {
        Auto a = null;
        Scanner in = new Scanner(System.in);
        int choice = 0;
        while (choice!=12) {
            System.out.println("\n 1. Створити об'єкт");
            System.out.println(" 2. Вивести дані про об'єкт");
            System.out.println(" 3. Вивести ім'я об'єкту");
            System.out.println(" 4. Вивести швидкість об'єкту");
            System.out.println(" 5. Вивести вагу об'єкту");
            System.out.println(" 6. Вивести кількість пасажирів об'єкту");
            System.out.println(" 7. Вивести кількість коліс об'єкту");
            System.out.println(" 0. Вийти");
            System.out.println("Виберіть завдання:");
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    a = new Auto();
                    break;
                case 2:
                    if (a!=null)
                        a.Information();
                    else
                        System.out.println("Об'єкт ще не створено");
                    break;
                case 3:
                    if (a!=null)
                        System.out.println("ІМ'Я: " + a.GetName());
                    else
                        System.out.println("Об'єкт ще не створено");
                    break;
                case 4:
                    if (a!=null)
                        System.out.println("ШВИДКІСТЬ: " + a.GetCurrentSpeed());
                    else
                        System.out.println("Об'єкт ще не створено");
                    break;
                case 5:
                    if (a!=null)
                        System.out.println("ВАГА: " + a.GetWeight());
                    else
                        System.out.println("Об'єкт ще не створено");
                    break;
                case 6:
                    if (a!=null)
                        System.out.println("КІЛЬКІСТЬ ПАСАЖИРІВ: " + a.GetPassengers());
                    else
                        System.out.println("Об'єкт ще не створено");
                    break;
                case 7:
                    if (a!=null)
                        System.out.println("КІЛЬКІСТЬ КОЛІС: " + a.GetWheels());
                    else
                        System.out.println("Об'єкт ще не створено");
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Некоректний ввід");
            }
        }
    }
}