package ru.itis.deadathome.service;

import org.springframework.web.multipart.MultipartFile;
import ru.itis.deadathome.models.FileInfo;

import javax.servlet.http.HttpServletResponse;

public interface FileStorageService {
    // сохраняет файл на сервере
    FileInfo saveFile(MultipartFile file);
    // отправляет файл по запросу
    void writeFileToResponse(String fileName, HttpServletResponse response);
}
