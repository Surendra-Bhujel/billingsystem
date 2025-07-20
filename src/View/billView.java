package View;

import DAO.billDAO;
import DAO.customerDAO;
import Model.BillRecord;
import Model.Customer;

import java.sql.SQLException;
import java.sql.Date;
import java.util.*;
import java.time.LocalDate;

public class billView {
    public static void showbillView() throws SQLException {
        Scanner scan = new Scanner(System.in);
        ArrayList<BillRecord> bills = new ArrayList<>();
        int minHouse = 3;
        int maxHouse = 5;
        int houseCount = 0;
        System.out.println("Enter detail of 3 to 5 house.");
        while (houseCount<maxHouse){
            System.out.println("\nHouse "+(houseCount+1)+ ":");
            System.out.println("Enter customer ID: ");
            String customerID = scan.nextLine();
            if (customerID.isEmpty()){
                System.out.println("CustomerID cannot be empty.");
                continue;
            }
            System.out.println("Enter customer name: ");
            String customerName = scan.nextLine();
            if (customerName.isEmpty()){
                System.out.println("Customer Name cannot be empty.");
                continue;
            }
            System.out.println("Enter house number: ");
            String houseNumber = scan.nextLine();
            System.out.println("Enter units consumed: ");
            double unitsConsumed;
            try{
                unitsConsumed = Double.parseDouble(scan.nextLine());
                if (unitsConsumed<0){
                    System.out.println("Unit consumed cannot be negative.");
                    continue;
                }
            }catch (NumberFormatException e){
                System.out.println("Invalid unit consumed please enter a number.");
                continue;
            }
            System.out.println("Enter contact: ");
            String contact = scan.nextLine();
            Customer customer = new Customer(customerID,customerName, houseNumber, unitsConsumed, contact);
            if(!customerDAO.addCustomer(customer)){
                System.out.println("Failed to save customer to database.");
                continue;
            }
            double billAmount = customer.calculateBill();
            String billId = UUID.randomUUID().toString();
            LocalDate localDate = LocalDate.now();
            Date sqlDate = Date.valueOf(localDate);
            BillRecord record = new BillRecord(billId, customerID, (int) unitsConsumed, billAmount, sqlDate);
            if(billDAO.addBillRecord(record)){
                bills.add(record);
                houseCount++;
                System.out.println("Bill recorded for  "+customerName);
            }else {
                System.out.println("Failed to save Bill Record.");
                continue;
            }
            if (houseCount>=minHouse){
                System.out.println("Add another house?(y/n): ");
                if (!scan.nextLine().equalsIgnoreCase("y")){
                    break;
                }
            }
        }
        for(BillRecord bill : bills) {
            Customer customer = billDAO.getCustomerById(bill.getCustomerId());
            if (customer != null){
                System.out.println("Bill Info: ");
                System.out.println("Customer ID: " + bill.getCustomerId());
                System.out.println("Customer Name: " + customer.getName());
                System.out.println("House Number: " + customer.getHouseNumber());
                System.out.println("Units Consumed: " + bill.getUnitUsed());
                System.out.println("Bill Amount: " + bill.getBillAmount());
                System.out.println("Billing Date: " + bill.getBillingDate());
            } else {
                System.out.println("Failed to add record.");
            }
        }
    }
}