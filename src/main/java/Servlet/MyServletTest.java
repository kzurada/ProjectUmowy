package Servlet;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/myservlettest")
public class MyServletTest extends HttpServlet {

    @Resource(name = "jdbc/umowy")
    private DataSource dataSource;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/plain");

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myConn = dataSource.getConnection();

            String sql = "select * from umowy";
            myStmt = myConn.createStatement();

            myRs = myStmt.executeQuery(sql);

            while (myRs.next()) {
                String amnount_type = myRs.getString("amount_type");
                out.println(amnount_type);

            }
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
