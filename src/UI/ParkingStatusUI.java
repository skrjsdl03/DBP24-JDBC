package UI;

import javax.swing.*;
import java.awt.*;

public class ParkingStatusUI extends JPanel {

    public ParkingStatusUI(JPanel mainPanel) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // 오른쪽 콘텐츠 패널
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBackground(Color.WHITE);

        // 헤더 패널 생성
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.WHITE);
        JLabel titleLabel = new JLabel("주차장 현황", JLabel.LEFT);
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

        // 상태 표시 패널
        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.Y_AXIS));
        statusPanel.setBackground(Color.WHITE);
        statusPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        JLabel allParkingTitle = new JLabel("모든 주차장", JLabel.CENTER);
        allParkingTitle.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
        allParkingTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        statusPanel.add(allParkingTitle);

        statusPanel.add(Box.createRigidArea(new Dimension(0, 20))); // 간격 추가

        // 주차장 상태
        String[] parkingLots = {"A주차장", "B주차장", "C주차장", "D주차장"};
        String[] statuses = {"원활", "혼잡", "원활", "보통"};

        for (int i = 0; i < parkingLots.length; i++) {
            JPanel parkingRow = new JPanel();
            parkingRow.setLayout(new BoxLayout(parkingRow, BoxLayout.X_AXIS));
            parkingRow.setBackground(Color.WHITE);
            parkingRow.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel parkingLabel = new JLabel(parkingLots[i], JLabel.LEFT);
            parkingLabel.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
            parkingLabel.setPreferredSize(new Dimension(100, 30));
            parkingRow.add(parkingLabel);

            JLabel statusLabel = new JLabel(statuses[i], JLabel.LEFT);
            statusLabel.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
            parkingRow.add(statusLabel);

            statusPanel.add(parkingRow);
        }

        contentPanel.add(headerPanel, BorderLayout.NORTH);
        contentPanel.add(statusPanel, BorderLayout.CENTER);

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
