package dao;

import model.OrderDetails;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailsDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/userdb";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public List<OrderDetails> getOrderDetailsWithCustomerAndProduct() {
        List<OrderDetails> orderDetailsList = new ArrayList<>();
        String query = "SELECT c.name AS customer_name, p.name AS product_name, od.quantity, p.price " +
                       "FROM products p " +
                       "INNER JOIN orderDetails od ON p.id = od.product_id " +
                       "INNER JOIN orders o ON od.order_id = o.id " +
                       "INNER JOIN customer c ON o.customer_id = c.id";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Tải driver
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                OrderDetails od = new OrderDetails();
                od.setCustomerName(rs.getString("customer_name"));
                od.setProductName(rs.getString("product_name"));
                od.setQuantity(rs.getInt("quantity"));
                od.setPrice(rs.getDouble("price"));
                orderDetailsList.add(od);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderDetailsList;
    }
}
