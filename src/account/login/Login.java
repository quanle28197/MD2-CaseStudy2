package account.login;

import account.admin.AccountAdmin;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Login {
    private final Scanner scanner = new Scanner(System.in);
    private final Scanner scanner1 = new Scanner(System.in);
    AccountAdmin accountAdmin = new AccountAdmin();
    AccountUserManagement accountUserManagement = new AccountUserManagement();

    public Login() {
    }
    public void loginSystem() {
        try {
            menuLogin();
        }catch (InputMismatchException e) {
            System.out.println();
            System.out.println("Wrong input, enter again");
            System.out.println();
            scanner.nextLine();
            loginSystem();
        }
    }

    private void menuLogin() throws InputMismatchException {
        System.out.println("---------------------------------------------------");
        System.out.println("----|               LOGIN MENU                |----");
        System.out.println("---------------------------------------------------");
        System.out.println("Enter your id:");
        String id = scanner.nextLine();
        System.out.println("Enter password");
        String password = scanner1.nextLine();
        System.out.println(".........");
        checkAccount(id, password);
    }

    private void checkAccount(String id, String password) {
        try {
            if (checkAccountAdminLoginIn(id, password)) {
                System.out.println("  **** Login succes as Admin access Welcome!" + id + " ****  ");
                new Menu_Admin();
            }else if (checkAccountUserLoginIn(id, password)) {
                System.out.println("**** Login success as User access. Welcome!" + id + "  ****  ");
                new Menu_User(findUserById(id));
            }else {
                System.out.println("- Wrong id or password");
                System.out.println("-  Back to Main Menu  -");
                new MainMenu();
            }
        }catch (Exception e) {
            System.out.println("Login failed");
        }
    }

    public AccountUser findUserById(String id) {
        for (AccountUser user : accountUserManagement.getAccountUserList()) {
            if (id.equals(user.getUserId())) {
                return user;
            }
        }
        return null;
    }

    private boolean checkAccountAdminLoginIn(String id, String password) {
        for (AccountAdmin acc : accountAdmin.getAdminList()) {
            boolean check = id.equals(acc.getAdminId()) && password.equals(acc.getAdminPass());
            if (check) return true;
        }
        return false;
    }

    private boolean checkAccountUserLoginIn(String id, String password) {
        for (AccountUser acc : accountUserManagement.getAccountUserList()) {
            boolean check = id.equals(acc.getUserId()) && password.equals(acc.getUserPassword());
            if (check) return true;
        }
        return false;
    }
}


