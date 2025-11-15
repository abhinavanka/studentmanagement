import java.sql.*;
import java.util.*;

public class studentdaoimpl implements studentdao {

    Connection con = dbconnection.getConnection();

    // ADD STUDENT
    public void addStudent(student s) {
        try {
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO students (name, age, course) VALUES (?, ?, ?)"
            );
            ps.setString(1, s.getName());
            ps.setInt(2, s.getAge());
            ps.setString(3, s.getCourse());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // GET ALL STUDENTS
    public List<student> getAllStudents() {
        List<student> list = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                list.add(new student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("course")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // GET STUDENT BY ID
    public student getStudentById(int id) {
        student s = null;
        try {
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM students WHERE id = ?"
            );
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                s = new student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("course")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    // UPDATE STUDENT
    public void updateStudent(student s) {
        try {
            PreparedStatement ps = con.prepareStatement(
                "UPDATE students SET name=?, age=?, course=? WHERE id=?"
            );
            ps.setString(1, s.getName());
            ps.setInt(2, s.getAge());
            ps.setString(3, s.getCourse());
            ps.setInt(4, s.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE STUDENT
    public void deleteStudent(int id) {
        try {
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM students WHERE id=?"
            );
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

