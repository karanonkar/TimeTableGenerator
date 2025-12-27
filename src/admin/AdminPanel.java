package admin;

import generator.TimetableGeneratorUI;
import generator.TimetablePreviewUI;

import admin.AdminInputForm;

import teacher.TeacherTimetableUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AdminPanel extends JFrame {

    public AdminPanel() {
        setTitle(" Admin Dashboard");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1, 10, 10));

        
        JButton generateButton = new JButton("Generate Timetable");
        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AdminInputForm(); 
                dispose(); 
            }
        });
        add(generateButton);
        
        JButton teacherBtn = new JButton(" View Teacher Timetable");
        teacherBtn.setFont(new Font("Arial", Font.PLAIN, 16));
        teacherBtn.addActionListener(e -> new TeacherTimetableUI());
        add(teacherBtn);

       
        JButton previewBtn = new JButton(" Preview Full Timetable");
        previewBtn.setFont(new Font("Arial", Font.PLAIN, 16));
        previewBtn.addActionListener(e -> new TimetablePreviewUI());
        add(previewBtn);

        

 
        JButton exitBtn = new JButton(" Logout / Exit");
        exitBtn.setFont(new Font("Arial", Font.PLAIN, 16));
        exitBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Logging out...");
            dispose();
        });
        add(exitBtn);

        setVisible(true);
    }
}
