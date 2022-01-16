import java.util.ArrayList;
import java.util.List;

public class Vehicle {

    static List<Car> cars = new ArrayList<>();
    static List<Bike> bikes = new ArrayList<>();

    public static void addVehicle(int ind) {
        System.out.print("\033[H\033[2J");
        System.out.println("    -> Enter 1 to add Bike");
        System.out.println("    -> Enter 2 to add Car");
        System.out.println("    -> Enter 3 to Exit");
        String choice = Main.sc.nextLine();
        switch (choice) {
            case "1":
                addBike(ind);
                break;
            case "2":
                // addCar(ind);
                break;
            case "3":
                Admin.adminPage(ind);
                break;
            default:
                System.out.println("Invalid Choice\nEnter Correct Option");
                System.out.println("Press any key to continue......");
                Main.sc.nextLine();
                addVehicle(ind);
        }
    }

    private static void addBike(int ind) {
        System.out.print("\033[H\033[2J");
        System.out.print("Enter Bike Name or  0 to Exit");
        String bikeName = Main.sc.nextLine();
        if(bikeName.equals("0")){
            Admin.adminPage(ind);
        }
        System.out.print("Enter Number Plate String : ");
        String numberPlate = Main.sc.nextLine();
        System.out.print("Enter number of Bikes : ");
        int totCount = Integer.parseInt(Main.sc.nextLine());
        bikes.add(new Bike(bikeName, numberPlate, totCount, Main.admins.get(ind)));
        System.out.println("Bike added SucessFully");
        System.out.println("Press any key to continue......");
        Main.sc.nextLine();
        Admin.adminPage(ind);
    }

}
