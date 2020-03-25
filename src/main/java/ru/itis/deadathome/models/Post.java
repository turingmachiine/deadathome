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
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String postText;
    private LocalDateTime createdAt;

    @ManyToOne
    private House house;

    @ManyToOne
    private User author;

    @ManyToOne
    @JoinColumn(name = "storageFileName")
    FileInfo fileInfo;

}
