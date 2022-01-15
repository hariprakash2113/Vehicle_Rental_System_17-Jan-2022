public class User {
    String email;
    String pass;
    Integer wallet = 50000;

    public User(String email, String pass, Integer wallet) {
        this.email = email;
        this.pass = pass;
        this.wallet = wallet;
    }

    public static void login() {
        System.out.print("\033[H\033[2J");
        System.out.println("-----Select User Type-----");
        System.out.println("Enter 1 for Sign Up");
        System.out.println("Enter 2 for Log in");
        System.out.println("Enter 3 to go back");

        int n = Integer.parseInt(Main.sc.nextLine());

        if (n == 1) {
            // userSignUp();
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

}
