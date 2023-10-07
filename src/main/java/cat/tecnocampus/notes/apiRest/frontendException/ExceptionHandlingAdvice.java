package cat.tecnocampus.notes.apiRest.frontendException;

import cat.tecnocampus.notes.application.exception.UserNotFoundException;
import cat.tecnocampus.notes.domain.exception.NotEditableNote;
import cat.tecnocampus.notes.domain.exception.NoteNotOwnedException;
import cat.tecnocampus.notes.persistence.exception.NoteDoesNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlingAdvice {
    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "User not found")
    String userNotFoundHandler(Exception ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(NoteDoesNotExistException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Note not found")
    String noteNotFoundHandler(Exception ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(NotEditableNote.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.CONFLICT, reason = "Duplicated key. Please choose another one.")
    String notEditableNote(Exception ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(NoteNotOwnedException.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.CONFLICT, reason = "This Note is not yours. Please choose another one.")
    String noteNotOwned(Exception ex) {
        return ex.getMessage();
    }

}
