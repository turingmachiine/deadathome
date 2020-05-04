package ru.itis.deadathome.service;

import ru.itis.deadathome.dto.PostCreationDto;
import ru.itis.deadathome.dto.PostDto;
import ru.itis.deadathome.dto.PostsSearchResult;
import ru.itis.deadathome.models.House;
import ru.itis.deadathome.models.Post;

import java.util.List;

public interface PostsService {
    PostsSearchResult getPosts(Integer page);

    PostDto getConcretePost(Long postId);

    List<PostDto> search(String name);

    PostsSearchResult getPostsAboutHouse(House house, Integer page);

    List<PostDto> getOtherPostsAboutHouse(House house, Long id);

    Long create(PostCreationDto postDto);

}
