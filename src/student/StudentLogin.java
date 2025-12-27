package student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentLogin extends JFrame {
    private JTextField enrollmentField;
    private JComboBox<String> semesterBox;

    public StudentLogin() {
        setTitle("Student Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));

        panel.add(new JLabel("Enrollment No:"));
        enrollmentField = new JTextField();
        panel.add(enrollmentField);

        panel.add(new JLabel("Semester:"));
        semesterBox = new JComboBox<>();
        for (int i = 1; i <= 8; i++) semesterBox.addItem("Semester " + i);
        panel.add(semesterBox);

        JButton loginBtn = new JButton("Login");
        panel.add(loginBtn);

        add(panel);

        loginBtn.addActionListener(e -> {
            String enroll = enrollmentField.getText().trim();
            String semester = (String) semesterBox.getSelectedItem();

            if (!enroll.isEmpty()) {
                new StudentDashboard(enroll, semester).setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Please enter Enrollment Number.");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentLogin().setVisible(true));
    }
}
