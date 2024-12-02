package UI;

import javax.swing.*;
import java.awt.*;

public class ParkingLotStatusUI {
    public static void show() {
        JFrame frame = new JFrame("주차장 관리 시스템");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setLayout(new BorderLayout());

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setPreferredSize(new Dimension(200, frame.getHeight()));
        menuPanel.setBackground(Color.WHITE);

        String[] menuItems = {"회원 정보", "주차장 관리 점검 기록", "주차요금 계산", "차량 입출차 기록", "주차장 현황"};
//        for (String item : menuItems) {
//            JButton menuButton = new JButton(item);
//            menuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
//            menuButton.setFocusPainted(false);
//            menuButton.setBackground(Color.WHITE);
//            menuButton.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
//            menuButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
//            menuButton.addActionListener(e -> {
//                frame.dispose();
//                switch (item) {
//                    case "회원 정보":
//                        MemberRegistrationUI.show();
//                        break;
//                    case "주차장 관리 점검 기록":
//                        ParkingManagementUI.show();
//                        break;
//                    case "주차요금 계산":
//                        ParkingFeeUI.show();
//                        break;
//                    case "차량 입출차 기록":
//                        ParkingRecordUI.show();
//                        break;
//                }
//            });
//            menuPanel.add(menuButton);
//        }

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBackground(Color.WHITE);

        // 주차장 현황 UI 코드 (생략)...

        frame.setVisible(true);
    }
}
