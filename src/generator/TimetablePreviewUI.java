package generator;

import javax.swing.*;
import java.awt.*;
import admin.AdminData;
import admin.AdminPanel;
import form.SubjectInputForm.Subject;

public class TimetablePreviewUI extends JFrame {

    public TimetablePreviewUI() {
        setTitle(" Generated Timetable");
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] columnNames = new String[AdminData.maxLectures + 1];
        columnNames[0] = "Day";
        for (int i = 1; i <= AdminData.maxLectures; i++) {
            columnNames[i] = "Period " + i;
        }

        String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        String[][] data = new String[AdminData.totalDays][AdminData.maxLectures + 1];

        java.util.List<Subject> subjects = form.SubjectInputForm.getSubjects();

        int subjectIndex = 0;
        for (int i = 0; i < AdminData.totalDays; i++) {
            data[i][0] = days[i];
            for (int j = 1; j <= AdminData.maxLectures; j++) {
                Subject sub = subjects.get(subjectIndex % subjects.size());
                data[i][j] = sub.getSubjectName();
                subjectIndex++;
            }
        }

        JTable table = new JTable(data, columnNames);
        table.setFont(new Font("Consolas", Font.PLAIN, 14));
        table.setRowHeight(30);
        JScrollPane scrollPane = new JScrollPane(table);

        JLabel title = new JLabel(" Generated Timetable", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        JButton backButton = new JButton("⬅ Back");
        backButton.addActionListener(e -> {
            new AdminPanel();  
            dispose();
        });

        setLayout(new BorderLayout());
        add(title, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}
