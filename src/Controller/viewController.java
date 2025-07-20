package Controller;

import View.billView;
import View.highestPayingCustomerView;

import java.sql.SQLException;

public class viewController {
    public static void getbillView() throws SQLException {
        billView.showbillView();
    }
    public static void gethighestPayingCustomerView() throws SQLException {
        highestPayingCustomerView.showHighestPayingCustomerView();
    }
}
