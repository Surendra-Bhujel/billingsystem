package View;

import java.util.Scanner;


public class BillingApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while(true){
            System.out.println("Enter 1: Calculate Bill");
            System.out.println("Enter 2: Show highest paying");
            System.out.println("Enter 3: Exit");
            int option = Integer.parseInt(scan.nextLine());
            if(option < 0){
                System.out.println("Invalid option, please enter 1/2/3");
            }
            else if(option == 1){
                System.out.println("Enter customer name: ");
                String customerName = scan.nextLine();
                System.out.println("Enter house number: ");
                String houseNumber = scan.nextLine();
                System.out.println("Enter units consumed: ");
                double unitsConsumed = Double.parseDouble(scan.nextLine());
                Customer customer = new Customer(customerName, houseNumber, unitsConsumed);
                double billAmount = customer.calculateBill();
                BillRecord record = new BillRecord(customer, billAmount);
                if(BillRecord.addBillRecord(record)){
                    System.out.println("Record added successfully....");
                    System.out.println("Bill Info: ");
                    //TODO print the bill here
                }else{
                    System.out.println("Failed...");
                }
            }else if(option == 2){
                BillRecord record = BillRecord.showHighestPayingCustomer();
                System.out.println("Customer name: "+ record.getCustomer().getName());
                System.out.println("House Number: "+ record.getCustomer().getHouseNumber());
                System.out.println("Units Consumed: "+ record.getCustomer().getUnitsConsumed());
                System.out.println("Bill Amount: "+ record.getBillAmount());
            }else if(option == 3){
                System.out.println("tata");
                break;
            }else{
                System.out.println("Invalid option, please enter 1/2/3");
            }
        }

    }
}