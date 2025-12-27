package admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import form.SubjectInputForm; 
public class SubjectFormUI extends JFrame {
    private List<SubjectInputForm.Subject> subjectList = new ArrayList<>();
    private JPanel formPanel;

    public SubjectFormUI() {
        setTitle("Subject Input Form");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 4, 10, 10));

        JScrollPane scrollPane = new JScrollPane(formPanel);
        add(scrollPane, BorderLayout.CENTER);

        JButton addRowButton = new JButton("Add Subject");
        JButton saveButton = new JButton("Save");

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addRowButton);
        buttonPanel.add(saveButton);

        add(buttonPanel, BorderLayout.SOUTH);

        addSubjectRow(); 

        addRowButton.addActionListener(e -> addSubjectRow());

        saveButton.addActionListener(e -> {
        	AdminData.subjectList = subjectList;
            JOptionPane.showMessageDialog(this, "Subjects saved successfully!");
            dispose();
        });
    }

    private void addSubjectRow() {
        JTextField subjectField = new JTextField();
        JTextField teacherField = new JTextField();
        JTextField lecturesField = new JTextField();
        JTextField classNameField = new JTextField(AdminData.className); // default value

        formPanel.add(subjectField);
        formPanel.add(teacherField);
        formPanel.add(lecturesField);
        formPanel.add(classNameField);

        revalidate();
        repaint();

        subjectList.add(new SubjectInputForm.Subject(
            subjectField.getText().trim(),
            teacherField.getText().trim(),
            Integer.parseInt(lecturesField.getText().trim().isEmpty() ? "0" : lecturesField.getText().trim()),
            classNameField.getText().trim()
        ));
    }
}
