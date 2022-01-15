public class User {
    String name;
    String email;
    String pass;
    String mobile;
    String Address;
    Integer wallet = 50000;

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

        int n = Integer.parseInt(Main.sc.nextLine());

        if (n == 1) {
            userSignUp();
        }

        else if (n == 2) {
            // userLogin();
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

}
