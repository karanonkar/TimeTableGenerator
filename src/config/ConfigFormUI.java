package config;

import admin.AdminData;
import form.SubjectInputForm;

import javax.swing.*;
import java.awt.*;

public class ConfigFormUI extends JFrame {

    public ConfigFormUI() {
        setTitle(" Timetable Configuration");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(9, 2, 10, 10));

       
        JTextField branchField = new JTextField();
        JTextField classField = new JTextField();
        JTextField subjectCountField = new JTextField();
        JTextField lectureCountField = new JTextField();
        JTextField firstLectureTimeField = new JTextField("09:00");
        JTextField lectureDurationField = new JTextField("50");
        JTextField lunchStartField = new JTextField("12:00");
        JTextField lunchEndField = new JTextField("12:50");

        
        add(new JLabel("Branch Name:"));
        add(branchField);

        add(new JLabel("Class Name:"));
        add(classField);

        add(new JLabel("No. of Subjects:"));
        add(subjectCountField);

        add(new JLabel("Lectures per Day:"));
        add(lectureCountField);

        add(new JLabel("First Lecture Time (HH:mm):"));
        add(firstLectureTimeField);

        add(new JLabel("Lecture Duration (min):"));
        add(lectureDurationField);

        add(new JLabel("Lunch Start Time (HH:mm):"));
        add(lunchStartField);

        add(new JLabel("Lunch End Time (HH:mm):"));
        add(lunchEndField);


        JButton submitBtn = new JButton("Save & Next");
        add(new JLabel()); 
        add(submitBtn);

        
        submitBtn.addActionListener(e -> {
            try {
                AdminData.branchName = branchField.getText().trim();
                AdminData.className = classField.getText().trim();
                AdminData.subjectCount = Integer.parseInt(subjectCountField.getText().trim());
                AdminData.maxLectures = Integer.parseInt(lectureCountField.getText().trim());
                AdminData.firstLectureTime = firstLectureTimeField.getText().trim();
                AdminData.lectureDuration = Integer.parseInt(lectureDurationField.getText().trim());
                AdminData.lunchStart = lunchStartField.getText().trim();
                AdminData.lunchEnd = lunchEndField.getText().trim();

                AdminData.generateTimeSlots(); 
                JOptionPane.showMessageDialog(this, " Configuration Saved!");

                dispose();
                new SubjectInputForm();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid input: " + ex.getMessage());
            }
        });

        setVisible(true);
    }
}
