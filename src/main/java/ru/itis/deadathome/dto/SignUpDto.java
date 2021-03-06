package ru.itis.deadathome.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class SignUpDto {
    private MultipartFile profilePic;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
