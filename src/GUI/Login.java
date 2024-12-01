package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Login {
    public static void main(String[] args) {
        // Set UTF-8 encoding and Korean font
        UIManager.put("Label.font", new Font("Malgun Gothic", Font.PLAIN, 14));
        UIManager.put("Button.font", new Font("Malgun Gothic", Font.PLAIN, 14));
        UIManager.put("TextField.font", new Font("Malgun Gothic", Font.PLAIN, 14));

        SwingUtilities.invokeLater(() -> new Login().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("DEU 주차장 시스템");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(360, 400);
        frame.setLayout(null);

        // Set the background color of the frame to white
        frame.getContentPane().setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel("DEU 주차장 시스템", JLabel.CENTER);
        titleLabel.setBounds(0, 30, 350, 30);
        titleLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 25));
        titleLabel.setForeground(Color.BLACK);
        frame.add(titleLabel);

        JLabel loginLabel = new JLabel("Login", JLabel.CENTER);
        loginLabel.setBounds(0, 110, 350, 25);
        loginLabel.setFont(new Font("Malgun Gothic", Font.BOLD, 20));
        frame.add(loginLabel);

        // ID Label
        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(50, 140, 250, 20);
        idLabel.setFont(new Font("Malgun Gothic", Font.PLAIN, 12));
        frame.add(idLabel);

        // ID Text Field with Placeholder
        JTextField idField = new JTextField("ID");
        idField.setBounds(50, 160, 250, 40);
        idField.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
        idField.setForeground(Color.GRAY);
        addPlaceholderBehavior(idField, "ID");
        frame.add(idField);

        // Password Label
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 210, 250, 20);
        passwordLabel.setFont(new Font("Malgun Gothic", Font.PLAIN, 12));
        frame.add(passwordLabel);

        // Password Field with Placeholder
        JPasswordField passwordField = new JPasswordField("Password");
        passwordField.setBounds(50, 230, 250, 40);
        passwordField.setFont(new Font("Malgun Gothic", Font.PLAIN, 14));
        passwordField.setForeground(Color.GRAY);
        addPlaceholderBehavior(passwordField, "Password");
        frame.add(passwordField);

        JButton signInButton = new JButton("로그인");
        signInButton.setBounds(50, 290, 250, 40);
        signInButton.setFont(new Font("Malgun Gothic", Font.PLAIN, 15));
        signInButton.setBackground(Color.BLACK);
        signInButton.setForeground(Color.WHITE);
        signInButton.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        signInButton.setFocusPainted(false);
        signInButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Add action listener to the sign-in button
        signInButton.addActionListener(e -> {
            frame.dispose(); // Close the login frame
            new ManagementUI(); // Open the Management UI
        });

        // Add hover effect to button
        signInButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                signInButton.setBackground(Color.DARK_GRAY);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                signInButton.setBackground(Color.BLACK);
            }
        });

        frame.add(signInButton);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Method to add placeholder behavior to text fields
    private static void addPlaceholderBehavior(JTextField textField, String placeholder) {
        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setForeground(Color.GRAY);
                    textField.setText(placeholder);
                }
            }
        });
    }
}
