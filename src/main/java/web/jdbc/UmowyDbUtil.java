package web.jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UmowyDbUtil {

    private DataSource dataSource;

    public UmowyDbUtil(DataSource theDataSource) {
        dataSource = theDataSource;
    }


    public List<Umowy> getUmowy() throws Exception {

        List<Umowy> umowyList = new ArrayList<>();

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myConn = dataSource.getConnection();
            String sql = "select * from umowy order by request";
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery(sql);

            while (myRs.next()) {

                int request = myRs.getInt("request");
                String active = myRs.getString("active");
                double amount = myRs.getDouble("amount");
                String amount_period = myRs.getString("amount_period");
                String amount_type = myRs.getString("amount_type");
                int authorization_percent = myRs.getInt("authorization_percent");
                String from_date = myRs.getString("from_date");
                String order_number = myRs.getString("order_number");
                String system = myRs.getString("system");
                String to_date = myRs.getString("to_date");

                Umowy tempUmowy = new Umowy(system, request, order_number, from_date, to_date, amount, amount_type, amount_period, authorization_percent, active);

                umowyList.add(tempUmowy);
            }

            return umowyList;
        } finally {
            close(myConn, myStmt, myRs);
        }
    }


    private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

        try {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

}















