import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {
    String name;
    String email;
    String pass;
    String mobile;
    String Address;
    Integer wallet = 30000;
    List<Object> borrows = new ArrayList<>();

    public User(String name, String email, String pass, String mobile, String address) {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.mobile = mobile;
        Address = address;
    }

    public static void login() {
        System.out.print("\033[H\033[2J");
        System.out.println("-----Select User Type-----");
        System.out.println("Enter 1 for Sign Up");
        System.out.println("Enter 2 for Log in");
        System.out.println("Enter 3 to go back");
        System.out.print("Enter Choice : ");
        int n = Integer.parseInt(Main.sc.nextLine());

        if (n == 1) {
            userSignUp();
        }

        else if (n == 2) {
            userLogin();
        }

        else if (n == 3) {
            Main.homepage();
        }

        else {
            System.out.println("Incorrect choice !");
            System.out.println("Press any key to continue......");
            Main.sc.nextLine();
            login();
        }

    }

    static int findUserInd(String email) {
        for (int i = 0; i < Main.users.size(); i++) {
            if (Main.users.get(i).email.equals(email)) {
                return i;
            }
        }
        return -1;
    }

    static void userLogin() {
        System.out.print("\033[H\033[2J");
        System.out.println("-----Customer Login-----");
        System.out.print("Enter Email or 0 to exit : ");
        String email = Main.sc.nextLine();
        if (email.equals("0")) {
            login();
        }
        int user_index = findUserInd(email);
        if (user_index == -1) {
            System.out.println("User with Email ID =>  " + email + " not Found !");
            System.out.println("Press any key to continue......");
            Main.sc.nextLine();
            userLogin();
        }
        System.out.print("Enter Password or 0 to Forgot Password : ");
        String password = Main.sc.nextLine();
        if (password.equals("0")) {
            forgetPassword(user_index);
        }
        if (Main.users.get(user_index).pass.equals(password)) {
            userPage(user_index);
        } else {
            System.out.println("Incorrect password !\nTry Again");
            System.out.println("Press any key to continue......");
            Main.sc.nextLine();
            userLogin();
        }
    }

    private static void userPage(int user_index) {
        System.out.print("\033[H\033[2J");
        System.out.printf("----Welcome , %s -----\n", Main.users.get(user_index).name);
        System.out.println("Please Select an option");
        System.out.println("    -> Enter 1 to Extend the Tenure of Rented Vehicle");
        System.out.println("    -> Enter 2 to View / Add money to Wallet");
        System.out.println("    -> Enter 3 to See List of Vehicles Available");
        System.out.println("    -> Enter 4 to Search a Vehicle");
        System.out.println("    -> Enter 5 to view Transactions");
        System.out.println("    -> Enter 6 to Logout");
        System.out.print("Enter Choice : ");
        String opt = Main.sc.nextLine();
        switch (opt) {
            case "1":
                extendTenure(user_index);
                userPage(user_index);
                break;
            case "2":
                updateWallet(user_index);
                userPage(user_index);
                break;
            case "3":
                viewVehicleList(user_index);
                userPage(user_index);
                break;
            case "4":
                Vehicle.searchVehicle();
                userPage(user_index);
                break;
            case "5":
                viewTransactions(user_index);
                userPage(user_index);
                break;
            case "6":
                login();
                break;
            default:
                System.out.println("Invalid Choice !\nEnter Correct Option");
                System.out.println("Press any key to continue......");
                Main.sc.nextLine();
                userPage(user_index);
        }
    }

    private static void extendTenure(int user_index) {
        System.out.print("\033[H\033[2J");
        if (Main.users.get(user_index).borrows.isEmpty()) {
            System.out.println("You Haven't Borrowed any Vehicles yet !");
            System.out.println("Press any key to continue......");
            Main.sc.nextLine();
            return;
        }
        if (Main.users.get(user_index).borrows.size() == 1) {
            extenure(Main.users.get(user_index).borrows.get(0));
        } else {
            System.out.println("Enter 1 to extend tenure of Rented "
                    + Main.transactions.get(0).vehicle.getClass().getSimpleName());
            System.out.println("Enter 2 to extend tenure of Rented "
                    + Main.transactions.get(1).vehicle.getClass().getSimpleName());
            System.out.println("Enter 3 to Exit");
            String opt = Main.sc.nextLine();
            switch (opt) {
                case "1":
                    extenure(Main.users.get(user_index).borrows.get(0));
                    break;
                case "2":
                    extenure(Main.users.get(user_index).borrows.get(1));
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Invalid Choice !\nEnter Correct Option");
                    System.out.println("Press any key to continue......");
                    Main.sc.nextLine();
                    extendTenure(user_index);
            }
        }
    }

    private static void extenure(Object object) {
        if (object instanceof Bike) {
            System.out.println("Are you sure to Extend tenure of Bike for a Day ?");
            System.out.print("Press y to confirm or 0 to exit");
            String opt = Main.sc.nextLine();
            switch (opt) {
                case "y":
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid Choice !\nEnter Correct Option");
                    System.out.println("Press any key to continue......");
                    Main.sc.nextLine();
                    extenure(object);
            }
            Bike tp = (Bike) object;
            if (tp.tenure < 3) {
                tp.tenure++;
            } else {
                System.out.println("Maximum tenure Extension Limit is 2 days\nReturn the Vehicle");
                System.out.println("Press any key to continue......");
                Main.sc.nextLine();
                return;
            }
        } else {
            System.out.println("Are you sure to Extend tenure of Car~ for a Day ?");
            System.out.print("Press y to confirm or 0 to exit");
            String opt = Main.sc.nextLine();
            switch (opt) {
                case "y":
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Invalid Choice !\nEnter Correct Option");
                    System.out.println("Press any key to continue......");
                    Main.sc.nextLine();
                    extenure(object);
            }
            Car tp = (Car) object;
            if (tp.tenure < 3) {
                tp.tenure++;
            } else {
                System.out.println("Maximum tenure Extension Limit is 2 days\nReturn the Vehicle");
                System.out.println("Press any key to continue......");
                Main.sc.nextLine();
                return;
            }
        }
        System.out.println("Tenure Extended for 1 day");
        System.out.println("Press any key to continue......");
        Main.sc.nextLine();
    }

    private static void viewTransactions(int user_index) {
        System.out.print("\033[H\033[2J");
        System.out.println("------Your Transacions-------");
        System.out.println("============================================================================");
        for (int index = 0; index < Main.transactions.size(); index++) {
            if (Main.users.get(user_index).equals(Main.transactions.get(index).user)) {
                System.out
                        .println("Vehicle Type => " + Main.transactions.get(index).vehicle.getClass().getSimpleName());
                System.out.println("Transaction Type => " + Main.transactions.get(index).transactionType);
                System.out.println(
                        "Transaction Done on => " + Main.transactions.get(index).dateOfTransaction.getDayOfMonth() + "/"
                                + Main.transactions.get(index).dateOfTransaction.getMonthValue() + "/"
                                + Main.transactions.get(index).dateOfTransaction.getYear());
                System.out.println("Amount Paid => " + Main.transactions.get(index).amountPaid);
                System.out.println("Payment Type => " + Main.transactions.get(index).paymentType);
                System.out.println();
            }
        }
        System.out.println("============================================================================");
        System.out.println("Press any key to continue......");
        Main.sc.nextLine();
    }

    public static void updateWallet(int user_index) {
        System.out.print("\033[H\033[2J");
        System.out.println("---------Wallet Actions---------");
        System.out.println("Current Wallet Balance is Rs. => " + Main.users.get(user_index).wallet);
        System.out.print("Enter Amount to be added (or) 0 to exit : ");
        Integer adder = Integer.parseInt(Main.sc.nextLine());
        if (adder == 0) {
            return;
        } else {
            Main.users.get(user_index).wallet += adder;
            System.out.println("Your Upated Balance is Rs. => " + Main.users.get(user_index).wallet);
            System.out.println("Press any key to continue......");
            Main.sc.nextLine();
        }
    }

    private static void viewVehicleList(int user_index) {
        System.out.print("\033[H\033[2J");
        System.out.println("--------Select Vehicle--------");
        System.out.println("Enter 1 to view List of Bikes");
        System.out.println("Enter 2 to view List of Cars");
        System.out.println("Enter 3 to Exit");
        String s = Main.sc.nextLine();
        switch (s) {
            case "1":
                Vehicle.viewBikes();
                viewVehicleList(user_index);
                break;
            case "2":
                Vehicle.viewCars();
                viewVehicleList(user_index);
                break;
            case "3":
                return;
            default:
                System.out.println("Invalid Choice !\nEnter Correct Option");
                System.out.println("Press any key to continue......");
                Main.sc.nextLine();
                break;
        }
    }

    static void forgetPassword(int user_index) {
        System.out.print("\033[H\033[2J");
        System.out.print("Enter Your Mobile number or 0 to Exit : ");
        String mobile = Main.sc.nextLine();
        if (mobile.equals("0")) {
            userLogin();
        }
        if (Main.users.get(user_index).mobile.equals(mobile)) {
            System.out.print("Enter OTP : ");
            String otp = Main.sc.nextLine();
            if (otp.equals("123456")) {
                System.out.println("Your Password is => " + Main.users.get(user_index).pass);
                System.out.println("Press any key to continue......");
                Main.sc.nextLine();
                login();
            } else {
                System.out.println("Wrong OTP !\nTry again");
                System.out.println("Press any key to continue......");
                Main.sc.nextLine();
                forgetPassword(user_index);
            }
        } else {
            System.out.println("Entered Mobile number Doesn't match");
            System.out.println("Press any key to continue......");
            Main.sc.nextLine();
            forgetPassword(user_index);
        }
    }

    static void userSignUp() {
        System.out.print("\033[H\033[2J");
        System.out.println("-----New User SignUp----");
        System.out.print("Enter Your name or 0 to  exit: ");
        String name = Main.sc.nextLine();
        if (name.equals("0")) {
            login();
        }
        System.out.print("Enter Your Email : ");
        String email = Main.sc.nextLine();
        System.out.print("Enter Password : ");
        String pass = Main.sc.nextLine();
        System.out.print("Enter Mobile Number : ");
        String mobile = Main.sc.nextLine();
        System.out.print("Enter Address : ");
        String address = Main.sc.nextLine();
        Main.users.add(new User(name, email, pass, mobile, address));
        System.out.println("Account has been Created Successfully !\nLogin to continue");
        System.out.println("Press any key to continue......");
        Main.sc.nextLine();
        login();
    }

    public static void putFine(int ind) {
        System.out.print("\033[H\033[2J");
        System.out.print("Enter Customer's Email or 0 to exit : ");
        String email = Main.sc.nextLine();
        int user_index = findUserInd(email);
        if (user_index == -1) {
            System.out.println("User not Found !");
            System.out.println("Press any key to continue......");
            Main.sc.nextLine();
            putFine(ind);
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
            System.out.println(x + " has been removed successfully & Fine amount is collected from the user");
            System.out.println("Press any key to continue......");
            Main.sc.nextLine();
        }
    }
}
