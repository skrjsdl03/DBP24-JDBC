package cbstatement;

import java.sql.*;

public class RegisterUpdateRecord {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "DEUDB";
        String password = "1234";


        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sqlInsert = "INSERT INTO 주차 (차량번호, 공간번호, 주차장ID) VALUES (?, ?, ?)";
            String sqlUpdate = "UPDATE 주차 SET 출차일시 = ? WHERE 차량번호 = ? AND 출차일시 IS NULL";

            try {
                // 차량 입차 기록
                try (PreparedStatement pstmt = conn.prepareStatement(sqlInsert)) {
                    pstmt.setString(1, "CAR001"); // 차량번호
                    pstmt.setString(2, "SP001"); // 공간번호
                    pstmt.setString(3, "P011"); // 주차장 ID
                    pstmt.executeUpdate();
                    System.out.println("차량 입차 기록이 추가되었습니다.");
                }

                // 차량 출차 기록
                try (PreparedStatement pstmt = conn.prepareStatement(sqlUpdate)) {
                    pstmt.setTimestamp(1, new Timestamp(System.currentTimeMillis())); // 출차일시
                    pstmt.setString(2, "CAR001"); // 차량번호
                    pstmt.executeUpdate();
                    System.out.println("차량 출차 기록이 업데이트되었습니다.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
