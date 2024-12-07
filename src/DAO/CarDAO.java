package DAO;

import DB.DB_Conn;
import DTO.CarDTO;
import DTO.MemberDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {
    public List<Object[]> getCarUsage(String selectSort) throws SQLException {
        return getCarUsage(false, selectSort); // 조건 없는 기본 쿼리 실행
    }
    public List<Object[]> getCarUsage(boolean registedMember, String selectSort) throws SQLException {
        List<Object[]> resultList = new ArrayList<>();
        String member = "";
        String memberJoin ="";
        if (registedMember) {
            member = "    등록이용객.이름, ";
            memberJoin = "JOIN " +
                    "    등록이용객 ON 차량.회원ID = 등록이용객.회원ID " ;
        }

        String query =
                "SELECT " +
                        "    주차.차량번호, " +
                        member +
                        "    주차.경고누적수, "+
                        "    주차.불이익단계, "+
                        "    SUM(NVL(주차.출차일시, SYSDATE) - 주차.입차일시) AS 총이용시간 " +
                        "FROM " +
                        "    주차 " +
                        "JOIN " +
                        "    차량 ON 주차.차량번호 = 차량.차량번호 " +
                        memberJoin +
                        "GROUP BY " +
                        member +
                        "    주차.경고누적수, "+
                        "    주차.불이익단계, "+
                        "    주차.차량번호 " +
                        "ORDER BY " +
                        "    총이용시간 " + selectSort; //DESC, ASC

        DB_Conn dbConn = new DB_Conn();
        try (Connection conn = dbConn.getConnection()) {

            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                CarDTO car = new CarDTO();
                car.setCarNumber(rs.getString("차량번호"));
                car.setWarningCount(rs.getInt("경고누적수"));
                car.setPenaltyLevel(rs.getInt("불이익단계"));
                MemberDTO memberDTO = new MemberDTO();

                // 총 이용 시간 등 추가 데이터를 member나 car에 필요시 추가 가능
                double totalUsageTime = rs.getDouble("총이용시간");
                if (registedMember) {
                    memberDTO.setName(rs.getString("이름"));
                    resultList.add(new Object[]{car, member, totalUsageTime});
                } else {
                    resultList.add(new Object[]{car, totalUsageTime});
                }
            }
        } catch (SQLException e) {
            throw new SQLException("데이터 조회 중 오류 발생: " + e.getMessage(), e);
        }

        return resultList;
    }
}
