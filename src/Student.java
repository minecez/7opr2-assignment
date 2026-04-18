import lombok.Getter;

import java.util.Map;

@Getter
public class Student {
    private String studyNumber;
    private Map<Course, Grade> grades;

    public Student(String studyNumber) {
        this.studyNumber = studyNumber;
    }

    public void addGrade(Course course, Grade grade) {
        if (grades.containsKey(course)) {
            throw new IllegalArgumentException("Student already has a grade for this course. Remove it before adding a new one. That's just the way it is, I decided");
        }
        this.grades.put(course, grade);
    }

    public void removeGrade(Course course) {
        if (!grades.containsKey(course)) {
            throw new IllegalArgumentException("Student does not have a grade for this course.");
        }
        this.grades.remove(course);
    }
}
