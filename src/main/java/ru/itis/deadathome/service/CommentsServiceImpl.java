package ru.itis.deadathome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.deadathome.dto.CommentAddDto;
import ru.itis.deadathome.models.Comment;
import ru.itis.deadathome.models.Post;
import ru.itis.deadathome.repositories.CommentsRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentsRepository commentsRepository;

    @Override
    public List<Comment> findByPost(Post post) {
        return commentsRepository.findByPost(post);
    }

    @Override
    public void addComment(CommentAddDto commentDto) {
        Comment comment = Comment.builder()
                .commentText(commentDto.getCommentText())
                .user(commentDto.getUser())
                .post(commentDto.getPost())
                .createdAt(LocalDateTime.now()).build();
        commentsRepository.save(comment);
    }
}
