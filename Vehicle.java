import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class Vehicle {

    static TreeMap<String, ArrayList<Car>> cars = new TreeMap<>();
    static TreeMap<String, ArrayList<Bike>> bikes = new TreeMap<>();

    static {
        ArrayList<Car> w = new ArrayList<>();
        w.add(new Car("i20", "numberPlate", 4, Main.admins.get(0), 3000, 100000));
        w.add(new Car("i20", "numberPlate1", 4, Main.admins.get(0), 3000, 100000));
        w.add(new Car("i20", "numberPlate2", 4, Main.admins.get(0), 3000, 100000));
        cars.put("i20", w);
        ArrayList<Car> x = new ArrayList<>();
        x.add(new Car("i10", "numberPlate", 4, Main.admins.get(0), 3000, 100000));
        x.add(new Car("i10", "numberPlate2", 4, Main.admins.get(0), 3000, 100000));
        x.add(new Car("i10", "numberPlate2", 4, Main.admins.get(0), 3000, 100000));
        x.add(new Car("i10", "numberPlate2", 4, Main.admins.get(0), 3000, 100000));
        cars.put("i10", x);
        ArrayList<Bike> y = new ArrayList<>();
        y.add(new Bike("apache", "numberPlate", Main.admins.get(0), 500, 500000));
        y.add(new Bike("apache", "numberPlate1", Main.admins.get(0), 500, 500000));
        y.add(new Bike("apache", "numberPlate2", Main.admins.get(0), 500, 500000));
        y.add(new Bike("apache", "numberPlate3", Main.admins.get(0), 500, 500000));
        bikes.put("apache", y);
        ArrayList<Bike> z = new ArrayList<>();
        z.add(new Bike("sp125", "numberPlate", Main.admins.get(0), 500, 500000));
        z.add(new Bike("sp125", "numberPlate1", Main.admins.get(0), 500, 500000));
        z.add(new Bike("sp125", "numberPlate2", Main.admins.get(0), 500, 500000));
        bikes.put("sp125", z);
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
                    bikes.get(bikeName).get(0).rentPerDay, bikes.get(bikeName).get(0).priceOfBike));
            bikes.put(bikeName, tp);
        } else {
            System.out.print("Enter Price of Bike : ");
            int priceOfBike = Integer.parseInt(Main.sc.nextLine());
            System.out.print("Enter Rent per Day : ");
            int rentPerDay = Integer.parseInt(Main.sc.nextLine());
            ArrayList<Bike> tp = new ArrayList<>();
            tp.add(new Bike(bikeName, numberPlate, Main.admins.get(ind), rentPerDay, priceOfBike));
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
                    cars.get(carName).get(0).rentPerDay, cars.get(carName).get(0).priceOfCar));
            cars.put(carName, tp);
        } else {
            System.out.print("Enter Number of Seats in Car : ");
            int seats = Integer.parseInt(Main.sc.nextLine());
            System.out.print("Enter Price of Car : ");
            int priceOfCar = Integer.parseInt(Main.sc.nextLine());
            System.out.print("Enter Rent per Day : ");
            int rentPerDay = Integer.parseInt(Main.sc.nextLine());
            ArrayList<Car> tp = new ArrayList<>();
            tp.add(new Car(carName, numberPlate, seats, Main.admins.get(ind), rentPerDay, priceOfCar));
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
            searchCar();
        } else if (choice.equals("3")) {
            return;
        } else {
            System.out.println("Invalid Choice\nEnter Correct Option");
            System.out.println("Press any key to continue......");
            Main.sc.nextLine();
            searchVehicle();
        }
    }

    private static void searchCar() {
        System.out.print("\033[H\033[2J");
        System.out.println("-----Search in Car-----");
        System.out.println("    -> Enter 1 to search by Name");
        System.out.println("    -> Enter 2 to search by Number Plate");
        System.out.println("    -> Enter 3 to Exit");
        System.out.print("Enter Choice : ");
        String s = Main.sc.nextLine();
        if (s.equals("1")) {
            searchcarByName();
            searchCar();
        } else if (s.equals("2")) {
            searchCarByNumber();
            searchCar();
        } else if (s.equals("3")) {
            return;
        } else {
            System.out.println("Invalid Choice\nEnter Correct Option");
            System.out.println("Press any key to continue......");
            Main.sc.nextLine();
            searchCar();
        }
    }

    private static void searchCarByNumber() {
        System.out.print("\033[H\033[2J");
        System.out.println("-----Search Car by Number-----");
        System.out.print("Enter Car Number or 0 to Exit : ");
        String numberPlate = Main.sc.nextLine();
        if (numberPlate.equals("0")) {
            return;
        }
        Car curr = null;
        Set<String> tp = cars.keySet();
        for (String i : tp) {
            for (int j = 0; j < cars.get(i).size(); j++) {
                if (cars.get(i).get(j).numberPlate.equals(numberPlate)) {
                    curr = cars.get(i).get(j);
                    break;
                }
            }
        }
        System.out.println();
        if (curr == null) {
            System.out.println("Car with Number => " + numberPlate + " not found !");
        } else {
            System.out.println("Name of the Car => " + curr.carName);
            System.out.println("Number Plate String of the Car => " + curr.numberPlate);
            System.out.println("Total Kms Travelled => " + curr.totKms);
            System.out.println("No. of Times Borrowed => " + curr.borrowedCount);
            System.out.println("Rent Per Day => " + curr.rentPerDay);
            System.out.println("Currently Available for Ride => " + (curr.isAvailable ? "Yes" : "No"));
        }
        System.out.println();
        System.out.println("Press any key to continue......");
        Main.sc.nextLine();
        return;
    }

    private static void searchcarByName() {
        System.out.print("\033[H\033[2J");
        System.out.println("-----Search Car by Name-----");
        System.out.print("Enter Car Name or 0 to Exit : ");
        String carName = Main.sc.nextLine();
        if (carName.equals("0")) {
            return;
        }
        int count = 0;
        if (cars.containsKey(carName)) {
            System.out.println("------Details of Car------");
            System.out.println();
            System.out.println("Total Cars in Garage => " + cars.get(carName).size());
            System.out.println("Rent Per Day => " + cars.get(carName).get(0).rentPerDay);
            System.out.println();
            for (int i = 0; i < cars.get(carName).size(); i++, System.out.println()) {
                if (cars.get(carName).get(i).isAvailable)
                    count++;
                System.out.println("Car " + (i + 1) + " : ");
                System.out.println("Name of the Car => " + cars.get(carName).get(i).carName);
                System.out.println("Number Plate String of the Car => " + cars.get(carName).get(i).numberPlate);
                System.out.println("Total Kms Travelled => " + cars.get(carName).get(i).totKms);
                System.out.println("No. of TImes Borrowed => " + cars.get(carName).get(i).borrowedCount);
                System.out.println(
                        "Currently Available for Ride => " + (cars.get(carName).get(i).isAvailable ? "Yes" : "No"));
            }
        } else {
            System.out.println("Car with Name => " + carName + " not found !");
        }
        if (count > 0)
            System.out.println("Cars Available at Present => " + count);
        System.out.println("Press any key to continue......");
        Main.sc.nextLine();
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
            searchBike();
        } else if (s.equals("2")) {
            searchBikebyNumber();
            searchBike();
        } else if (s.equals("3")) {
            return;
        } else {
            System.out.println("Invalid Choice\nEnter Correct Option");
            System.out.println("Press any key to continue......");
            Main.sc.nextLine();
            searchBike();
        }
    }

    private static void searchBikebyNumber() {
        System.out.print("\033[H\033[2J");
        System.out.println("-----Search Bike by Number-----");
        System.out.print("Enter Bike Number or 0 to Exit : ");
        String numberPlate = Main.sc.nextLine();
        if (numberPlate.equals("0")) {
            return;
        }
        Bike curr = null;
        Set<String> tp = bikes.keySet();
        for (String i : tp) {
            for (int j = 0; j < bikes.get(i).size(); j++) {
                if (bikes.get(i).get(j).numberPlate.equals(numberPlate)) {
                    curr = bikes.get(i).get(j);
                    break;
                }
            }
        }
        System.out.println();
        if (curr == null) {
            System.out.println("Bike with Number => " + numberPlate + " not found !");
        } else {
            System.out.println("Name of the Bike => " + curr.bikeName);
            System.out.println("Number Plate String of the Bike => " + curr.numberPlate);
            System.out.println("Total Kms Travelled => " + curr.totKms);
            System.out.println("No. of Times Borrowed => " + curr.borrowedCount);
            System.out.println("Rent Per Day => " + curr.rentPerDay);
            System.out.println("Currently Available for Ride => " + ((curr.isAvailable ? "Yes" : "No")));
        }
        System.out.println();
        System.out.println("Press any key to continue......");
        Main.sc.nextLine();
        return;
    }

    private static void searchBikeByName() {
        System.out.print("\033[H\033[2J");
        System.out.println("-----Search Bike by Name-----");
        System.out.print("Enter Bike Name or 0 to Exit : ");
        String bikeName = Main.sc.nextLine();
        if (bikeName.equals("0")) {
            return;
        }
        int count = 0;
        if (bikes.containsKey(bikeName)) {
            System.out.println("------Details of Bike------");
            System.out.println();
            System.out.println("Total Bikes in Garage => " + bikes.get(bikeName).size());
            System.out.println("Rent Per Day => " + bikes.get(bikeName).get(0).rentPerDay);
            System.out.println();
            for (int i = 0; i < bikes.get(bikeName).size(); i++, System.out.println()) {
                if (bikes.get(bikeName).get(i).isAvailable)
                    count++;
                System.out.println("Bike " + (i + 1) + " : ");
                System.out.println("Name of the Bike => " + bikes.get(bikeName).get(i).bikeName);
                System.out.println("Number Plate String of the Bike => " + bikes.get(bikeName).get(i).numberPlate);
                System.out.println("Total Kms Travelled => " + bikes.get(bikeName).get(i).totKms);
                System.out.println("No. of TImes Borrowed => " + bikes.get(bikeName).get(i).borrowedCount);
                System.out.println(
                        "Currently Available for Ride => " + (bikes.get(bikeName).get(i).isAvailable ? "Yes" : "No"));
            }
        } else {
            System.out.println("Bike with Name => " + bikeName + " not found !");
        }
        if (count > 0)
            System.out.println("Bikes Available at Present => " + count);
        System.out.println("Press any key to continue......");
        Main.sc.nextLine();
    }

    public static void modify() {
        System.out.print("\033[H\033[2J");
        System.out.println("    -> Enter 1 for Bike detail Modification");
        System.out.println("    -> Enter 2 for Car detail Modification");
        System.out.println("    -> Enter 3 to Exit");
        System.out.print("Enter Choice : ");
        String s = Main.sc.nextLine();
        if (s.equals("1")) {
            modifyBikeRate();
            modify();
        } else if (s.equals("2")) {
            modifyCarRate();
            modify();
        } else if (s.equals("3")) {
            return;
        } else {
            System.out.println("Invalid Choice\nEnter Correct Option");
            System.out.println("Press any key to continue......");
            Main.sc.nextLine();
            modify();
        }
    }

    private static void modifyCarRate() {
        System.out.print("\033[H\033[2J");
        System.out.println("-----Search Car's Rent Per Day-----");
        System.out.print("Enter Car Name or 0 to Exit : ");
        String carName = Main.sc.nextLine();
        if (carName.equals("0")) {
            return;
        }
        if (cars.containsKey(carName)) {
            System.out.print("Enter New Rent : ");
            Integer newRentPerDay = Integer.parseInt(Main.sc.nextLine());
            for (int i = 0; i < cars.get(carName).size(); i++) {
                cars.get(carName).get(i).rentPerDay = newRentPerDay;
            }
        } else {
            System.out.println("Car with name " + carName + " not found !");
            System.out.println("Press any key to continue......");
            Main.sc.nextLine();
            modifyCarRate();
        }
        System.out.println("Car Rent has been Modified Successfully");
        System.out.println("Press any key to continue......");
        Main.sc.nextLine();
        return;
    }

    private static void modifyBikeRate() {
        System.out.print("\033[H\033[2J");
        System.out.println("-----Search Bike's Rent Per Day-----");
        System.out.print("Enter Bike Name or 0 to Exit : ");
        String bikeName = Main.sc.nextLine();
        if (bikeName.equals("0")) {
            return;
        }
        if (bikes.containsKey(bikeName)) {
            System.out.print("Enter New Rent : ");
            Integer newRentPerDay = Integer.parseInt(Main.sc.nextLine());
            for (int i = 0; i < bikes.get(bikeName).size(); i++) {
                bikes.get(bikeName).get(i).rentPerDay = newRentPerDay;
            }
        } else {
            System.out.println("Bike with name " + bikeName + " not found !");
            System.out.println("Press any key to continue......");
            Main.sc.nextLine();
            modifyBikeRate();
        }
        System.out.println("Bike Rent has been Modified Successfully");
        System.out.println("Press any key to continue......");
        Main.sc.nextLine();
        return;
    }

    public static void viewBikes() {
        System.out.print("\033[H\033[2J");
        System.out.println("-----View List of Bikes-----");
        System.out.println("Enter 1 to view sorted by Name");
        System.out.println("Enter 2 to view sorted by count of vehicles");
        System.out.println("Enter 3 to Exit");
        System.out.print("Enter Choice : ");
        String s = Main.sc.nextLine();
        if (s.equals("1")) {
            sortByName(bikes);
            viewBikes();
        } else if (s.equals("2")) {
            sortByCount(bikes);
            viewBikes();
        } else if (s.equals("3")) {
            return;
        } else {
            System.out.println("Invalid Choice\nEnter Correct Option");
            System.out.println("Press any key to continue......");
            Main.sc.nextLine();
            viewBikes();
        }
    }

    private static void sortByCount(TreeMap<String, ArrayList<Bike>> bikes2) {
        List<String> keys = new ArrayList<String>(bikes2.keySet());
        Collections.sort(keys, new CountSorter());
        display(keys);
    }

    private static <TreeSet> void sortByName(TreeMap<String, ArrayList<Bike>> bikes2) {
        List<String> keys = new ArrayList<String>(bikes2.keySet());
        Collections.sort(keys, new NameSorter());
        display(keys);
    }

    private static void display(List<String> keys) {
        System.out.print("\033[H\033[2J");
        System.out.println("-------Bike Details--------");
        for (String i : keys) {
            System.out.println("Name of the Bike => " + i);
            System.out.println("Total Bikes in Garage => " + bikes.get(i).size());
            System.out.println("Rent Per Day => " + bikes.get(i).get(0).rentPerDay);
            System.out.println("==================================================================");
            for (int j = 0; j < bikes.get(i).size(); j++, System.out.println()) {
                System.out.println("Number Plate String of the Bike => " + bikes.get(i).get(j).numberPlate);
                System.out.println("Total Kms Travelled => " + bikes.get(i).get(j).totKms);
                System.out.println("No. of TImes Borrowed => " + bikes.get(i).get(j).borrowedCount);
                System.out
                        .println("Currently Available for Ride => " + (bikes.get(i).get(j).isAvailable ? "Yes" : "No"));
            }
            System.out.println("=x=x=x=x=x==xx=x=x=x=x=x=x=x=x=x=x=x=x=x=x=x=x=x=x=x=x=x=x=x=x=x=x==xx==");
            System.out.println();
        }
        System.out.println("Press any key to continue......");
        Main.sc.nextLine();
    }

    public static void viewCars() {
        System.out.print("\033[H\033[2J");
        System.out.println("-----View List of Cars-----");
        System.out.println("Enter 1 to view sorted by Name");
        System.out.println("Enter 2 to view sorted by count of vehicles");
        System.out.println("Enter 3 to Exit");
        System.out.print("Enter Choice : ");
        String s = Main.sc.nextLine();
        if (s.equals("1")) {
            sortCarByName(cars);
            viewCars();
        } else if (s.equals("2")) {
            sortCarByCount(cars);
            viewCars();
        } else if (s.equals("3")) {
            return;
        } else {
            System.out.println("Invalid Choice\nEnter Correct Option");
            System.out.println("Press any key to continue......");
            Main.sc.nextLine();
            viewBikes();
        }
    }

    private static void sortCarByName(TreeMap<String, ArrayList<Car>> cars2) {
        List<String> keys = new ArrayList<String>(cars2.keySet());
        Collections.sort(keys, new NameSorter());
        displayCars(keys);
    }

    private static void sortCarByCount(TreeMap<String, ArrayList<Car>> cars2) {
        List<String> keys = new ArrayList<String>(cars2.keySet());
        Collections.sort(keys, new CountSorter());
        displayCars(keys);
    }

    private static void displayCars(List<String> keys) {
        System.out.print("\033[H\033[2J");
        System.out.println("-------Car Details--------");
        for (String i : keys) {
            System.out.println("Name of the Car => " + i);
            System.out.println("Total Cars in Garage => " + cars.get(i).size());
            System.out.println("Rent Per Day => " + cars.get(i).get(0).rentPerDay);
            System.out.println("No. of Seats in car => " + cars.get(i).get(0).seats);
            System.out.println("==================================================================");
            for (int j = 0; j < cars.get(i).size(); j++, System.out.println()) {
                System.out.println("Number Plate String of the Car => " + cars.get(i).get(j).numberPlate);
                System.out.println("Total Kms Travelled => " + cars.get(i).get(j).totKms);
                System.out.println("No. of Times Borrowed => " + cars.get(i).get(j).borrowedCount);
                System.out
                        .println("Currently Available for Ride => " + (cars.get(i).get(j).isAvailable ? "Yes" : "No"));
            }
            System.out.println("=x=x=x=x=x==xx=x=x=x=x=x=x=x=x=x=x=x=x=x=x=x=x=x=x=x=x=x=x=x=x=x=x==xx==");
            System.out.println();
        }
        System.out.println("Press any key to continue......");
        Main.sc.nextLine();
    }

    public static void issue(int ind) {
        System.out.print("\033[H\033[2J");
        System.out.println("-----Issue Vehicle-----");
        System.out.print("Enter User's Email Id or 0 to Exit :");
        String email = Main.sc.nextLine();
        if (email.equals("0")) {
            return;
        }
        int user_index = User.findUserInd(email);
        if (user_index == -1) {
            System.out.println("User Not Found !");
            System.out.println("Press any key to continue......");
            Main.sc.nextLine();
            issue(ind);
        }
        issueVehicle(ind, user_index);
    }

    private static void issueVehicle(int ind, int user_index) {
        System.out.print("\033[H\033[2J");
        System.out.println("-----Issue Vehicle-----");
        System.out.println("Enter 1 for Bike");
        System.out.println("Enter 2 for Car");
        System.out.println("Enter 3 to Exit");
        String s = Main.sc.nextLine();
        switch (s) {
            case "1":
                issueBike(ind, user_index);
                issueVehicle(ind, user_index);
                break;
            case "2":
                // issueCar(ind,user_index);
                issueVehicle(ind, user_index);
                break;
            case "3":
                return;
            default:
                System.out.println("Invalid Choice\nEnter Correct Option");
                System.out.println("Press any key to continue......");
                Main.sc.nextLine();
                issueVehicle(ind, user_index);
        }
    }

    private static void issueBike(int ind, int user_index) {
        System.out.print("\033[H\033[2J");
        System.out.println("-----Issue Bike-----");
        if (Main.users.get(user_index).borrows.size() >= 2) {
            System.out.println("You can borrow two vechicles at a time (1 car + 1 Bike)");
            System.out.println("Press any key to continue......");
            Main.sc.nextLine();
            return;
        }
        if (Main.users.get(user_index).borrows.size() != 0) {
            if ((Main.users.get(user_index).borrows.get(0)) instanceof Bike) {
                System.out.println("You can rent at most 1 Bike at a time");
                System.out.println("Press any key to continue......");
                Main.sc.nextLine();
                return;
            }
        }
        System.out.print("Enter Bike Name or 0 to Exit : ");
        String bikeName = Main.sc.nextLine();
        if (bikeName.equals("0")) {
            return;
        }
        if (bikes.get(bikeName) != null) {
            for (int i = 0; i < bikes.get(bikeName).size(); i++) {
                if (bikes.get(bikeName).get(i).isAvailable && bikes.get(bikeName).get(i).isServiced) {
                    bikes.get(bikeName).get(i).isAvailable = false;
                    bikes.get(bikeName).get(i).tenure++;
                    bikes.get(bikeName).get(i).borrowedCount++;
                    Main.users.get(user_index).borrows.add(bikes.get(bikeName).get(i));
                    Main.transactions.add(new Transaction(bikes.get(bikeName).get(i), "Rented",
                            Main.users.get(user_index), LocalDate.now(), "nil", 0, Main.admins.get(ind)));
                    System.out.printf("Bike %s has been issued to %s Successfully\n", bikeName,
                            Main.users.get(user_index).name);
                    System.out.println("Press any key to continue......");
                    Main.sc.nextLine();
                    return;
                }
            }
            System.out.println("Bike " + bikeName + " not available Currently !\nFeel free to Borrow Other Bikes");
            System.out.println("Press any key to continue......");
            Main.sc.nextLine();
            issueBike(ind, user_index);
        } else {
            System.out.println("Bike " + bikeName + " not found !");
            System.out.println("Press any key to continue......");
            Main.sc.nextLine();
            issueBike(ind, user_index);
        }
    }

    public static void removeVehicle() {
        System.out.print("\033[H\033[2J");
        System.out.println("-----Remove a vehicle-----");
        System.out.println("Select Vehicle Type");
        System.out.println("Enter 1 for Bike");
        System.out.println("Enter 2 for Car");
        System.out.println("Enter 3 to Exit");
        System.out.print("Enter Choice : ");
        String s = Main.sc.nextLine();
        switch (s) {
            case "1":
                removeBike();
                removeVehicle();
                break;
            case "2":
                removeCar();
                removeVehicle();
                break;
            case "3":
                return;
            default:
                System.out.println("Invalid Choice\nEnter Correct Option");
                System.out.println("Press any key to continue......");
                Main.sc.nextLine();
                removeVehicle();
        }
    }

    private static void removeCar() {
        System.out.print("Enter Car Number or 0 to Exit : ");
        String numberPlate = Main.sc.nextLine();
        if (numberPlate.equals("0")) {
            return;
        }
        int carInd = -1;
        Set<String> tp = cars.keySet();
        String keyind = "";
        t: for (String i : tp) {
            keyind = i;
            for (int j = 0; j < cars.get(i).size(); j++) {
                if (cars.get(i).get(j).numberPlate.equals(numberPlate)) {
                    carInd = j;
                    break t;
                }
            }
        }
        if (carInd == -1) {
            System.out.println("Car with " + numberPlate + " not Found !");
            System.out.println("Press any key to continue......");
            Main.sc.nextLine();
            removeCar();
        }
        cars.get(keyind).remove(carInd);
        System.out.println("Car has been Removed Successfully");
        System.out.println("Press any key to continue......");
        Main.sc.nextLine();
    }

    private static void removeBike() {
        System.out.print("Enter Bike Number or 0 to Exit : ");
        String numberPlate = Main.sc.nextLine();
        if (numberPlate.equals("0")) {
            return;
        }
        int bikeInd = -1;
        Set<String> tp = bikes.keySet();
        String keyind = "";
        t: for (String i : tp) {
            keyind = i;
            for (int j = 0; j < bikes.get(i).size(); j++) {
                if (bikes.get(i).get(j).numberPlate.equals(numberPlate)) {
                    bikeInd = j;
                    break t;
                }
            }
        }
        if (bikeInd == -1) {
            System.out.println("Bike with " + numberPlate + " not Found !");
            System.out.println("Press any key to continue......");
            Main.sc.nextLine();
            removeBike();
        }
        bikes.get(keyind).remove(bikeInd);
        System.out.println("Bike has been Removed Successfully");
        System.out.println("Press any key to continue......");
        Main.sc.nextLine();
    }

    public static void returnVehicle(int ind) {
        System.out.print("\033[H\033[2J");
        System.out.print("Enter Customer's Email or 0 to exit : ");
        String email = Main.sc.nextLine();
        int user_index = User.findUserInd(email);
        if (user_index == -1) {
            System.out.println("User not Found !");
            System.out.println("Press any key to continue......");
            Main.sc.nextLine();
            returnVehicle(ind);
        }
        if (Main.users.get(user_index).borrows.isEmpty()) {
            System.out.println("You Haven't Borrowed any Vehicles yet !");
            System.out.println("Press any key to continue......");
            Main.sc.nextLine();
            return;
        }
        if (Main.users.get(user_index).borrows.size() == 1) {
            String x = Main.users.get(user_index).borrows.get(0).getClass().getName();
            if (Main.users.get(user_index).borrows.get(0) instanceof Bike) {
                Bike k = (Bike) Main.users.get(user_index).borrows.remove(0);
                
                Vehicle.bikes.get(k.bikeName).remove(k);
                Main.transactions.add(new Transaction(k, "Vehicle Lost", Main.users.get(user_index), LocalDate.now(),
                        "Cash", k.priceOfBike, Main.admins.get(ind)));
            } else {
                Car k = (Car) Main.users.get(user_index).borrows.remove(0);
                Vehicle.cars.get(k.carName).remove(k);
                Main.transactions.add(new Transaction(k, "Vehicle Lost", Main.users.get(user_index), LocalDate.now(),
                        "Cash", k.priceOfCar, Main.admins.get(ind)));
            }
            System.out.println(x + " has been returned successfully & amount is debited from the user's Wallet");
            System.out.println("Press any key to continue......");
            Main.sc.nextLine();
        }
        
    }

}
