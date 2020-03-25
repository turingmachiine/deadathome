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
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    private User creator;

    private LocalDateTime createdAt;

    @Enumerated(value = EnumType.STRING)
    private HouseClass houseClass;

    private String description;

    @ManyToOne
    private Location location;

    @ManyToOne
    @JoinColumn(name = "storageFileName")
    FileInfo fileInfo;
}
