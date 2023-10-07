package cat.tecnocampus.notes.application.DTOs;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;

public class NoteLabDTO {

    @NotEmpty(message = "Title cannot be empty")
    @Size(min=3, max=255, message = "Title must be between 3 and 255 characters")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Title must contain only letters")
    private String title;
    private String content;

    private LocalDateTime dateCreation;

    private LocalDateTime dateEdit;

    @JsonIgnore
    private UserLabDTO owner;

    public NoteLabDTO() {
    }

    public UserLabDTO getOwner() {
        return owner;
    }

    public void setOwner(UserLabDTO owner) {
        this.owner = owner;
    }

    public NoteLabDTO(String title, String content) {
        this.title = title;
        this.content = content;
        dateCreation = LocalDateTime.now();
        dateEdit = LocalDateTime.now();
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    public LocalDateTime getDateEdit() {
        return dateEdit;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setDateEdit(LocalDateTime dateEdit) {
        this.dateEdit = dateEdit;
    }

}
