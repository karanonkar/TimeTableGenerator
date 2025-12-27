package db;

import java.sql.*;
import admin.AdminData;

public class TimetableDAO {

    public static void saveTimetable() {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("INSERT INTO timetable_data (day, slot, subject_info) VALUES (?, ?, ?)")) {

            String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < AdminData.maxLectures; j++) {
                    ps.setString(1, days[i]);
                    ps.setInt(2, j + 1);
                    ps.setString(3, AdminData.finalTimetable[i][j]);
                    ps.addBatch();
                }
            }

            ps.executeBatch();
            System.out.println(" Timetable saved to Oracle DB.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadTimetable() {
        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM timetable_data")) {

            String[][] timetable = new String[6][AdminData.maxLectures];
            String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

            while (rs.next()) {
                String day = rs.getString("day");
                int slot = rs.getInt("slot") - 1;
                String subject = rs.getString("subject_info");

                for (int i = 0; i < 6; i++) {
                    if (days[i].equalsIgnoreCase(day)) {
                        timetable[i][slot] = subject;
                        break;
                    }
                }
            }

            AdminData.finalTimetable = timetable;
            System.out.println("Timetable loaded from Oracle DB.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
