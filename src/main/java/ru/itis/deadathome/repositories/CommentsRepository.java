package ru.itis.deadathome.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.deadathome.models.Comment;
import ru.itis.deadathome.models.Post;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);
}
