package Database;
import java.sql.*;

public class Connect {
    private Connection conn = null;

    // Phương thức thực hiện kết nối CSDL
    public Connection connectSQL() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(
                "jdbc:sqlserver://localhost:1433;databaseName=QLSanpham;encrypt=false;trustServerCertificate=true",
                "sa",
                "12345678"
            );
            System.out.println("Kết nối thành công!!!");
            return conn; // Trả về kết nối nếu thành công
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Lỗi: " + ex.getMessage());
            return null; // Trả về null nếu không kết nối được
        }
    }

    // Phương thức để lấy kết nối
    public Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) { // Kiểm tra nếu chưa kết nối hoặc đã đóng
                return connectSQL(); // Gọi phương thức connectSQL() để tạo kết nối
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn; // Trả về kết nối nếu đã có
    }

    // Phương thức đóng kết nối
    public void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
                System.out.println("Đóng kết nối thành công!");
            } catch (SQLException ex) {
                System.out.println("Lỗi: " + ex.getMessage());
            }
        }
    }
}
