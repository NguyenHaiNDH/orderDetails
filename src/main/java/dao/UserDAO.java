package dao;

import model.User;
import java.sql.*;

public class UserDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/userdb";
    private static final String USER = "root"; // Thay bằng user MySQL của bạn
    private static final String PASSWORD = ""; // Thay bằng password của bạn

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean validateUser(User user) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
