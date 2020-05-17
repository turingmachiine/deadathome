package ru.itis.deadathome.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.deadathome.models.FileInfo;
import ru.itis.deadathome.models.Post;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto {
    private Long id;
    private String title;
    private String postText;
    private LocalDateTime createdAt;
    private HousesDto house;
    private UserDto author;
    FileInfo fileInfo;

    public static PostDto from(Post post) {
        PostDtoBuilder postDto = PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .postText(post.getPostText())
                .createdAt(post.getCreatedAt())
                .author(UserDto.from(post.getAuthor()))
                .fileInfo(post.getFileInfo());
        if (post.getHouse() != null) {
            postDto.house(HousesDto.from(post.getHouse()));
        }
        return postDto.build();
    }

    public static List<PostDto> from(List<Post> posts) {
        return posts.stream().map(PostDto::from).collect(Collectors.toList());
    }

}
