import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        homepage();
    }

    public static void homepage(){
        System.out.print("\033[H\033[2J");
        System.out.println("------Vehicle Rental System Application----------");
        System.out.println("    -> Enter 1 for Admin Login");
        System.out.println("    -> Enter 2 for User Login");
        System.out.println("    -> Enter 3 to Quit Application");
        System.out.print("Enter Choice :  ");
        int n = Integer.parseInt(sc.nextLine());
        if(n==1){
            // Admin.login();
        }
        else if(n==2){
            // User.userType();
        }
        else if(n==3){
            System.exit(0);
        }
        else{
            System.out.println("\n\nInvalid option ! \nEnter correct choice");
            homepage();
        }
    }
}
