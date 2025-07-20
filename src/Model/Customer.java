package Model;

import DAO.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Customer {
    private String customerId;
    private String name;
    private String houseNumber;
    private double unitsConsumed;
    private String contact;

    public Customer(String customerId,String name, String houseNumber, double unitsConsumed,String contact) {
        this.customerId = customerId;
        this.name = name;
        this.houseNumber = houseNumber;
        this.unitsConsumed = unitsConsumed;
        this.contact = contact;
    }

    public String getCustomerId(){
        return customerId;
    }
    public void setCustomerId(String customerId){
        this.customerId = customerId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getHouseNumber() {
        return houseNumber;
    }
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }
    public double getUnitsConsumed() {
        return unitsConsumed;
    }
    public void setUnitsConsumed(double unitsConsumed) {
        this.unitsConsumed = unitsConsumed;
    }
    public String getContact(){
        return contact;
    }
    public void setContact(String contact){
        this.contact = contact;
    }

    public double calculateBill(){
        if (unitsConsumed < 0) return 0;
        if (unitsConsumed <= 10) return 100;
        if (unitsConsumed <= 20) return 250;
        if (unitsConsumed <= 30) return 400;
        if (unitsConsumed <= 50) return 600;
        if (unitsConsumed <= 100) return 1000;
        if (unitsConsumed <= 200) return 1800;
        return 2500;
    }
    public void saveToDatabase() throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO Customer"+
                "(customer_id, name, house_no, contact) VALUES (?, ?, ?, ?)";
        try(Connection conn = DatabaseConnection.connect();
            PreparedStatement ps = conn.prepareStatement(query)){
            ps.setString(1,customerId);
            ps.setString(2,name);
            ps.setString(3,houseNumber);
            ps.setString(4,contact);
            ps.executeUpdate();
        }

    }
}