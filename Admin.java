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
                ind = i;break;
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
        System.out.println("Please Select an option");
        System.out.println("    -> Enter a for Adding a Vehicle");
        System.out.println("    -> Enter b to Moify Vehicle details");
        System.out.println("    -> Enter c for Removing a vehicle");
        System.out.println("    -> Enter d to Add a admin");
        System.out.println("    -> Enter e to view List of Bikes");
        System.out.println("    -> Enter f to view List of Cars");
        System.out.println("    -> Enter g to search a Vehicle");
        System.out.println("    -> Enter h to Change Security Deposit Amount of User");
        System.out.println("    -> Enter i to Generate reports");
        System.out.println("    -> Enter j to Logout");
        System.out.print("Enter Choice : ");
        char c = Main.sc.nextLine().charAt(0);
        switch (c) {
            case 'a':
                // Vehicle.addBook(ind);
                break;
            case 'b':
                // Vehicle.modify(ind);
                break;
            case 'c':
                // Vehicle.deleteBook(ind);
                break;
            case 'd':
                // addNewAdmin(ind);
                break;
            case 'e':
                //Vehicle.viewBikes(ind);
                break;
            case 'f':
                // Vehicle.viewCars(ind);
                break;
            case 'g':
                // Vehicle.searchVehicle(ind);
                break;
            case 'h':
                // User.changaAmount(ind);
                break;
            case 'i':
                // Book.generateReport(ind);
                break;
            case 'j':
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

}
