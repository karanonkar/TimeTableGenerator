package teacher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TeacherLogin extends JFrame {
    private JTextField nameField;

    public TeacherLogin() {
        setTitle("Teacher Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(2, 2, 5, 5));
        panel.add(new JLabel("Enter Name:"));
        nameField = new JTextField();
        panel.add(nameField);

        JButton loginButton = new JButton("Login");
        panel.add(loginButton);

        add(panel);

        loginButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            if (!name.isEmpty()) {
                new TeacherDashboard(name).setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Please enter your name.");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TeacherLogin().setVisible(true));
    }
}
