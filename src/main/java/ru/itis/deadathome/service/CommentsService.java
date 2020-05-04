package ru.itis.deadathome.service;

import ru.itis.deadathome.dto.CommentAddDto;
import ru.itis.deadathome.dto.CommentDto;
import ru.itis.deadathome.models.Comment;
import ru.itis.deadathome.models.Post;
import ru.itis.deadathome.models.User;

import java.util.List;

public interface CommentsService {
    List<CommentDto> findByPost(Post post);

    void addComment(CommentAddDto comment);
}
