package ru.itis.deadathome.service;

import ru.itis.deadathome.dto.PostCreationDto;
import ru.itis.deadathome.dto.PostDto;
import ru.itis.deadathome.models.House;
import ru.itis.deadathome.models.Post;

import java.util.List;

public interface PostsService {
    List<PostDto> getPosts();

    PostDto getConcretePost(Long postId);

    List<PostDto> search(String name);

    List<PostDto> getPostsAboutHouse(House house);

    List<PostDto> getOtherPostsAboutHouse(House house, Long id);

    Long create(PostCreationDto postDto);

}
