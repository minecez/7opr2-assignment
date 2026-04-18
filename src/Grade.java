import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Grade {
    private int value;
    private LocalDate dateAdded;
    private Lecturer lecturer;

    public Grade(int value, Lecturer lecturer) {
        this.setValue(value);
        this.dateAdded = LocalDate.now();
        this.lecturer = lecturer;
    }

    private void setValue(int value) {
        if (value <1 || value > 5){
            throw new IllegalArgumentException("Grade value must be between 1 and 5.");
        }
        this.value = value;
    }
}
