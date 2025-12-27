package admin;

import form.SubjectInputForm;
import main.LoginUI;
import generator.TimetableGeneratorUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminInputForm extends JFrame {
    private JComboBox<String> branchBox;
    private JTextField classField, daysField, lecturesField, subjectCountField;

    public AdminInputForm() {
        setTitle("Admin Input Form");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

     
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));

        JLabel branchLabel = new JLabel("Branch:");
        branchBox = new JComboBox<>(new String[]{"CSE", "AIML", "CE", "ME", "EC", "EX"});

        JLabel classLabel = new JLabel("Class Name:");
        classField = new JTextField();

        JLabel daysLabel = new JLabel("Total Days:");
        daysField = new JTextField();

        JLabel lecturesLabel = new JLabel("Max Lectures/Day:");
        lecturesField = new JTextField();

        JLabel subjectCountLabel = new JLabel("Number of Subjects:");
        subjectCountField = new JTextField();

     
        formPanel.add(branchLabel);
        formPanel.add(branchBox);
        formPanel.add(classLabel);
        formPanel.add(classField);
        formPanel.add(daysLabel);
        formPanel.add(daysField);
        formPanel.add(lecturesLabel);
        formPanel.add(lecturesField);
        formPanel.add(subjectCountLabel);
        formPanel.add(subjectCountField);
        formPanel.add(new JLabel()); 


        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton backButton = new JButton("⬅ Back");
        JButton nextButton = new JButton("Next");

        bottomPanel.add(backButton);
        bottomPanel.add(nextButton);

       
        add(formPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

   
        backButton.addActionListener(e -> {
            new LoginUI();
            dispose();
        });

      
        nextButton.addActionListener(e -> {
            try {
                AdminData.branch = branchBox.getSelectedItem().toString();
                AdminData.className = classField.getText().trim();
                AdminData.totalDays = Integer.parseInt(daysField.getText().trim());
                AdminData.maxLectures = Integer.parseInt(lecturesField.getText().trim());
                AdminData.subjectCount = Integer.parseInt(subjectCountField.getText().trim());

                SubjectInputForm subjectInputForm = new SubjectInputForm(AdminData.subjectCount);
                subjectInputForm.setVisible(true);
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please check all fields.");
            }
        });

        setVisible(true);
    }
}
