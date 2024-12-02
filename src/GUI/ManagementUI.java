package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ManagementUI {

    public static void show() {
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

        // 회원 정보 버튼 생성 및 배경색 설정
        JButton memberInfoButton = new JButton("회원 정보");
        memberInfoButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        memberInfoButton.setFocusPainted(false);
        memberInfoButton.setBackground(Color.LIGHT_GRAY);
        memberInfoButton.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
        memberInfoButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        memberInfoButton.setPreferredSize(new Dimension(200, 40));
        memberInfoButton.setMaximumSize(new Dimension(200, 40));
        menuPanel.add(memberInfoButton);

        // 회원 정보 버튼 클릭 시 ManagementUI 열기
        memberInfoButton.addActionListener(e -> {
            frame.dispose();
            ManagementUI.show();
        });

        // 다른 메뉴 항목 버튼 생성
        String[] menuItems = {
                "주차장 관리 점검 기록",
                "주차요금 계산",
                "차량 입출차 기록",
                "주차장 현황"
        };

        Class<?>[] uiClasses = {
                ParkingManagementUI.class,
                ParkingFeeUI.class,
                ParkingRecordUI.class,
                ParkingStatusUI.class
        };

        for (int i = 0; i < menuItems.length; i++) {
            String item = menuItems[i];
            JButton menuButton = new JButton(item);
            menuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            menuButton.setFocusPainted(false);
            menuButton.setBackground(Color.WHITE);
            menuButton.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
            menuButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            menuButton.setPreferredSize(new Dimension(200, 40));
            menuButton.setMaximumSize(new Dimension(200, 40));

            final int index = i;

            // 메뉴 버튼 클릭 시 해당 UI 열기
            menuButton.addActionListener(e -> {
                try {
                    frame.dispose();
                    uiClasses[index].getMethod("show").invoke(null);
                } catch (Exception ex) {
                    ex.printStackTrace();
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
        JLabel titleLabel = new JLabel("회원 정보", JLabel.LEFT);
        titleLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 16));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        headerPanel.add(titleLabel, BorderLayout.WEST);

        // 검색 및 필터 패널
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        searchPanel.setBackground(Color.WHITE);

        JTextField searchField = new JTextField(20);
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

        JButton filterButton = new JButton("Filter");
        filterButton.setBackground(Color.BLACK);
        filterButton.setForeground(Color.WHITE);
        filterButton.setFocusPainted(false);
        searchPanel.add(filterButton);

        headerPanel.add(searchPanel, BorderLayout.EAST);

        // 표 데이터와 컬럼 이름 정의
        String[] columnNames = {"회원 ID", "이름", "연락처", "소속", "주소"};
        Object[][] data = {
                {"sdb123", "이민준", "010-7000-8327", "학생", "부산 부산진구 중앙대로123번길 15-9"},
                {"sdg325", "허민재", "010-2300-1234", "학생", "부산 부산진구 중앙대로123번길 15-9"},
                {"skd343", "이창건", "010-2900-5678", "교수", "부산 부산진구 배화123번길 15-9"}
        };

        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable userTable = new JTable(tableModel);
        userTable.setRowHeight(30);
        userTable.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
        userTable.getTableHeader().setFont(new Font("Malgun Gothic", Font.BOLD, 14));
        userTable.getTableHeader().setReorderingAllowed(false);

        JScrollPane tableScrollPane = new JScrollPane(userTable);
        tableScrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        contentPanel.add(headerPanel, BorderLayout.NORTH);
        contentPanel.add(tableScrollPane, BorderLayout.CENTER);

        // 하단 회원 등록 버튼 패널
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        footerPanel.setBackground(Color.WHITE);

        JButton addUserButton = new JButton("회원 등록");
        addUserButton.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
        addUserButton.setFocusPainted(false);
        addUserButton.setBackground(Color.BLACK);
        addUserButton.setForeground(Color.WHITE);
        addUserButton.setPreferredSize(new Dimension(150, 40));
        footerPanel.add(addUserButton);

        contentPanel.add(footerPanel, BorderLayout.SOUTH);

        addUserButton.addActionListener(e -> {
            frame.dispose();
            MemberRegistrationUI.show();
        });

        // Filter 버튼 동작 추가
        filterButton.addActionListener(e -> {
            JCheckBox[] checkBoxes = new JCheckBox[columnNames.length];
            JPanel filterPanel = new JPanel(new GridLayout(columnNames.length, 1));
            for (int i = 0; i < columnNames.length; i++) {
                checkBoxes[i] = new JCheckBox(columnNames[i], true);
                filterPanel.add(checkBoxes[i]);
            }

            int result = JOptionPane.showConfirmDialog(frame, filterPanel, "필터 선택", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                ArrayList<Integer> selectedColumns = new ArrayList<>();
                for (int i = 0; i < checkBoxes.length; i++) {
                    if (checkBoxes[i].isSelected()) {
                        selectedColumns.add(i);
                    }
                }

                DefaultTableModel newModel = new DefaultTableModel();
                for (int colIndex : selectedColumns) {
                    newModel.addColumn(columnNames[colIndex]);
                }

                for (Object[] row : data) {
                    Object[] filteredRow = new Object[selectedColumns.size()];
                    for (int i = 0; i < selectedColumns.size(); i++) {
                        filteredRow[i] = row[selectedColumns.get(i)];
                    }
                    newModel.addRow(filteredRow);
                }
                userTable.setModel(newModel);
            }
        });

        frame.add(menuPanel, BorderLayout.WEST);
        frame.add(contentPanel, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
