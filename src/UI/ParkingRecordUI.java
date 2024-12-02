package UI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ParkingRecordUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ParkingRecordUI().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("주차장 관리 시스템");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setLayout(new BorderLayout());

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

            if (item.equals("차량 입출차 기록")) {
                menuButton.setBackground(Color.LIGHT_GRAY);
            }

            // 메뉴 버튼 클릭 시 해당 UI 열기
            menuButton.addActionListener(e -> {
                frame.dispose();
                switch (item) {
                    case "회원 정보":
                        GUI.ManagementUI.show(); // 회원 정보 UI 호출
                        break;
                    case "주차장 관리 점검 기록":
                        ParkingManagementUI.show(); // 주차장 관리 점검 기록 UI 호출
                        break;
                    case "주차요금 계산":
                        ParkingFeeUI.show(); // 주차요금 계산 UI 호출
                        break;
                    case "차량 입출차 기록":
                        show(); // 현재 UI 호출
                        break;
                    case "주차장 현황":
                        ParkingStatusUI.show(); // 주차장 현황 UI 호출
                        break;
                }
            });

            menuPanel.add(menuButton);
        }

        // 오른쪽 콘텐츠 패널
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBackground(Color.WHITE);

        // 헤더 패널 생성
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.WHITE);
        JLabel titleLabel = new JLabel("차량 입/출차 기록", JLabel.LEFT);
        titleLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 16));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        headerPanel.add(titleLabel, BorderLayout.WEST);

        // 검색 및 필터 패널
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        searchPanel.setBackground(Color.WHITE);

        JTextField searchField = new JTextField(15); // 크기 조정
        searchField.setText("검색");
        searchField.setForeground(Color.GRAY);
        searchField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (searchField.getText().equals("검색")) {
                    searchField.setText("");
                    searchField.setForeground(Color.BLACK);
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (searchField.getText().isEmpty()) {
                    searchField.setText("검색");
                    searchField.setForeground(Color.GRAY);
                }
            }
        });
        searchPanel.add(searchField);

        // 검색 버튼 추가
        JButton searchButton = new JButton("검색");
        searchButton.setFocusPainted(false);
        searchButton.setBackground(Color.BLACK);
        searchButton.setForeground(Color.WHITE);
        searchPanel.add(searchButton);

        // 필터 버튼 추가
        JButton filterButton = new JButton("Filter");
        filterButton.setBackground(Color.BLACK);
        filterButton.setForeground(Color.WHITE);
        filterButton.setFocusPainted(false);
        searchPanel.add(filterButton);

        headerPanel.add(searchPanel, BorderLayout.EAST); // 오른쪽에 위치하도록 설정

        // 표 데이터와 컬럼 이름 정의
        String[] columnNames = {"회원ID", "차량번호", "입차시간", "주차장 번호", "주차장 공간 번호"};
        Object[][] data = {
                {"A001", "35가 3872", "24/09/24 09:24:00", "A주차장", "13"},
                {"A001", "35가 3872", "24/10/22 10:14:00", "A주차장", "2"},
                {"A001", "35가 3872", "24/10/28 12:14:00", "C주차장", "22"},
                {"A001", "35가 3872", "24/11/02 15:14:00", "B주차장", "12"}
        };

        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable parkingTable = new JTable(tableModel);
        parkingTable.setRowHeight(30);
        parkingTable.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
        parkingTable.getTableHeader().setFont(new Font("Malgun Gothic", Font.BOLD, 14));
        parkingTable.getTableHeader().setReorderingAllowed(false);

        JScrollPane tableScrollPane = new JScrollPane(parkingTable);
        tableScrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        contentPanel.add(headerPanel, BorderLayout.NORTH);
        contentPanel.add(tableScrollPane, BorderLayout.CENTER);

        // 프레임에 메뉴 패널과 콘텐츠 패널 추가
        frame.add(menuPanel, BorderLayout.WEST);
        frame.add(contentPanel, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void show() {
        main(new String[0]); // 메인 메서드 호출
    }
}
