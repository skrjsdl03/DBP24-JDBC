package ppstatement;

import java.sql.*;

public class ParkingSpace {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "DEUDB";
        String password = "1234";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT 공간번호, 이용가능여부, 차량크기, 제한사항정보 FROM 주차공간";
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("공간 번호: " + rs.getString("공간번호"));
                System.out.println("이용 가능 여부: " + rs.getString("이용가능여부"));
                System.out.println("차량 크기: " + rs.getString("차량크기"));
                System.out.println("제한사항 정보: " + rs.getString("제한사항정보"));
                System.out.println("------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
