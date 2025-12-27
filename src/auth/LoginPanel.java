package auth;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import admin.*;

public class LoginPanel extends JFrame {

    public LoginPanel() {
        setTitle("Login Panel");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Select Role and Login"));

        JLabel roleLabel = new JLabel("Login as:");
        String[] roles = {"Admin", "Teacher", "Student"};
        JComboBox<String> roleBox = new JComboBox<>(roles);

        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();

        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();

        JButton loginBtn = new JButton("Login");

        panel.add(roleLabel);
        panel.add(roleBox);

        panel.add(userLabel);
        panel.add(userField);

        panel.add(passLabel);
        panel.add(passField);

        panel.add(new JLabel());
        panel.add(loginBtn);

        add(panel);

        loginBtn.addActionListener(e -> {
            String selectedRole = (String) roleBox.getSelectedItem();
            String user = userField.getText().trim();
            String pass = new String(passField.getPassword());

            if (selectedRole.equals("Admin")) {
                if (user.equals("system") && pass.equals("bansal")) {
                    this.dispose();
                    new AdminInputForm().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Admin Credentials!");
                }
            } else if (selectedRole.equals("Teacher")) {
                this.dispose();
                new TeacherView(user).setVisible(true);
            } else if (selectedRole.equals("Student")) {
                this.dispose();
                new StudentView(user).setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginPanel().setVisible(true));
    }
}
