import java.time.LocalDate;

public class Grade {
    private int value;
    private LocalDate dateAdded;
    private Lecturer lecturer;

    public Grade(int value, Lecturer lecturer) {
        this.value = value;
        this.dateAdded = LocalDate.now();
        this.lecturer = lecturer;
    }
}
