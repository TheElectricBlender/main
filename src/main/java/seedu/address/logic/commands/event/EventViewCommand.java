package seedu.address.logic.commands.event;

import seedu.address.logic.commands.CommandResult;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.event.EventScheduleView;

import java.time.LocalDateTime;

import static java.util.Objects.requireNonNull;

public class EventViewCommand extends EventCommand {

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": view events. \n"
            + "Parameters(optional):\n"
            + "mode/ [weekly/daily]\n"
            + "targetDate/ [yyyy-mm-dd]\n"
            + "Example: event view mode/daily targetDate/2020-04-03";

    public static final String MESSAGE_VIEW_SUCCESS = "Showing schedule in %s mode with target date %s";

    private LocalDateTime targetViewDate;
    private EventScheduleView viewMode;

    public EventViewCommand() {

    }

    public void setViewMode(EventScheduleView viewMode) {
        requireNonNull(viewMode);
        this.viewMode = viewMode;
    }

    public void setTargetViewDate(LocalDateTime targetViewDate) {
        requireNonNull(targetViewDate);
        this.targetViewDate = targetViewDate;
    }


    @Override
    public CommandResult execute(Model model) throws CommandException {
        if (viewMode != null) {
            model.setEventScheduleView(viewMode);
        }

        if (targetViewDate != null) {
            model.setEventScheduleLocalDateTime(targetViewDate);
        }

        String successMessage = String.format(MESSAGE_VIEW_SUCCESS, model.getEventScheduleView().name().toLowerCase(),
                targetViewDate.toLocalDate().toString());

        return new CommandResult(successMessage);
    }
}
