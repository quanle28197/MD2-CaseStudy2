package account.createAccount;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CreateAccount {
    public static Scanner scanner = new Scanner(System.in);
    public static AccountManagement accountUserManagement = new AccountUserManagement();
    boolean isValidNumber;
    public static Pattern patternPassword = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{6,}$");
    public static Pattern patternId = Pattern.compile("^[a-zA-Z0-9]{6,12}$");

    public static void createAcc() throws IndexOutOfBoundsException, IOException {
        while(true) {
            System.out.println("----------------------------------------------------");
            System.out.println("----|            REGISTRATION MENU             |----");
            System.out.println("----------------------------------------------------");
            System.out.println("Enter yours users id: ");
            String id = checkValid();
            System.out.println("Enter your password");
            String password = scanner.nextLine();
        }

        System.out.println("Re-enter your password: ");
        String secondPassword = scanner.nextLine();
        if (password.equals(secondPassword)) {
            if (checkIdUser(id)) {
                FileWriter fw = new FileWriter(id + ".txt");
                fw.write("");
                fw.close(); FileWriter w1 = new FileWriter(id + "wallet.txt" );
                w1.write("");
                w1.close();
                accountUserManagement.setListAccountUser(id, password);
                System.out.println("Successfully create new account");
                String typeToExit;
                do {
                    System.out.println("Type quit to back to Main Menu");
                    typeToExit = scanner.next();
                    if (typeToExit.equalsIgnoreCase("quit")) {
                        new MainMenu();
                    }
                } while (!(typeToExit.equals("quit")));
            }else {
                System.out.println(" - Account Id already exists");
                System.out.println(" - back to Main Menu");
                new MainMenu();
            }
        }else {
            System.out.println("Wrong password, enter again");
        }
    }
}

public static String checkValid() {
    String value;
    boolean check = false;
    do {
        value = scanner.nextLine();
        if (patternId.matcher(value).matches()) {
            check = true;
        }else {
            System.out.println("From 6 to 12 characters required");
            System.out.println("Special character are not allow");
            System.out.println("Enter again");
        }
    }while (!check);
    return value;
}

public static boolean checkIdUser(String Id) {
    if (accountUserManagement.getAccountUserList() != null) {
        for (AccountUser acc : accountUserManagement.getAccountUserList()) {
            boolean checkIdUser = id.equals(acc.getUserId());
            if (checkIdUser) {
                return false;
            }
        }
    }
    return true;
}
