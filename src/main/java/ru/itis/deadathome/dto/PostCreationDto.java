package ru.itis.deadathome.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.deadathome.models.House;
import ru.itis.deadathome.models.User;

@Data
public class PostCreationDto {
    House house;
    String houseName;
    User user;
    String title;
    String text;
    MultipartFile file;
}
