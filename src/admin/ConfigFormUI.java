package admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfigFormUI extends JFrame {

    private JTextField branchField, classField, daysField, maxLecturesField, lectureDurationField;
    private JTextField firstLectureTimeField, lunchStartField, lunchEndField;

    public ConfigFormUI() {
        setTitle("Configuration");
        setSize(500, 500);
        setLayout(new GridLayout(10, 2, 10, 10));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        branchField = new JTextField();
        classField = new JTextField();
        daysField = new JTextField();
        maxLecturesField = new JTextField();
        lectureDurationField = new JTextField();
        firstLectureTimeField = new JTextField();
        lunchStartField = new JTextField();
        lunchEndField = new JTextField();

        add(new JLabel("Branch Name:"));
        add(branchField);
        add(new JLabel("Class Name:"));
        add(classField);
        add(new JLabel("Total Days:"));
        add(daysField);
        add(new JLabel("Max Lectures per Day:"));
        add(maxLecturesField);
        add(new JLabel("Lecture Duration (minutes):"));
        add(lectureDurationField);
        add(new JLabel("First Lecture Start Time (e.g., 09:00):"));
        add(firstLectureTimeField);
        add(new JLabel("Lunch Start Time (e.g., 13:00):"));
        add(lunchStartField);
        add(new JLabel("Lunch End Time (e.g., 13:30):"));
        add(lunchEndField);

        JButton saveButton = new JButton("Save");
        add(new JLabel()); 
        add(saveButton);

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    AdminData.branch = branchField.getText().trim();
                    AdminData.className = classField.getText().trim();
                    AdminData.totalDays = Integer.parseInt(daysField.getText().trim());
                    AdminData.maxLectures = Integer.parseInt(maxLecturesField.getText().trim());
                    AdminData.lectureDuration = Integer.parseInt(lectureDurationField.getText().trim());
                    AdminData.firstLectureTime = firstLectureTimeField.getText().trim();
                    AdminData.lunchStart = lunchStartField.getText().trim();
                    AdminData.lunchEnd = lunchEndField.getText().trim();

                    JOptionPane.showMessageDialog(null, "Configuration Saved Successfully!");

                    dispose(); 
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Please enter valid data: " + ex.getMessage());
                }
            }
        });
    }
}
