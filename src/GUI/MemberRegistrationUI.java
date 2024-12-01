package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MemberRegistrationUI {
    public static void show() {
        JFrame frame = new JFrame("회원 등록");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);
        frame.add(mainPanel);

        JPanel menuPanel = new JPanel(new GridLayout(0, 1, 10, 10));
        menuPanel.setBackground(Color.WHITE);
        menuPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        String[] menuItems = {"회원 정보", "주차장 관리 점검 기록", "주차요금 계산", "차량 입출차 기록", "주차장 현황"};
//        for (String item : menuItems) {
//            JButton menuButton = new JButton(item);
//            menuButton.setFocusPainted(false);
//            menuButton.setBackground(Color.WHITE);
//            menuButton.setHorizontalAlignment(SwingConstants.LEFT);
//            menuButton.addActionListener(e -> {
//                frame.dispose();
//                switch (item) {
//                    case "주차장 관리 점검 기록":
//                        ParkingManagementUI.show();
//                        break;
//                    case "주차요금 계산":
//                        ParkingFeeUI.show();
//                        break;
//                    case "차량 입출차 기록":
//                        ParkingRecordUI.show();
//                        break;
//                    case "주차장 현황":
//                        ParkingStatusUI.show();
//                        break;
//                }
//            });
//            menuPanel.add(menuButton);
//        }
        mainPanel.add(menuPanel, BorderLayout.WEST);

        // 회원 등록 패널 생성 코드 (생략)...

        frame.setVisible(true);
    }
}
