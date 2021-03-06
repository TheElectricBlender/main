package seedu.address.ui;

import java.util.Comparator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.student.Student;

/**
 * An UI component that displays information of a {@code Student}.
 */
public class StudentCardDetailed extends UiPart<Region> {

    private static final String FXML = "StudentListCardDetailed.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Student student;

    @FXML
    private HBox cardPane;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label phone;
    @FXML
    private Label address;
    @FXML
    private Label email;
    @FXML
    private FlowPane tags;
    @FXML
    private Label temperature;
    @FXML
    private Label notes;
    @FXML
    private Label nokName;
    @FXML
    private Label nokRelationship;
    @FXML
    private Label nokContact;



    public StudentCardDetailed(Student student, int displayedIndex) {
        super(FXML);
        this.student = student;
        id.setText(displayedIndex + ". ");
        name.setText(student.getName().fullName);
        phone.setText("Mobile:  " + student.getPhone().value);
        address.setText("Address: " + student.getAddress().value);
        email.setText("Email:   " + student.getEmail().value);
        temperature.setText("Temperature:   " + student.getTemperature().value + " \u2103");
        notes.setText("No. of Notes:    " + student.getNotes().size());
        nokName.setText("NOK Name:  " + student.getNok().getNameOfNok());
        nokRelationship.setText("NOK Relationship:  " + student.getNok().getRelationshipOfNok());
        nokContact.setText("NOK Contact:  " + student.getNok().getContactOfNok());
        student.getTags().stream()
                .sorted(Comparator.comparing(tag -> tag.tagName))
                .forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof StudentCard)) {
            return false;
        }

        // state check
        StudentCardDetailed card = (StudentCardDetailed) other;
        return id.getText().equals(card.id.getText())
                && student.equals(card.student);
    }
}
