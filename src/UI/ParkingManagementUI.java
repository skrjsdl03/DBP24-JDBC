package UI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ParkingManagementUI extends JPanel {

    public ParkingManagementUI(JPanel mainPanel) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // "주차장 관리 점검 기록" 패널 생성
        JPanel parkingInspectionPanel = createParkingInspectionPanel();
        add(parkingInspectionPanel, BorderLayout.CENTER);
    }

    private JPanel createParkingInspectionPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // 제목 및 검색 영역
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel("주차장 관리 점검 기록", JLabel.LEFT);
        titleLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 18));
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
}
