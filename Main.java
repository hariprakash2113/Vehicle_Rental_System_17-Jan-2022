import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        homepage();
    }

    static List<Admin> admins = new ArrayList<>();
    static List<User> users = new ArrayList<>();

    static{
        admins.add(new Admin("Hari Prakash", "hari", "1108"));
        users.add(new User("Hari Prakash", "harii", "1108","99650","Tiruppur"));
    }

    public static void homepage(){
        System.out.print("\033[H\033[2J");
        System.out.println("------Vehicle Rental System Application----------");
        System.out.println("    -> Enter 1 for Admin Login");
        System.out.println("    -> Enter 2 for Customer Actions");
        System.out.println("    -> Enter 3 to Quit Application");
        System.out.print("Enter Choice :  ");
        int n = Integer.parseInt(sc.nextLine());
        if(n==1){
            Admin.login();
        }
        else if(n==2){
            User.login();
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
