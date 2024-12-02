package DB;

import oracle.jdbc.OracleTypes;
import java.sql.*;

public class DB_Conn_Query {
    Connection con = null;
    public DB_Conn_Query() {
        // XE의 DB Name : select name from v$database;
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String id = "DEUDB";
        String password = "1234";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
// Program Files/java/jdk버전/jre/lib/ext 폴더로 ojdbc6.jar 복사
//or 시스템 변수에 CLASS_PATH변수 만들어 ojdbc6.jar가 있는 폴더로 지정
//or 프로젝트이름에서 팝업:[File|Properties|Java Build Path|Libraries|Add Ext. Jars 설정
            System.out.println("드라이버 적재 성공");
            con = DriverManager.getConnection(url, id, password);
            System.out.println("데이터베이스 연결 성공");
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버를 찾을 수 없습니다.");
        } catch (SQLException e) {
            System.out.println("연결에 실패하였습니다.");
        }
    }
    private void sqlRun() {
        String query = "select 고객아이디, 고객이름, 적립금 from 고객";
        try {
            // 검색, Statement
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("\t 고객ID \t 고객이름 \t 적립금 ");
            System.out.println("================================ ");
            while (rs.next()) {
                System.out.print("\t" + rs.getString("고객아이디"));
                System.out.print("\t" + rs.getString("고객이름"));
                System.out.print("\t" + rs.getInt(3) + "\n");
            }
            stmt.close();
            // 입력, PreparedStatement. 이 문장은 한번만 실행해야 함. 중복체크 안함
            String s1 = "star", s2 = "홍길동", s3 = "Silver", s4 = "학생";
            int	i1 = 30, i2 = 4500;
            PreparedStatement pstmt =
                    con.prepareStatement("insert into 고객 values(?,?,?,?,?,?)");
            pstmt.setString(1,s1 );
            pstmt.setString(2,s2 );
            pstmt.setInt(3,i1);
            pstmt.setString(4,s3 );
            pstmt.setString(5,s4 );
            pstmt.setInt(6,i2);
            pstmt.executeUpdate();
            pstmt.close();
            // CallableStatement
            CallableStatement cstmt = con.prepareCall("{call SP_잠재고객(?)}");
            cstmt.registerOutParameter(1, OracleTypes.CURSOR);
            cstmt.executeQuery();
            rs = (ResultSet)cstmt.getObject(1);
            System.out.println("====== 잠재고객 명단입니다.======");
            System.out.println();


            while( rs.next( ) ) {
                System.out.println(rs.getString(1)+
                        ",\t"+rs.getString(2)); }

            rs.close();
            con.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public static void main(String arg[]) throws SQLException {
//        DB.DB_Conn_Query dbconquery = new DB.DB_Conn_Query();
//        dbconquery.sqlRun();
//    }
}