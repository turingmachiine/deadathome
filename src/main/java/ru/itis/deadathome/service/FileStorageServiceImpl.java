package ru.itis.deadathome.service;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.deadathome.models.FileInfo;
import ru.itis.deadathome.repositories.FileInfoRepository;
import ru.itis.deadathome.util.FileStorageUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.InputStream;

@Service
public class FileStorageServiceImpl implements FileStorageService {

    @Autowired
    private FileInfoRepository fileInfoRepository;

    @Autowired
    private FileStorageUtil fileStorageUtil;

    @Override
    public FileInfo saveFile(MultipartFile file) {
        // вытягиваем всю инофрмацию о файле для сохранения ее в бд
        FileInfo fileInfo = fileStorageUtil.convertFromMultipart(file);
        // сохраняем информацию о файле
        fileInfoRepository.save(fileInfo);
        // переносим файл на наш диск
        fileStorageUtil.copyToStorage(file, fileInfo.getStorageFileName());
        // возвращаем имя файла - новое
        return fileInfo;
    }

    // получение файла по его урлу
    @SneakyThrows
    @Override
    public void writeFileToResponse(String fileName, HttpServletResponse response) {
        // находите информацию о файле в БД
        FileInfo file = fileInfoRepository.findOneByStorageFileName(fileName);
        // указываем Content-Type для ответа
        response.setContentType(file.getType());
        // получили инпут стрим файла на диске
        InputStream inputStream = new FileInputStream(new java.io.File(file.getUrl()));
        // скопировали файл в ответ
        org.apache.commons.io.IOUtils.copy(inputStream, response.getOutputStream());
        // пробрасываем буфер
        response.flushBuffer();
    }

}
