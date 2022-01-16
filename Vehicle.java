import java.util.ArrayList;
import java.util.TreeMap;

public class Vehicle {

    static TreeMap<String, ArrayList<Car>> cars = new TreeMap<>();
    static TreeMap<String, ArrayList<Bike>> bikes = new TreeMap<>();

    static{
        ArrayList<Car> x= new ArrayList<>();
        x.add(new Car("carName", "numberPlate", 4, Main.admins.get(0), 3000));
        x.add(new Car("carName1", "numberPlate2", 4, Main.admins.get(0), 3000));
        cars.put("i10",x);
        ArrayList<Bike> y = new ArrayList<>();
        y.add(new Bike("bikeName", "numberPlate", Main.admins.get(0), 500));
        y.add(new Bike("bikeName1", "numberPlate1", Main.admins.get(0), 500));
        bikes.put("sp125",y);
    }

    public static void addVehicle(int ind) {
        System.out.print("\033[H\033[2J");
        System.out.println("------Add Vehicle by Category------");
        System.out.println("    -> Enter 1 to add Bike");
        System.out.println("    -> Enter 2 to add Car");
        System.out.println("    -> Enter 3 to Exit");
        System.out.print("Enter Choice : ");
        String choice = Main.sc.nextLine();
        switch (choice) {
            case "1":
                addBike(ind);
                break;
            case "2":
                addCar(ind);
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
        System.out.println("-----Add Bike to Application-----");
        System.out.print("Enter Bike Name or  0 to Exit : ");
        String bikeName = Main.sc.nextLine();
        if (bikeName.equals("0")) {
            Admin.adminPage(ind);
        }
        System.out.print("Enter Number Plate String : ");
        String numberPlate = Main.sc.nextLine();
        if (bikes.containsKey(bikeName)) {
            ArrayList<Bike> tp = bikes.get(bikeName);
            tp.add(new Bike(bikeName, numberPlate, Main.admins.get(ind),
                    bikes.get(bikeName).get(0).rentPerDay));
            bikes.put(bikeName, tp);
        } else {
            System.out.print("Enter Rent per Day : ");
            int rentPerDay = Integer.parseInt(Main.sc.nextLine());
            ArrayList<Bike> tp = new ArrayList<>();
            tp.add(new Bike(bikeName, numberPlate, Main.admins.get(ind), rentPerDay));
            bikes.put(bikeName, tp);
        }
        System.out.println("Bike added SucessFully");
        System.out.println("Enter 'y' if You want to add one more Bike else any key to Exit");
        String a = Main.sc.nextLine();
        if (a.equalsIgnoreCase("y")) {
            addBike(ind);
        }
        Admin.adminPage(ind);
    }

    private static void addCar(int ind) {
        System.out.print("\033[H\033[2J");
        System.out.println("-----Add Car to Application------");
        System.out.print("Enter Car Name or  0 to Exit : ");
        String carName = Main.sc.nextLine();
        if (carName.equals("0")) {
            Admin.adminPage(ind);
        }
        System.out.print("Enter Number Plate String : ");
        String numberPlate = Main.sc.nextLine();
        if (cars.containsKey(carName)) {
            ArrayList<Car> tp = cars.get(carName);
            tp.add(new Car(carName, numberPlate, tp.get(0).seats, Main.admins.get(ind),
                    cars.get(carName).get(0).rentPerDay));
            cars.put(carName, tp);
        } else {
            System.out.print("Enter Number of Seats in Car : ");
            int seats = Integer.parseInt(Main.sc.nextLine());
            System.out.print("Enter Rent per Day : ");
            int rentPerDay = Integer.parseInt(Main.sc.nextLine());
            ArrayList<Car> tp = new ArrayList<>();
            tp.add(new Car(carName, numberPlate, seats, Main.admins.get(ind), rentPerDay));
            cars.put(carName, tp);

        }
        System.out.println("Car added SucessFully");
        System.out.print("Enter 'y' if You want to add one more Car else any key to Exit : ");
        String a = Main.sc.nextLine();
        if (a.equalsIgnoreCase("y")) {
            addCar(ind);
        }
        Admin.adminPage(ind);
    }

    public static void searchVehicle() {
        System.out.print("\033[H\033[2J");
        System.out.println("------Search By Category-----");
        System.out.println("    -> Enter 1 for Searching Bikes");
        System.out.println("    -> Enter 2 for Searching Cars");
        System.out.println("    -> Enter 3 to Exit");
        System.out.print("Enter Choice : ");
        String choice = Main.sc.nextLine();
        if (choice.equals("1")) {
            searchBike();
        } else if (choice.equals("2")) {
            // searchCar();
        } else if (choice.equals("3")) {
            return;
        } else {
            System.out.println("Invalid Choice\nEnter Correct Option");
            System.out.println("Press any key to continue......");
            Main.sc.nextLine();
            searchVehicle();
        }
    }

    private static void searchBike() {
        System.out.print("\033[H\033[2J");
        System.out.println("-----Search in Bike-----");
        System.out.println("    -> Enter 1 to search by Name");
        System.out.println("    -> Enter 2 to search by Number Plate");
        System.out.println("    -> Enter 3 to Exit");
        System.out.print("Enter Choice : ");
        String s = Main.sc.nextLine();
        if (s.equals("1")) {
            searchBikeByName();
        } else if (s.equals("2")) {
            // searchBikebyNumber();
        } else if (s.equals("3")) {
            return;
        } else {
            System.out.println("Invalid Choice\nEnter Correct Option");
            System.out.println("Press any key to continue......");
            Main.sc.nextLine();
            searchBike();
        }
    }

    private static void searchBikeByName() {
        System.out.print("\033[H\033[2J");
        System.out.println("-----Search Bike by Name-----");
        System.out.print("Enter Bike Name : ");
        String bikeName = Main.sc.nextLine();
        int count=0;
        if (bikes.containsKey(bikeName)) {
            System.out.println("------Details of Bike------");
            System.out.println();
            System.out.println("Total Bikes in Garage => " + bikes.get(bikeName).size());
            System.out.println("Rent Per Day => "+bikes.get(bikeName).get(0).rentPerDay);
            System.out.println();
            for (int i = 0; i < bikes.get(bikeName).size(); i++,System.out.println()) {
                if(bikes.get(bikeName).get(i).isAvailable)count++;
                System.out.println("Bike " + (i + 1) + " : ");
                System.out.println("Name of the Bike => " + bikes.get(bikeName).get(i).bikeName);
                System.out.println("Number Plate String of the Bike => " + bikes.get(bikeName).get(i).numberPlate);
                System.out.println("Total Kms Travelled => " + bikes.get(bikeName).get(i).totKms);
            }
        } else {
            System.out.println("Bike with Name => " + bikeName + " not found !");
        }
        if(count>0)
        System.out.println("Bikes Available at Present => "+count);
        System.out.println("Press any key to continue......");
        Main.sc.nextLine();
    }

}
