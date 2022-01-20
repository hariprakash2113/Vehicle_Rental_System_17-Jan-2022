
public class Admin {
    String name;
    String email;
    String password;

    public Admin(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    static void login() {
        System.out.print("\033[H\033[2J");
        System.out.println("-----Welcome Admin-----");
        System.out.print("Enter your Email ID or 0 to Exit : ");
        String email = Main.sc.nextLine();
        if (email.equals("0"))
            Main.homepage();
        int ind = -1;
        for (int i = 0; i < Main.admins.size(); i++) {
            if (Main.admins.get(i).email.equals(email)) {
                ind = i;
                break;
            }
        }
        if (ind == -1) {
            System.out.println("Email ID not found");
            System.out.println("Press any key to continue......");
            Main.sc.nextLine();
            login();
        } else {
            System.out.print("Enter Password : ");
            String pass = Main.sc.nextLine();
            if (Main.admins.get(ind).password.equals(pass)) {
                adminPage(ind);
            } else {
                System.out.println("Wrong Password ! Try Again");
                System.out.println("Press any key to continue......");
                Main.sc.nextLine();
                login();
            }
        }
    }

    static void adminPage(int ind) {
        System.out.print("\033[H\033[2J");
        System.out.printf("----Welcome , %s -----\n", Main.admins.get(ind).name);
        System.out.println();
        System.out.println("Please Select an option");
        System.out.println();
        System.out.println("    -> Enter a for Adding a Vehicle");
        System.out.println();
        System.out.println("    -> Enter b to Modify Vehicle`s Rent per Day");
        System.out.println();
        System.out.println("    -> Enter c for Removing a vehicle");
        System.out.println();
        System.out.println("    -> Enter d to Add a admin");
        System.out.println();
        System.out.println("    -> Enter e to view List of Bikes");
        System.out.println();
        System.out.println("    -> Enter f to view List of Cars");
        System.out.println();
        System.out.println("    -> Enter g to search a Vehicle");
        System.out.println();
        System.out.println("    -> Enter h to Issue a Vehicle");
        System.out.println();
        System.out.println("    -> Enter i to Return a Vehicle");
        System.out.println();
        System.out.println("    -> Enter j to put Fine on Customer for Loss of Vehicle");
        System.out.println();
        System.out.println("    -> Enter k to View/Change status of list of vehicles Waiting for Service");
        System.out.println();
        System.out.println("    -> Enter l to Change Security Deposit Amount of User");
        System.out.println();
        System.out.println("    -> Enter m to Generate reports");
        System.out.println();
        System.out.println("    -> Enter n to change your password");
        System.out.println();
        System.out.println("    -> Enter 0 to Logout");
        System.out.println();
        System.out.print("Enter Choice : ");
        char c = Main.sc.nextLine().charAt(0);
        switch (c) {
            case 'a':
                Vehicle.addVehicle(ind);
                break;
            case 'b':
                Vehicle.modify();
                adminPage(ind);
                break;
            case 'c':
                Vehicle.removeVehicle();
                adminPage(ind);
                break;
            case 'd':
                addNewAdmin(ind);
                break;
            case 'e':
                Vehicle.viewBikes();
                adminPage(ind);
                break;
            case 'f':
                Vehicle.viewCars();
                adminPage(ind);
                break;
            case 'g':
                Vehicle.searchVehicle();
                adminPage(ind);
                break;
            case 'h':
                Vehicle.issue(ind);
                adminPage(ind);
                break;
            case 'i':
                Vehicle.returnVehicle(ind);
                adminPage(ind);
                break;
            case 'j':
                User.putFine(ind);
                adminPage(ind);
                break;
            case 'k':
                Vehicle.serviceList();
                adminPage(ind);
                break;
            case 'l':
                changeAmount();
                adminPage(ind);
                break;
            case 'm':
                Vehicle.generateReport(ind);
                adminPage(ind);
                break;
            case 'n':
                changePassword(ind);
                break;
            case '0':
                Main.homepage();
                break;
            default:
                System.out.println("Invalid Input");
                System.out.println("Enter Correct Choice");
                System.out.println("Press any key to continue......");
                Main.sc.nextLine();
                adminPage(ind);
        }
    }

    private static void changeAmount() {
        System.out.print("\033[H\033[2J");
        System.out.print("Enter Email ID of User or 0 to Exit :");
        String email = Main.sc.nextLine();
        User.updateWallet(User.findUserInd(email));
    }

    static void changePassword(int ind) {
        System.out.print("\033[H\033[2J");
        System.out.print("Enter old Password or 0 to exit : ");
        String oldPass = Main.sc.nextLine();
        if (oldPass.equals("0")) {
            adminPage(ind);
        }
        if (Main.admins.get(ind).password.equals(oldPass)) {
            System.out.print("Enter new Password : ");
            Main.admins.get(ind).password = Main.sc.nextLine();
            System.out.println("Your Password has been Upated\nYou have been logged out");
            System.out.println("Press any key to continue......");
            Main.sc.nextLine();
            login();
        } else {
            System.out.println("Enter your Old Password Correctly");
            System.out.println("Press any key to continue......");
            Main.sc.nextLine();
            changePassword(ind);
        }
    }

    static void addNewAdmin(int ind) {
        System.out.print("\033[H\033[2J");
        System.out.println("-----Add new Admin-----");
        System.out.print("Enter new Admin name or 0 to  exit: ");
        String name = Main.sc.nextLine();
        if (name.equals("0"))
            adminPage(ind);
        System.out.print("Enter Email of New Admin : ");
        String email = Main.sc.nextLine();
        System.out.print("Enter Password of New Admin : ");
        String password = Main.sc.nextLine();
        Main.admins.add(new Admin(name, email, password));
        System.out.printf("Admin %s has been Successfully Added\n", name);
        System.out.println("Enter 1 to add one another Admin else any other key for returing to to Admin page");
        String n = Main.sc.nextLine();
        if (n.equals("1")) {
            addNewAdmin(ind);
        } else {
            adminPage(ind);
        }
    }

}
