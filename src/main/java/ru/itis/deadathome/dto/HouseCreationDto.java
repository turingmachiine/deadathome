package ru.itis.deadathome.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.deadathome.models.User;

@Data
public class HouseCreationDto {
    User user;
    String houseName;
    String description;
    float latitude;
    float longitude;
    String city;
    String houseClass;
    MultipartFile file;
}
