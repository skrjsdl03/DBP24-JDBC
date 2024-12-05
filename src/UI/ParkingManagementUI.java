package UI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

public class ParkingManagementUI extends JPanel {

    private DefaultTableModel tableModel;
    private JTable inspectionTable;
    private String[] columnNames = {"주차장 ID", "주차장 위치", "최대 이용자 수", "점검 등급", "점검 여부"};
    private Object[][] data = {
            {"FIG-123", "A주차장", "50", "High", "Y"},
            {"FIG-122", "B주차장", "30", "Low", "N"},
            {"FIG-121", "C주차장", "20", "High", "Y"},
            {"FIG-120", "D주차장", "40", "Low", "Y"}
    };

    public ParkingManagementUI(JPanel mainPanel) {
        setLayout(new BorderLayout());

        // 콘텐츠 영역
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(Color.WHITE);

        // 헤더
        JPanel headerPanel = createHeaderPanel(mainPanel);
        contentPanel.add(headerPanel, BorderLayout.NORTH);

        // 테이블 생성
        tableModel = new DefaultTableModel(data, columnNames);
        inspectionTable = new JTable(tableModel);
        inspectionTable.setRowHeight(30);
        inspectionTable.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
        inspectionTable.getTableHeader().setFont(new Font("Malgun Gothic", Font.BOLD, 14));
        inspectionTable.getTableHeader().setReorderingAllowed(false);

        JScrollPane tableScrollPane = new JScrollPane(inspectionTable);
        tableScrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        contentPanel.add(tableScrollPane, BorderLayout.CENTER);

        add(contentPanel, BorderLayout.CENTER);
    }

    private JPanel createHeaderPanel(JPanel mainPanel) {
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel("주차장 관리 점검 기록", JLabel.LEFT);
        titleLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 16));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        headerPanel.add(titleLabel, BorderLayout.WEST);

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 5));
        searchPanel.setBackground(Color.WHITE);

        JTextField searchField = new JTextField(15);
        addPlaceholder(searchField, "검색");
        searchPanel.add(searchField);

        JButton searchButton = createStyledButton("검색");
        searchPanel.add(searchButton);

        JButton filterButton = createStyledButton("Filter");
        filterButton.addActionListener(e -> applyFilter());
        searchPanel.add(filterButton);

        headerPanel.add(searchPanel, BorderLayout.EAST);
        return headerPanel;
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFocusPainted(false);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        return button;
    }

    private void addPlaceholder(JTextField textField, String placeholder) {
        textField.setText(placeholder);
        textField.setForeground(Color.GRAY);
        textField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                    textField.setForeground(Color.GRAY);
                }
            }
        });
    }

    private void applyFilter() {
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
            inspectionTable.setModel(newModel);
        }
    }
}
