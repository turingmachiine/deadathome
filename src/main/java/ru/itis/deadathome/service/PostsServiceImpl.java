package ru.itis.deadathome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.itis.deadathome.dto.PostCreationDto;
import ru.itis.deadathome.dto.PostDto;
import ru.itis.deadathome.dto.PostsSearchResult;
import ru.itis.deadathome.models.House;
import ru.itis.deadathome.models.Post;
import ru.itis.deadathome.repositories.PostsRepository;

import java.time.LocalDateTime;
import java.util.List;

import static ru.itis.deadathome.dto.PostDto.from;

@Service
public class PostsServiceImpl implements PostsService {

    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    private PostsRepository postsRepository;

    @Override
    public PostsSearchResult getPosts(Integer page) {
        PageRequest pageRequest = PageRequest.of(page, 3);
        Page<Post> pageResult = postsRepository.findAll(pageRequest);
        return PostsSearchResult.builder()
                .posts(from(pageResult.getContent()))
                .count(pageResult.getTotalPages())
                .build();
    }

    @Override
    public PostDto getConcretePost(Long postId) {
        return from(postsRepository.getOne(postId));
    }

    @Override
    public List<PostDto> search(String name) {
        return null;
    }

    @Override
    public PostsSearchResult getPostsAboutHouse(House house, Integer page) {
        PageRequest pageRequest = PageRequest.of(page, 3);
        Page<Post> pageResult = postsRepository.findByHouse(house, pageRequest);
        return PostsSearchResult.builder()
                .posts(from(pageResult.getContent()))
                .count(pageResult.getTotalPages())
                .build();
    }

    @Override
    public List<PostDto> getOtherPostsAboutHouse(House house, Long id) {
        return from(postsRepository.findByHouseAndIdIsNot(house, id));
    }

    @Override
    public Long create(PostCreationDto postDto) {
        Post post = Post.builder()
                .postText(postDto.getText())
                .createdAt(LocalDateTime.now())
                .author(postDto.getUser())
                .house(postDto.getHouse())
                .fileInfo(fileStorageService.saveFile(postDto.getFile()))
                .title(postDto.getTitle())
                .build();
        postsRepository.save(post);
        return post.getId();
    }
}
