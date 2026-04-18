import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class SchoolSystem {
    private Set<Student> students = new HashSet<>();
    private Set<Course> courses = new HashSet<>();
    private Set<Lecturer> lecturers = new HashSet<>();
}
