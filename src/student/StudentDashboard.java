package student;

import javax.swing.*;
import java.awt.*;
import admin.AdminData;
import form.SubjectInputForm.Subject;
import main.LoginUI;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class StudentDashboard extends JFrame {
    private String enrollment, semester;

    public StudentDashboard(String enrollment, String semester) {
        this.enrollment = enrollment;
        this.semester = semester;

        setTitle(" Student Dashboard - " + enrollment);
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        
        JLabel infoLabel = new JLabel("Enrollment: " + enrollment + "   |   Semester: " + semester + "   |   Branch: " + AdminData.branch);
        infoLabel.setFont(new Font("Arial", Font.BOLD, 16));
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(infoLabel, BorderLayout.NORTH);

        
        String[] headers = new String[AdminData.maxLectures + 1];
        headers[0] = "Day";
        for (int i = 1; i <= AdminData.maxLectures; i++) {
            headers[i] = "Lec " + i;
        }

        DefaultTableModel model = new DefaultTableModel(headers, 0);
        JTable table = new JTable(model);
        table.setRowHeight(50);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

        if (AdminData.finalTimetable != null) {
            String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
            for (int i = 0; i < AdminData.totalDays; i++) {
                String[] row = new String[AdminData.maxLectures + 1];
                row[0] = days[i];
                for (int j = 0; j < AdminData.maxLectures; j++) {
                    row[j + 1] = AdminData.finalTimetable[i][j] != null ? AdminData.finalTimetable[i][j] : "";
                }
                model.addRow(row);
            }
        } else {
            model.addRow(new String[]{"No timetable available"});
        }

        add(new JScrollPane(table), BorderLayout.CENTER);

       
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            new LoginUI();
            dispose();
        });

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add(backButton);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
