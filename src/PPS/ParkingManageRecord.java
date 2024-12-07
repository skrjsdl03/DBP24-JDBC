package ppstatement;

import java.sql.*;

public class ParkingManageRecord {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "DEUDB";
        String password = "1234";

        String parkingLotId = "PARK001"; // 주차장 ID

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT m.이름, g.점검일시 " +
                    "FROM 관리 g " +
                    "JOIN 관리인 m ON g.관리자ID = m.관리자ID " +
                    "WHERE g.주차장ID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, parkingLotId);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("관리자 이름: " + rs.getString("이름"));
                System.out.println("점검 일시: " + rs.getTimestamp("점검일시"));
                System.out.println("------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
