package ru.itis.deadathome.dto;

import lombok.Data;
import ru.itis.deadathome.models.Post;
import ru.itis.deadathome.models.User;

@Data
public class CommentAddDto {
    String commentText;
    User user;
    Post post;
}
