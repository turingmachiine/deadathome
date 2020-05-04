package ru.itis.deadathome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.deadathome.dto.PostCreationDto;
import ru.itis.deadathome.dto.PostDto;
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
    public List<PostDto> getPosts() {
        return from(postsRepository.findAll());
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
    public List<PostDto> getPostsAboutHouse(House house) {
        return from(postsRepository.findByHouse(house));
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
