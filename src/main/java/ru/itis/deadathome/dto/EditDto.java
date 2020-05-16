package ru.itis.deadathome.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;

@Data
public class EditDto {
    private MultipartFile profilePic;
    private String firstName;
    private String lastName;

    public EditDto(@Email(message = "{errors.incorrect.email}") String email) {
        this.email = email;
    }

    @Email(message = "{errors.incorrect.email}")
    private String email;
}
