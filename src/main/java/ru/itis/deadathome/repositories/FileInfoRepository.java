package ru.itis.deadathome.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.deadathome.models.FileInfo;

public interface FileInfoRepository extends JpaRepository<FileInfo, Long> {
    FileInfo findOneByStorageFileName(String storageFileName);
}

