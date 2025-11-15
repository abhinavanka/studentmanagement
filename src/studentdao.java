import java.util.List;

public interface studentdao {
    void addStudent(student s);
    List<student> getAllStudents();
    student getStudentById(int id);
    void updateStudent(student s);
    void deleteStudent(int id);
}
