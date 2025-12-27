package auth;

import javax.swing.*;
import admin.*;

public class StudentView extends JFrame {
    public StudentView(String semester) {
        setTitle("Student Timetable - Semester " + semester);
        setSize(1000, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTextArea area = new JTextArea();
        area.setEditable(false);

        area.append("Timetable for Semester: " + semester + "\n\n");

        for (int day = 0; day < 6; day++) {
            area.append(" Day: " + getDay(day) + "\n");
            for (int slot = 0; slot < AdminData.maxLectures; slot++) {
                String lecture = AdminData.finalTimetable[day][slot];
                if (lecture != null) {
                    area.append("  Lecture " + (slot + 1) + ": " + lecture + "\n");
                }
            }
            area.append("\n");
        }

        add(new JScrollPane(area));
    }

    private String getDay(int i) {
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        return days[i];
    }
}
