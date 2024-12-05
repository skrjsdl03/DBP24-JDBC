package UI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ParkingRecordUI extends JPanel {

    public ParkingRecordUI(JPanel mainPanel) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

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

        JTextField searchField = new JTextField(15);
        addPlaceholder(searchField, "검색");
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

        // 콘텐츠 패널을 현재 패널에 추가
        add(contentPanel, BorderLayout.CENTER);
    }

    private void addPlaceholder(JTextField textField, String placeholder) {
        textField.setText(placeholder);
        textField.setForeground(Color.GRAY);
        textField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                    textField.setForeground(Color.GRAY);
                }
            }
        });
    }
}
