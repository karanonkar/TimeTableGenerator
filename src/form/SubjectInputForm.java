
package form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import admin.AdminData;
import admin.AdminInputForm;
import main.LoginUI;
public class SubjectInputForm extends JFrame {

    private List<Subject> subjectList = new ArrayList<>();

    private List<JTextField> subjectFields = new ArrayList<>();
    private List<JTextField> teacherFields = new ArrayList<>();
    private List<JTextField> lectureFields = new ArrayList<>();
    private List<JTextField> classNameFields = new ArrayList<>();

    public SubjectInputForm() {
        this(AdminData.subjectCount); // default constructor calls parameterized
    }

    public SubjectInputForm(int subjectCount) {
        setTitle("Enter Subject Details");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(subjectCount, 4, 10, 10));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));

        for (int i = 0; i < subjectCount; i++) {
            JTextField subject = new JTextField();
            JTextField teacher = new JTextField();
            JTextField lectures = new JTextField();
            JTextField className = new JTextField();

            inputPanel.add(new JLabel("Subject Name: "));
            inputPanel.add(subject);
            inputPanel.add(new JLabel("Teacher Name: "));
            inputPanel.add(teacher);
            inputPanel.add(new JLabel("Lectures: "));
            inputPanel.add(lectures);
            inputPanel.add(new JLabel("Class Name: "));
            inputPanel.add(className);

            subjectFields.add(subject);
            teacherFields.add(teacher);
            lectureFields.add(lectures);
            classNameFields.add(className);
        }
 
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton backButton = new JButton("⬅ Back");
        bottomPanel.add(backButton);

        add(bottomPanel, BorderLayout.SOUTH);

        backButton.addActionListener(e -> {
            new AdminInputForm();
            dispose();
        });


        JButton saveButton = new JButton("Save Subjects");
        saveButton.addActionListener(e -> {
            subjectList.clear();
            try {
                for (int i = 0; i < subjectFields.size(); i++) {
                    String s = subjectFields.get(i).getText().trim();
                    String t = teacherFields.get(i).getText().trim();
                    int l = Integer.parseInt(lectureFields.get(i).getText().trim());
                    String c = classNameFields.get(i).getText().trim();

                    subjectList.add(new Subject(s, t, l, c));
                }
                AdminData.subjectList = subjectList;
                JOptionPane.showMessageDialog(this, "Subjects saved successfully!");
                new generator.TimetableGeneratorUI().setVisible(true);
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error saving subjects: " + ex.getMessage());
            }
        });

        add(inputPanel, BorderLayout.CENTER);
        add(saveButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    
    public static List<Subject> getSubjects() {
        return AdminData.subjectList;
    }


    public static class Subject {
        private String subjectName;
        private String teacher;
        private int lectures;
        private String className;

        public Subject(String subjectName, String teacher, int lectures, String className) {
            this.subjectName = subjectName;
            this.teacher = teacher;
            this.lectures = lectures;
            this.className = className;
        }

        public String getSubjectName() {
            return subjectName;
        }

        public String getTeacher() {
            return teacher;
        }

        public int getLectures() {
            return lectures;
        }

        public String getClassName() {
            return className;
        }
    }
}
