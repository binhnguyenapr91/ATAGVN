package service;

import model.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ResultReport;

public class Report {

    public List<ResultReport> getOrdersDetailByName(String name, String startTime, String endTime) throws SQLException {
        Connection connection = DBConnect.getConnection();
        List<ResultReport> listResult = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement("call reportByNameAndTime(?,?,?)");
        ps.setString(1, name);
        ps.setString(2, startTime);
        ps.setString(3, endTime);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String orderId = rs.getString("OrderId");
            String orderDate = rs.getString("orderDate");
            String accountName = rs.getString("AccountName");
            String productName = rs.getString("ProductName");
            String quantity = rs.getString("Quantity");
            String priceEach = rs.getString("PriceEach");
            listResult.add(new ResultReport(orderId, orderDate,accountName,productName,quantity,priceEach));
        }
        return listResult;
    }

    public static void main(String[] args) throws SQLException {
        Report rp = new Report();
        List<ResultReport> list = new ArrayList<>();
        list = rp.getOrdersDetailByName("Huynh Bui", "2020-03-11", "2020-03-13");
        System.out.println(list.get(0).toString());
    }
}
