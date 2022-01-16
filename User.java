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
        System.out.println("-----Custumer Login-----");
        System.out.print("Enter Email or 0 to exit : ");
        String email = Main.sc.nextLine();
        if(email.equals("0")){
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
            //userPage(user_index);
            System.out.println("userPage(user_index);");
        } else {
            System.out.println("Incorrect password !\nTry Again");
            System.out.println("Press any key to continue......");
            Main.sc.nextLine();
            userLogin();
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

}