package UI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MemberRegistrationUI {
    public static void show() {
        JFrame frame = new JFrame("회원 등록");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setLayout(new BorderLayout());

        // 좌측 메뉴 패널
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setPreferredSize(new Dimension(200, frame.getHeight()));
        menuPanel.setBackground(Color.WHITE);

        // 메뉴 제목 추가
        JLabel menuTitle = new JLabel("메뉴");
        menuTitle.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
        menuTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        menuTitle.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        menuPanel.add(menuTitle);

        // 메뉴 항목 버튼 정의
        String[] menuItems = {"회원 정보", "주차장 관리 점검 기록", "주차요금 계산", "차량 입출차 기록", "주차장 현황"};
        Class<?>[] uiClasses = {
                ManagementUI.class,
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
            menuButton.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
            menuButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            menuButton.setPreferredSize(new Dimension(200, 40));
            menuButton.setMaximumSize(new Dimension(200, 40));

            // `회원 정보` 버튼은 밝은 회색 배경색 지정
            if (item.equals("회원 정보")) {
                menuButton.setBackground(Color.LIGHT_GRAY);
            } else {
                menuButton.setBackground(Color.WHITE);
            }

            final int index = i;
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

        frame.add(menuPanel, BorderLayout.WEST);

        // 메인 콘텐츠 패널
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(Color.WHITE);
        frame.add(contentPanel, BorderLayout.CENTER);

        // 헤더 패널
        JLabel titleLabel = new JLabel("회원 등록하기");
        titleLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 24));
        titleLabel.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPanel.add(titleLabel, BorderLayout.NORTH);

        // 회원 등록 폼
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 10)); // 3행 2열로 설정
        formPanel.setBackground(Color.WHITE);

        String[] labels = {"회원 ID", "이름", "생년월일", "연락처", "주소", "소속"};
        for (String label : labels) {
            JPanel fieldPanel = new JPanel(new BorderLayout()); // 각 필드를 위한 패널
            fieldPanel.setBackground(Color.WHITE); // 흰색 배경

            JLabel fieldLabel = new JLabel(label);
            fieldLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 16));
            JTextField textField = new JTextField();
            textField.setFont(new Font("Malgun Gothic", Font.PLAIN, 16));
            textField.setPreferredSize(new Dimension(150, 25)); // 텍스트 필드의 크기

            fieldPanel.add(fieldLabel, BorderLayout.NORTH); // 레이블을 위에 배치
            fieldPanel.add(textField, BorderLayout.CENTER); // 텍스트 필드를 아래에 배치

            // 패널 크기 조정
            fieldPanel.setPreferredSize(new Dimension(400, 50)); // 각 필드 패널의 크기 조정

            formPanel.add(fieldPanel); // 폼에 추가
        }

        contentPanel.add(formPanel, BorderLayout.CENTER);

        // 하단 버튼 패널
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.WHITE);

        JButton registerButton = new JButton("회원 등록");
        registerButton.setFont(new Font("Malgun Gothic", Font.BOLD, 16));
        registerButton.setBackground(Color.BLACK);
        registerButton.setForeground(Color.WHITE);
        registerButton.setPreferredSize(new Dimension(150, 40));
        buttonPanel.add(registerButton);

        contentPanel.add(buttonPanel, BorderLayout.SOUTH);

        // 프레임 표시
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
