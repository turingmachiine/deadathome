package ru.itis.deadathome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.deadathome.dto.PostCreationDto;
import ru.itis.deadathome.models.House;
import ru.itis.deadathome.models.Post;
import ru.itis.deadathome.repositories.PostsRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostsServiceImpl implements PostsService {

    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    private PostsRepository postsRepository;

    @Override
    public List<Post> getPosts() {
        return postsRepository.findAll();
    }

    @Override
    public Post getConcretePost(Long postId) {
        return postsRepository.getOne(postId);
    }

    @Override
    public List<Post> search(String name) {
        return null;
    }

    @Override
    public List<Post> getPostsAboutHouse(House house) {
        return postsRepository.findByHouse(house);
    }

    @Override
    public List<Post> getOtherPostsAboutHouse(House house, Long id) {
        return postsRepository.findByHouseAndIdIsNot(house, id);
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
