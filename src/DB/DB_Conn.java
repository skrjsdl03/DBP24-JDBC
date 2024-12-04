package DB;

import java.sql.*;

public class DB_Conn {
    private Connection con = null;
    private String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private String id = "DEUDB";
    private String password = "1234";

    public DB_Conn() {
        // 드라이버 적재
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("드라이버 적재 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버를 찾을 수 없습니다.");
        }
    }

    // DB 연결 메서드
    public void DB_Connect() {
        try {
            con = DriverManager.getConnection(url, id, password);
            System.out.println("DB 연결 성공");
        } catch (SQLException e) {
            System.out.println("DB 연결 실패");
            e.printStackTrace();
        }
    }

    // Connection 객체 반환
    public Connection getConnection() {
        return con;
    }

    // DB 연결 종료 메서드
    public void closeConnection() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("DB 연결 종료");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
