package admin;

import java.util.ArrayList;
import java.util.List;
import form.SubjectInputForm;


public class AdminData {
    public static String branch;
    public static String className;
    public static int totalDays; 
    public static int maxLectures;
    public static int subjectCount;
    public static String firstLectureTime;
    public static int lectureDuration;
    public static String lunchStart;
    public static String lunchEnd;
    public static String branchName;

    public static List<String> timeSlots = new ArrayList<>();
    public static List<SubjectInputForm.Subject> subjectList = new ArrayList<>();
    public static String[][] finalTimetable;

    public static void generateTimeSlots() {
        timeSlots.clear();

        try {
            String[] startParts = firstLectureTime.split(":");
            int startHour = Integer.parseInt(startParts[0]);
            int startMinute = Integer.parseInt(startParts[1]);

            for (int i = 0; i < maxLectures; i++) {
                int endHour = startHour;
                int endMinute = startMinute + lectureDuration;

                if (endMinute >= 60) {
                    endHour += endMinute / 60;
                    endMinute %= 60;
                }

                String slot = String.format("%02d:%02d - %02d:%02d", startHour, startMinute, endHour, endMinute);
                timeSlots.add(slot);

                startHour = endHour;
                startMinute = endMinute;
            }
        } catch (Exception e) {
            System.out.println("Error generating time slots: " + e.getMessage());
        }
    }
}
