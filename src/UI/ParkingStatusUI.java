package UI;

import DB.DB_Conn; // DB 연결을 위한 클래스
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParkingStatusUI extends JPanel {

    public ParkingStatusUI(JPanel mainPanel) {
        setLayout(null); // 절대 위치 배치를 위해 null로 설정
        setBackground(Color.WHITE);

        // 헤더 패널 생성
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.WHITE);
        JLabel titleLabel = new JLabel("주차장 현황", JLabel.LEFT);
        titleLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 16));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        headerPanel.add(titleLabel, BorderLayout.WEST);
        headerPanel.setBounds(20, 10, 300, 40); // 헤더 패널 위치 설정

        // "모든 주차장" 텍스트 패널 생성
        JPanel allParkingPanel = new JPanel();
        allParkingPanel.setBackground(Color.WHITE);
        JLabel allParkingLabel = new JLabel("모든 주차장", JLabel.CENTER);
        allParkingLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
        allParkingLabel.setForeground(Color.BLACK);
        allParkingPanel.add(allParkingLabel);
        allParkingPanel.setBounds(250, 70, 300, 40); // 위치 조정

        // 상태 표시 패널
        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new GridLayout(0, 3, 10, 10)); // 3열로 구성
        statusPanel.setBackground(Color.WHITE);
        statusPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        statusPanel.setBounds(20, 100, 750, 400); // 위치 및 크기 조정

        // 주차장 상태 데이터 가져오기
        loadParkingStatus(statusPanel);

        // 콘텐츠 패널에 추가
        add(headerPanel);
        add(allParkingPanel);
        add(statusPanel);
    }

    private void loadParkingStatus(JPanel statusPanel) {
        String query = "SELECT p.주차장위치, p.수용가능차량수 - COUNT(w.차량번호) AS 남은주차공간, p.수용가능차량수 " +
                "FROM 동의대주차장 p " +
                "LEFT JOIN 주차 w ON p.주차장ID = w.주차장ID " +
                "GROUP BY p.주차장위치, p.수용가능차량수";

        DB_Conn dbConn = new DB_Conn(); // DB_Conn 객체 생성
        dbConn.DB_Connect(); // 데이터베이스 연결

        try (Connection conn = dbConn.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String parkingLocation = rs.getString("주차장위치");
                int remainingSpaces = rs.getInt("남은주차공간");
                int totalCapacity = rs.getInt("수용가능차량수");

                // 색상 결정
                Color buttonColor;
                if (remainingSpaces >= (2.0 / 3.0) * totalCapacity) {
                    buttonColor = Color.GREEN;
                } else if (remainingSpaces <= (1.0 / 4.0) * totalCapacity) {
                    buttonColor = Color.RED;
                } else {
                    buttonColor = Color.ORANGE;
                }

                // 주차장 버튼 생성
                JButton parkingButton = new JButton(parkingLocation + " [남은 자리: " + remainingSpaces + "]");
                parkingButton.setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
                parkingButton.setBackground(buttonColor);
                parkingButton.setForeground(Color.BLACK);
                parkingButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                parkingButton.setPreferredSize(new Dimension(200, 30));

                // 버튼을 패널에 추가
                JPanel parkingRow = new JPanel();
                parkingRow.setLayout(new BoxLayout(parkingRow, BoxLayout.Y_AXIS)); // 세로로 배치
                parkingRow.setBackground(Color.WHITE);
                parkingRow.setAlignmentX(Component.CENTER_ALIGNMENT);
                parkingRow.add(parkingButton);

                statusPanel.add(parkingRow);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "주차장 정보를 불러오는 데 실패했습니다.");
        } finally {
            dbConn.closeConnection(); // 데이터베이스 연결 종료
        }
    }
}
