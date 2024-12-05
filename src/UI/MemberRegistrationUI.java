package UI;

import DTO.MemberDTO;
import DAO.MemberDAO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.text.SimpleDateFormat;

public class MemberRegistrationUI extends JPanel {

    public MemberRegistrationUI(JPanel mainPanel) {
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("회원 등록하기");
        titleLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 24));
        titleLabel.setBorder(new EmptyBorder(20, 20, 20, 20));
        add(titleLabel, BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(8, 2, 10, 10));
        formPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        String[] labels = {"회원 ID", "이름", "생년월일 (yyyy-MM-dd)", "연락처", "소속", "소속번호", "주소", "이용형태"};
        JTextField[] fields = new JTextField[labels.length];

        for (int i = 0; i < labels.length; i++) {
            JLabel label = new JLabel(labels[i]);
            label.setFont(new Font("Malgun Gothic", Font.BOLD, 16));

            JTextField field = new JTextField();
            fields[i] = field;

            formPanel.add(label);
            formPanel.add(field);
        }
        add(formPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.WHITE);

        JButton registerButton = new JButton("회원 등록");
        registerButton.setFont(new Font("Malgun Gothic", Font.BOLD, 16));
        registerButton.setBackground(Color.BLACK);
        registerButton.setForeground(Color.WHITE);
        buttonPanel.add(registerButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // 회원 등록 버튼 동작
        registerButton.addActionListener(e -> {
            try {
                MemberDTO memberDTO = new MemberDTO();
                memberDTO.setMemberId(fields[0].getText());
                memberDTO.setName(fields[1].getText());

                String birthDateStr = fields[2].getText();
                if (!birthDateStr.isEmpty()) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    memberDTO.setBirthDate(sdf.parse(birthDateStr));
                }

                memberDTO.setPhone(fields[3].getText());
                memberDTO.setAffiliation(fields[4].getText());
                memberDTO.setAffiliationNumber(fields[5].getText());
                memberDTO.setAddress(fields[6].getText());
                memberDTO.setUsageType(fields[7].getText());

                MemberDAO memberDAO = new MemberDAO();
                String message = memberDAO.registerMember(memberDTO);

                JOptionPane.showMessageDialog(this, message);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "회원 등록에 실패했습니다: " + ex.getMessage());
            }
        });

        JButton backButton = new JButton("뒤로가기");
        backButton.setFont(new Font("Malgun Gothic", Font.BOLD, 16));
        backButton.setBackground(Color.GRAY);
        backButton.setForeground(Color.WHITE);
        buttonPanel.add(backButton);

        // 뒤로 가기 버튼 동작
        backButton.addActionListener(e -> {
            CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
            cardLayout.show(mainPanel, "ManagementUI"); // ManagementUI로 전환
        });

    }
}
