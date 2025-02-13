package dao;

import model.Orders;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdersDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/userdb";
    private static final String USER = "root";
    private static final String PASSWORD = "";



    public List<Orders> getAllOrders() {
        List<Orders> orders = new ArrayList<>();
        String query = "SELECT * FROM orders";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                orders.add(new Orders(rs.getInt("id"), rs.getInt("customerId"),
                        rs.getDate("orderDate"), rs.getDouble("totalAmount")));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return orders;
    }

    public void addOrder(Orders order) {
        String query = "INSERT INTO orders (customerId, orderDate, totalAmount) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, order.getCustomerId());
            stmt.setDate(2, new java.sql.Date(order.getOrderDate().getTime()));
            stmt.setDouble(3, order.getTotalAmount());
            stmt.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}
