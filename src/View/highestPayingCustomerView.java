package View;

import Model.BillRecord;
import Model.Customer;
import DAO.billDAO;

import java.sql.SQLException;
public class highestPayingCustomerView {
    public static void showHighestPayingCustomerView()throws SQLException{
        BillRecord billRecord = billDAO.showHighestPayingCustomer();
        if(billRecord == null){
            System.out.println("No bill or customer found.");
            return;
        }
        Customer customer = billDAO.getCustomerById(billRecord.getCustomerId());
        if (customer == null){
            System.out.println("Customer not found for billRecord.");
            return;
        }
        System.out.println("Customer ID: " + billRecord.getCustomerId());
        System.out.println("Customer Name: " + customer.getName());
        System.out.println("House Number: " + customer.getHouseNumber());
        System.out.println("Contact: " + customer.getContact());
        System.out.println("Units Consumed: " + billRecord.getUnitUsed());
        System.out.println("Bill Amount: " + billRecord.getBillAmount());
    }
}
