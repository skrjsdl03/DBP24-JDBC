package UI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ManagementUI extends JPanel {

    public ManagementUI(JPanel mainPanel) {
        setLayout(new BorderLayout());

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

        JTextField searchField = new JTextField(15);
        addPlaceholder(searchField, "검색");

        JButton searchButton = createStyledButton("검색");
        searchButton.setPreferredSize(new Dimension(62, 30)); // 버튼 크기 설정
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        JButton filterButton = createStyledButton("Filter");
        filterButton.setPreferredSize(new Dimension(65, 30)); // 버튼 크기 설정
        searchPanel.add(filterButton);

        headerPanel.add(searchPanel, BorderLayout.EAST);

        // 데이터 테이블
        String[] columnNames = {"회원 ID", "이름", "연락처", "소속", "주소"};
        Object[][] data = {
                {"sdb123", "이민준", "010-7000-8327", "학생", "부산 부산진구 중앙대로123번길 15-9"},
                {"sdg325", "허민재", "010-2300-1234", "학생", "부산 부산진구 중앙대로123번길 15-9"},
                {"skd343", "이창건", "010-2900-5678", "교수", "부산 부산진구 배화123번길 15-9"}
        };

        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        JTable userTable = new JTable(tableModel);
        styleTable(userTable);

        JScrollPane tableScrollPane = new JScrollPane(userTable);
        tableScrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // 하단 회원 등록 버튼
        JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        footerPanel.setBackground(Color.WHITE);

        JButton addUserButton = new JButton("회원 등록");
        styleButton(addUserButton);
        footerPanel.add(addUserButton);

        // 콘텐츠 패널 구성
        contentPanel.add(headerPanel, BorderLayout.NORTH);
        contentPanel.add(tableScrollPane, BorderLayout.CENTER);
        contentPanel.add(footerPanel, BorderLayout.SOUTH);

        // 이벤트 리스너 추가
        addUserButton.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
            cardLayout.show(mainPanel, "MemberRegistrationUI"); // MemberRegistrationUI로 전환
        });

        filterButton.addActionListener(e -> applyFilter(columnNames, data, tableModel, userTable));

        // 콘텐츠 패널을 현재 패널에 추가
        add(contentPanel, BorderLayout.CENTER);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
        button.setPreferredSize(new Dimension(100, 30)); // 버튼 크기 설정
        return button;
    }

    private void styleButton(JButton button) {
        button.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
        button.setFocusPainted(false);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        button.setPreferredSize(new Dimension(100, 30));
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

    private void styleTable(JTable table) {
        table.setRowHeight(30);
        table.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("Malgun Gothic", Font.BOLD, 14));
        table.getTableHeader().setReorderingAllowed(false);
    }

    private void applyFilter(String[] columnNames, Object[][] data, DefaultTableModel tableModel, JTable userTable) {
        JCheckBox[] checkBoxes = new JCheckBox[columnNames.length];
        JPanel filterPanel = new JPanel(new GridLayout(columnNames.length, 1));
        for (int i = 0; i < columnNames.length; i++) {
            checkBoxes[i] = new JCheckBox(columnNames[i], true);
            filterPanel.add(checkBoxes[i]);
        }

        int result = JOptionPane.showConfirmDialog(this, filterPanel, "필터 선택", JOptionPane.OK_CANCEL_OPTION);
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
    }
}
