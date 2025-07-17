import java.time.LocalDate;
import java.util.ArrayList;

public class BillRecord {
    private static ArrayList<BillRecord> billRecordsList = new ArrayList<>();
    //customer ko details {customer details, bill amount, billing date}
    private Customer customer;
    private double billAmount;
    //TODO jaile record add hunxa teti bela ko date chainxa
    private LocalDate billingDate;
    public BillRecord(){

    }
    public BillRecord(Customer customer, double billAmount){
        this.customer = customer;
        this.billAmount = billAmount;
        this.billingDate = LocalDate.now();
    }
    //add a customer bill record
    public static boolean addBillRecord(BillRecord billRecord){
        boolean isRecordAdded = false;
        if(billRecordsList.add(billRecord)){
            isRecordAdded = true;
        }
        return isRecordAdded;
    }


    public Customer getCustomer() {
        return customer;
    }

    public double getBillAmount() {
        return billAmount;
    }


    public LocalDate getBillingDate() {
        return billingDate;
    }

    //TODO print the bill
    public void printBill(){

    }
    //show highest paying customer
    public static BillRecord showHighestPayingCustomer(){
        BillRecord maxBillRecord = null;
        double maxBillAmount = 0;
        double billAmount = 0;
        for(BillRecord billRecord: billRecordsList){
            billAmount = billRecord.getBillAmount();
            if(maxBillAmount < billAmount){
                maxBillAmount = billAmount;
                maxBillRecord = billRecord;
            }
        }
        return maxBillRecord;
    }
}
