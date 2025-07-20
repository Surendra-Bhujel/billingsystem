package View;

import Controller.viewController;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuView {

    public static void showMenuView() throws SQLException {
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("=======================================");
            System.out.println("Billing System Menu ");
            System.out.println("=======================================");
            System.out.println("Enter 1: Calculate Bill");
            System.out.println("Enter 2: Show highest paying Customer");
            System.out.println("Enter 3: Exit");
            System.out.println("========================================");
            System.out.println("Enter your choice(1-3): ");
            int option = Integer.parseInt(scan.nextLine());
            if(option < 0){
                System.out.println("Invalid option, please enter 1/2/3");
            } else if (option == 1) {
                viewController.getbillView();
            } else if (option == 2) {
                viewController.gethighestPayingCustomerView();
            } else if (option == 3) {
                System.out.println("Exiting The BillingSystem. GoodBye!");
                break;
            }else {
                System.out.println("Invalid option.Please enter a number between 1 to 3.");
            }
        }
    }
}
