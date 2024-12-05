package UI;

import javax.swing.*;
import java.awt.*;

public class MainUI {
    public MainUI() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("주차장 관리 시스템");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setLayout(new BorderLayout());

        // 메인 패널에 CardLayout 사용
        JPanel mainPanel = new JPanel(new CardLayout());

        // 각 UI 패널 생성 후 메인 패널에 추가
        ManagementUI managementUI = new ManagementUI(mainPanel); // 회원 정보 UI
        mainPanel.add(managementUI, "ManagementUI");

        ParkingFeeUI parkingFeeUI = new ParkingFeeUI(mainPanel); // 주차요금 계산 UI
        mainPanel.add(parkingFeeUI, "ParkingFeeUI");

        ParkingManagementUI parkingManagementUI = new ParkingManagementUI(mainPanel); // 주차장 관리 점검 기록 UI
        mainPanel.add(parkingManagementUI, "ParkingManagementUI");

        ParkingRecordUI parkingRecordUI = new ParkingRecordUI(mainPanel); // 차량 입출차 기록 UI
        mainPanel.add(parkingRecordUI, "ParkingRecordUI");

        ParkingStatusUI parkingStatusUI = new ParkingStatusUI(mainPanel); // 주차장 현황 UI
        mainPanel.add(parkingStatusUI, "ParkingStatusUI");

        // 회원 등록 UI 추가
        MemberRegistrationUI memberRegistrationUI = new MemberRegistrationUI(mainPanel); // 회원 등록 UI
        mainPanel.add(memberRegistrationUI, "MemberRegistrationUI");

        // 왼쪽 메뉴 패널 생성
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

        // 메뉴 항목 정의
        String[] menuItems = {
                "회원 정보",
                "주차장 관리 점검 기록",
                "주차요금 계산",
                "차량 입출차 기록",
                "주차장 현황"
        };

        // 각 메뉴 항목에 대해 버튼을 생성
        for (String item : menuItems) {
            JButton menuButton = new JButton(item);
            menuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            menuButton.setFocusPainted(false);
            menuButton.setBackground(Color.WHITE);
            menuButton.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
            menuButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            menuButton.setPreferredSize(new Dimension(200, 40));

            // 메뉴 버튼 클릭 시 해당 UI를 카드 레이아웃에서 전환하여 보여주기
            menuButton.addActionListener(e -> {
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                switch (item) {
                    case "회원 정보":
                        cardLayout.show(mainPanel, "ManagementUI");
                        break;
                    case "주차장 관리 점검 기록":
                        cardLayout.show(mainPanel, "ParkingManagementUI");
                        break;
                    case "주차요금 계산":
                        cardLayout.show(mainPanel, "ParkingFeeUI");
                        break;
                    case "차량 입출차 기록":
                        cardLayout.show(mainPanel, "ParkingRecordUI");
                        break;
                    case "주차장 현황":
                        cardLayout.show(mainPanel, "ParkingStatusUI");
                        break;
                }
            });

            // 메뉴 패널에 버튼을 추가
            menuPanel.add(menuButton);
        }

        // 프레임에 메뉴 패널과 메인 패널 추가
        frame.add(menuPanel, BorderLayout.WEST);
        frame.add(mainPanel, BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
