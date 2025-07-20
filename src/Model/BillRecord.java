package Model;

import java.sql.Date;

public class BillRecord {
    private  String billId;
    private  String customerId;
    private  int unitUsed;
    private  double billAmount;
    private  Date billingDate;

    public BillRecord(String billId, String customerId, int unitUsed, double billAmount, Date billingDate){
        this.billId = billId;
        this.customerId = customerId;
        this.billAmount = billAmount;
        this.unitUsed = unitUsed;
        this.billingDate = billingDate;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getUnitUsed() {
        return unitUsed;
    }

    public void setUnitUsed(int unitUsed) {
        this.unitUsed = unitUsed;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    public Date getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(Date billingDate) {
        this.billingDate = billingDate;
    }
}
