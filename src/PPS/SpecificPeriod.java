package ppstatement;

import java.sql.*;

public class SpecificPeriod {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "DEUDB";
        String password = "1234";

        Timestamp startTime = Timestamp.valueOf("2024-12-05 12:00:00"); // 시작 시간
        Timestamp endTime = Timestamp.valueOf("2024-12-05 14:00:00"); // 종료 시간

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT 차량번호, 공간번호, 주차장ID, 입차일시, 출차일시 " +
                    "FROM 주차 " +
                    "WHERE (입차일시 BETWEEN ? AND ?) " +
                    "   OR (출차일시 BETWEEN ? AND ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setTimestamp(1, startTime);
            stmt.setTimestamp(2, endTime);
            stmt.setTimestamp(3, startTime);
            stmt.setTimestamp(4, endTime);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("차량 번호: " + rs.getString("차량번호"));
                System.out.println("공간 번호: " + rs.getString("공간번호"));
                System.out.println("주차장 ID: " + rs.getString("주차장ID"));
                System.out.println("입차 일시: " + rs.getTimestamp("입차일시"));
                System.out.println("출차 일시: " + rs.getTimestamp("출차일시"));
                System.out.println("------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

