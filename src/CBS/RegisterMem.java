package cbstatement;

import java.sql.*;

public class RegisterMem {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "DEUDB";
        String password = "1234";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "{CALL RegisterMember(?, ?, ?, ?, ?, ?, ?, ?, ?)}";

            try (CallableStatement cstmt = conn.prepareCall(sql)) {
                cstmt.setString(1, "GUN001"); // 회원 ID
                cstmt.setString(2, "이창건"); // 이름
                cstmt.setDate(3, java.sql.Date.valueOf("2003-01-27")); // 생년월일
                cstmt.setString(4, "010-3398-9352"); // 연락처
                cstmt.setString(5, "동의대학교"); // 소속
                cstmt.setString(6, "AFF001"); // 소속번호
                cstmt.setString(7, "부산시 진구"); // 주소
                cstmt.setString(8, "학생"); // 이용형태
                cstmt.registerOutParameter(9, java.sql.Types.VARCHAR); // 출력 메시지

                cstmt.execute();
                String message = cstmt.getString(9); // 결과 메시지 가져오기
                System.out.println("결과 메시지: " + message);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
