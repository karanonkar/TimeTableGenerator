package teacher;

import admin.AdminData;
import form.SubjectInputForm.Subject;
import main.LoginUI;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class TeacherTimetableUI extends JFrame {
    public TeacherTimetableUI() {
        String teacherName = JOptionPane.showInputDialog(this, "Enter your name:");
        if (teacherName == null || teacherName.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Teacher name is required!");
            return;
        }

        setTitle(" Timetable for " + teacherName);
        setSize(850, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JLabel heading = new JLabel(" Weekly Timetable for " + teacherName, SwingConstants.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        add(heading, BorderLayout.NORTH);

      
        String[] columns = new String[AdminData.maxLectures + 1];
        columns[0] = "Day";
        for (int i = 1; i <= AdminData.maxLectures; i++) {
            columns[i] = "Lec " + i;
        }

        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);
        table.setRowHeight(50);
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));

        
        String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (int i = 0; i < AdminData.totalDays; i++) {
            String[] row = new String[AdminData.maxLectures + 1];
            row[0] = days[i];
            for (int j = 0; j < AdminData.maxLectures; j++) {
                String slot = AdminData.finalTimetable[i][j];
                if (slot != null && slot.contains("(" + teacherName + ")")) {
                    row[j + 1] = slot;
                } else {
                    row[j + 1] = ""; 
                }
            }
            model.addRow(row);
        }

        add(new JScrollPane(table), BorderLayout.CENTER);

        
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton backButton = new JButton("⬅ Back");
        bottomPanel.add(backButton);
        add(bottomPanel, BorderLayout.SOUTH);

        backButton.addActionListener(e -> {
            new LoginUI();
            dispose();
        });

        setVisible(true);
    }
}
