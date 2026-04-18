import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class GradingTest {
    @Test
    void testCreateGrade() {
        Lecturer lecturer = new Lecturer("John Doe");
        Grade grade = new Grade(4, lecturer);
        Assertions.assertEquals(4, grade.getValue());
        Assertions.assertEquals(lecturer, grade.getLecturer());
    }

    @Test
    void testCreateGradeInvalidValue() {
        Lecturer lecturer = new Lecturer("John Doe");
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Grade(0, lecturer));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Grade(6, lecturer));
    }

    @Test
    void testGradeStudent() {
        SchoolSystem schoolSystem = new SchoolSystem();
        Student student = new Student("A00001");
        Course course = new Course("GRD101", "Introduction to Grading");
        Lecturer lecturer = new Lecturer("John Doe");

        schoolSystem.gradeStudent(student, course, 1, lecturer);

        Assertions.assertEquals(LocalDate.now(), student.getGrades().get(course).getDateAdded());
        Assertions.assertEquals(1, student.getGrades().get(course).getValue());
        Assertions.assertEquals(lecturer, student.getGrades().get(course).getLecturer());
    }

    @Test
    void testGradeStudentExistingGrade() {
        SchoolSystem schoolSystem = new SchoolSystem();
        Student student = new Student("A00001");
        Course course = new Course("GRD101", "Introduction to Grading");
        Lecturer lecturer = new Lecturer("John Doe");

        schoolSystem.gradeStudent(student, course, 1, lecturer);

        Assertions.assertThrows(IllegalArgumentException.class, () -> schoolSystem.gradeStudent(student, course, 5, lecturer));
    }
}
