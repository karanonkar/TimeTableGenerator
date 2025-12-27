
package generator;

import form.SubjectInputForm.Subject;
import admin.AdminData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.*;
import java.util.List;

public class TimetableGeneratorUI extends JFrame {
    public TimetableGeneratorUI() {
        setTitle("College Timetable Generator");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        List<Subject> subjects = AdminData.subjectList;
        int totalDays = AdminData.totalDays;
        int maxLectures = AdminData.maxLectures;

     
        String[] columnNames = new String[maxLectures + 1];
        columnNames[0] = "Day/Time";
        for (int i = 1; i <= maxLectures; i++) {
            columnNames[i] = "Period " + i;
        }

        String[] dayNames = {"MON", "TUE", "WED", "THR", "FRI", "SAT"};
        String[][] data = new String[totalDays][maxLectures + 1];

        Set<String> used = new HashSet<>();
        Random random = new Random();

        for (int i = 0; i < totalDays; i++) {
            data[i][0] = dayNames[i % dayNames.length];
            for (int j = 1; j <= maxLectures; j++) {
                Subject sub;
                int attempts = 0;
                do {
                    sub = subjects.get(random.nextInt(subjects.size()));
                    attempts++;
                } while (used.contains(data[i][0] + j + sub.getSubjectName()) && attempts < 10);

                used.add(data[i][0] + j + sub.getSubjectName());
                data[i][j] = sub.getSubjectName().toUpperCase() + "\n(" + sub.getTeacher().toUpperCase() + ")";
            }
        }

        JTable table = new JTable(new DefaultTableModel(data, columnNames)) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table.setFont(new Font("Monospaced", Font.PLAIN, 14));
        table.setRowHeight(40);
        table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 16));

        JScrollPane scrollPane = new JScrollPane(table);

        JLabel heading = new JLabel("Bansal College of Engineering, Mandideep\nDepartment of Computer Science & Engineering\n4th Semester - Timetable\nCSE-B1 (Room No. 349)", JLabel.CENTER);
        heading.setFont(new Font("Serif", Font.BOLD, 16));
        heading.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        add(heading, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }
}
