package ru.itis.deadathome.models;

import lombok.*;

import javax.persistence.*;
import java.io.File;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder()
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String commentText;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "author")
    User user;

    @ManyToOne
    @JoinColumn(name = "relatedPost")
    Post post;
}
