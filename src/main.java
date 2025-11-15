
import java.util.*;

public class main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        studentdao dao = new studentdaoimpl();

        while (true) {
            System.out.println("\n=== STUDENT MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();

            switch (ch) {

                case 1:
                    System.out.print("Name: ");
                    String name = sc.next();
                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    System.out.print("Course: ");
                    String course = sc.next();

                    dao.addStudent(new student(name, age, course));
                    System.out.println("Student Added!");
                    break;

                case 2:
                    List<student> list = dao.getAllStudents();
                    for (student s : list) {
                        System.out.println(s.getId() + " | " + s.getName() + " | " + s.getAge() + " | " + s.getCourse());
                    }
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    int searchId = sc.nextInt();
                    student s1 = dao.getStudentById(searchId);

                    if (s1 != null)
                        System.out.println(s1.getId() + " | " + s1.getName() + " | " + s1.getAge() + " | " + s1.getCourse());
                    else
                        System.out.println("Student Not Found!");
                    break;

                case 4:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    System.out.print("New Name: ");
                    String newName = sc.next();
                    System.out.print("New Age: ");
                    int newAge = sc.nextInt();
                    System.out.print("New Course: ");
                    String newCourse = sc.next();

                    dao.updateStudent(new student(id, newName, newAge, newCourse));
                    System.out.println("Student Updated!");
                    break;

                case 5:
                    System.out.print("Enter ID to delete: ");
                    int delId = sc.nextInt();
                    dao.deleteStudent(delId);
                    System.out.println("Student Deleted!");
                    break;

                case 6:
                    System.out.println("Exiting...");
                    return;
            }
        }
    }
}
