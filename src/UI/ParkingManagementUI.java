package UI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ParkingManagementUI {
    public static void main(String[] args) {
        // 메인 프레임 생성
        JFrame frame = new JFrame("주차장 관리 시스템");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setLayout(new BorderLayout());

        // 전체 패널 생성 및 배경 색 설정
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);
        frame.add(mainPanel);

        // 왼쪽 메뉴바 패널 생성
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setPreferredSize(new Dimension(200, frame.getHeight()));
        menuPanel.setBackground(Color.WHITE);

        // 메뉴 제목 추가
        JLabel menuTitle = new JLabel("메뉴");
        menuTitle.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
        menuTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuTitle.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // 여백 추가
        menuPanel.add(menuTitle);

        // 메뉴 버튼 추가
        String[] menuItems = {"회원 정보", "주차장 관리 점검 기록", "주차요금 계산", "차량 입출차 기록", "주차장 현황"};
        for (String item : menuItems) {
            JButton menuButton = new JButton(item);
            menuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            menuButton.setFocusPainted(false);
            menuButton.setBackground(Color.WHITE);
            menuButton.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
            menuButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            menuButton.setPreferredSize(new Dimension(200, 40));
            menuButton.setMaximumSize(new Dimension(200, 40));

            // "주차장 관리 점검 기록" 버튼의 배경색을 회색으로 설정
            if (item.equals("주차장 관리 점검 기록")) {
                menuButton.setBackground(Color.LIGHT_GRAY);
            }

            // 메뉴 버튼 클릭 시 해당 UI 열기
            menuButton.addActionListener(e -> {
                frame.dispose();
                switch (item) {
                    case "회원 정보":
                        ManagementUI.show(); // 회원 정보 UI 호출
                        break;
                    case "주차장 관리 점검 기록":
                        show(); // 주차장 관리 점검 기록 UI 호출
                        break;
                    case "주차요금 계산":
                        ParkingFeeUI.show(); // 주차요금 계산 UI 호출
                        break;
                    case "차량 입출차 기록":
                        ParkingRecordUI.show(); // 차량 입출차 기록 UI 호출
                        break;
                    case "주차장 현황":
                        ParkingStatusUI.show(); // 주차장 현황 UI 호출
                        break;
                }
            });

            menuPanel.add(menuButton);
        }
        mainPanel.add(menuPanel, BorderLayout.WEST);

        // "주차장 관리 점검 기록" 패널 생성
        JPanel parkingInspectionPanel = createParkingInspectionPanel();
        mainPanel.add(parkingInspectionPanel, BorderLayout.CENTER);

        // 프레임 표시
        frame.setLocationRelativeTo(null); // 화면 중앙에 표시
        frame.setVisible(true);
    }

    private static JPanel createParkingInspectionPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // 제목 및 검색 영역
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel("주차장 관리 점검 기록");
        titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
        headerPanel.add(titleLabel, BorderLayout.WEST);

        // 검색 및 필터 패널
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        searchPanel.setBackground(Color.WHITE);

        JTextField searchField = new JTextField(15); // 크기 조정
        JButton searchButton = new JButton("검색");
        searchButton.setFocusPainted(false);
        searchButton.setBackground(Color.BLACK);
        searchButton.setForeground(Color.WHITE);

        JButton filterButton = new JButton("Filter");
        filterButton.setFocusPainted(false);
        filterButton.setBackground(Color.BLACK);
        filterButton.setForeground(Color.WHITE);

        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        searchPanel.add(filterButton);
        headerPanel.add(searchPanel, BorderLayout.EAST);

        panel.add(headerPanel, BorderLayout.NORTH);

        // 테이블 생성
        String[] columns = {"주차장 ID", "주차장 위치", "최대 이용자 수", "점검 등급", "점검 여부"};
        Object[][] data = {
                {"FIG-123", "A주차장", "50", "High", "Y"},
                {"FIG-122", "B주차장", "30", "Low", "N"},
                {"FIG-121", "C주차장", "20", "High", "Y"},
                {"FIG-120", "D주차장", "40", "Low", "Y"}
        };

        JTable table = new JTable(new DefaultTableModel(data, columns));
        table.setRowHeight(30);
        table.getTableHeader().setFont(new Font("맑은 고딕", Font.BOLD, 12));
        table.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        JScrollPane tableScrollPane = new JScrollPane(table);

        panel.add(tableScrollPane, BorderLayout.CENTER);

        // 버튼 영역
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(Color.WHITE);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

    public static void show() {
        main(new String[0]); // 메인 메서드 호출
    }
}
