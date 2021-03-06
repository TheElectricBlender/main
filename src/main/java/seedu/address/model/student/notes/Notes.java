package seedu.address.model.student.notes;

/**
 * An abstract class representing the Notes.
 */
public abstract class Notes {
    private final String student;
    private final String content;

    public Notes(String student, String content) {
        this.student = student;
        this.content = content;
    }

    public String getStudent() {
        return student;
    }

    public String getContent() {
        return content;
    }

}


