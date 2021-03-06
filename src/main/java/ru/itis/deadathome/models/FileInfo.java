package ru.itis.deadathome.models;

import lombok.*;

import javax.persistence.*;
import java.io.File;
import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder()
public class FileInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // название файла в хранилище
    private String storageFileName;
    // название файла оригинальное
    private String originalFileName;
    // размер файла
    private Long size;
    // тип файла (MIME)
    private String type;
    // по какому URL можно получить файл
    private String url;

    @Transient
    private File sourceFile;

    @PostLoad
    public void loadFile() {
        sourceFile = new File(url);
    }
}

