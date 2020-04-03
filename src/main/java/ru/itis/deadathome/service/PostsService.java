package ru.itis.deadathome.service;

import ru.itis.deadathome.dto.PostCreationDto;
import ru.itis.deadathome.models.House;
import ru.itis.deadathome.models.Post;

import java.util.List;

public interface PostsService {
    List<Post> getPosts();

    Post getConcretePost(Long postId);

    List<Post> search(String name);

    List<Post> getPostsAboutHouse(House house);

    List<Post> getOtherPostsAboutHouse(House house, Long id);

    Long create(PostCreationDto postDto);

}
