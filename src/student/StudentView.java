package student;

import admin.AdminData;
import form.SubjectInputForm.Subject;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class StudentView extends JFrame {

    public StudentView() {
        setTitle("Student Timetable");
        setSize(900, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(15, 15));

       
        String title = "Bansal College of Engineering - "
                + AdminData.branch + " | "
                + AdminData.className + " | Semester - 4";

        JLabel titleLabel = new JLabel(title, JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(titleLabel, BorderLayout.NORTH);

       
        List<Subject> subjects = AdminData.subjectList;

        int totalDays = AdminData.totalDays;
        int maxLectures = AdminData.maxLectures;

        String[][] data = new String[totalDays][maxLectures + 1];
        String[] columnNames = new String[maxLectures + 1];
        columnNames[0] = "Day";

        for (int i = 1; i <= maxLectures; i++) {
            columnNames[i] = "Period " + i;
        }

        String[] dayNames = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

        for (int i = 0; i < totalDays; i++) {
            data[i][0] = dayNames[i];
            for (int j = 0; j < maxLectures; j++) {
                Subject subject = subjects.get((i * maxLectures + j) % subjects.size());
                data[i][j + 1] = subject.getSubjectName().toUpperCase()
                        + " (" + subject.getTeacher().toUpperCase() + ")";
            }
        }

        JTable table = new JTable(data, columnNames);
        table.setRowHeight(40);
        table.setFont(new Font("SansSerif", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 15));

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}