package ru.itis.deadathome.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class EditDto {
    private MultipartFile profilePic;
    private String firstName;
    private String lastName;
    private String email;
}
