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
                System.out.println("adminPage(ind);");
            } else {
                System.out.println("Wrong Password ! Try Again");
                System.out.println("Press any key to continue......");
                Main.sc.nextLine();
                login();
            }
        }
    }

}
