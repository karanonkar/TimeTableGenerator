package teacher;

import javax.swing.*;
import java.awt.*;

public class TeacherDashboard extends JFrame {
    private String teacherName;

    public TeacherDashboard(String name) {
        this.teacherName = name;

        setTitle("Welcome " + teacherName);
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        
        JTextArea timetableArea = new JTextArea();
        timetableArea.setEditable(false);
        timetableArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        timetableArea.setText("Time Table for " + teacherName + ":\n\n" +
                "Mon: 10:00 AM - CSE101 - Room 201\n" +
                "Tue: 12:00 PM - CSE102 - Room 105\n" +
                "Wed: 11:00 AM - CSE103 - Room 202\n" +
                "Thu: 2:00 PM - CSE104 - Room 101\n" +
                "Fri: 1:00 PM - CSE105 - Room 203");

        add(new JScrollPane(timetableArea));
    }
}
