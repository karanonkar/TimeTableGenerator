package main;

import admin.AdminPanel;
import teacher.TeacherTimetableUI;
import student.StudentDashboard;

import javax.swing.*;
import java.awt.*;

public class LoginUI extends JFrame {

    public LoginUI() {
        setTitle(" Login Panel");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1, 10, 10));

        JLabel heading = new JLabel("Select Your Role:");
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 18));
        add(heading);

        
        JButton adminBtn = new JButton("Admin Login");
        adminBtn.setFont(new Font("Arial", Font.PLAIN, 16));
        adminBtn.addActionListener(e -> {
            String user = JOptionPane.showInputDialog(this, "Enter Admin Username:");
            String pass = JOptionPane.showInputDialog(this, "Enter Admin Password:");
            if ("system".equalsIgnoreCase(user) && "bansal".equalsIgnoreCase(pass)) {
                new AdminPanel();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Admin Credentials");
            }
        });
        add(adminBtn);

        
        JButton teacherBtn = new JButton("Teacher Panel");
        teacherBtn.setFont(new Font("Arial", Font.PLAIN, 16));
        teacherBtn.addActionListener(e -> {
            new TeacherTimetableUI();
            dispose();
        });
        add(teacherBtn);

        
        JButton studentBtn = new JButton("Student Panel");
        studentBtn.setFont(new Font("Arial", Font.PLAIN, 16));
        studentBtn.addActionListener(e -> {
            String enrollment = JOptionPane.showInputDialog(this, "Enter Enrollment No:");
            String semester = JOptionPane.showInputDialog(this, "Enter Semester:");
            if (enrollment != null && semester != null) {
                new StudentDashboard(enrollment, semester).setVisible(true);
                dispose();
            }
        });
        add(studentBtn);

      
        JButton exitBtn = new JButton(" Exit");
        exitBtn.setFont(new Font("Arial", Font.PLAIN, 16));
        exitBtn.addActionListener(e -> System.exit(0));
        add(exitBtn);

        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginUI();
    }
}
