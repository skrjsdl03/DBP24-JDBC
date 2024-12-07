package cbstatement;

import java.sql.*;

public class UserCalculationParkingFee {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "DEUDB";
        String password = "1234";


        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "{CALL CalculateParkingFee(?, ?)}";

            try (CallableStatement cstmt = conn.prepareCall(sql)) {
                cstmt.setString(1, "GUN001"); // 회원 ID
                cstmt.registerOutParameter(2, java.sql.Types.NUMERIC); // 출력 파라미터 (요금)

                cstmt.execute();
                double fee = cstmt.getDouble(2); // 계산된 요금 가져오기
                System.out.println("계산된 주차 요금: " + fee + "원");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
