package auth;

import javax.swing.*;
import admin.*;

public class TeacherView extends JFrame {
    public TeacherView(String teacherName) {
        setTitle("Teacher Timetable - " + teacherName);
        setSize(1000, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTextArea area = new JTextArea();
        area.setEditable(false);

        area.append(" Timetable for Teacher: " + teacherName + "\n\n");

        for (int day = 0; day < 6; day++) {
            area.append(" Day: " + getDay(day) + "\n");
            for (int slot = 0; slot < AdminData.maxLectures; slot++) {
                String lecture = AdminData.finalTimetable[day][slot];
                if (lecture != null && lecture.contains(teacherName)) {
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
