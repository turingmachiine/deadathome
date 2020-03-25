package ru.itis.deadathome.service;


import org.springframework.security.core.Authentication;
import ru.itis.deadathome.dto.EditDto;

public interface EditService {
    void edit(Authentication authentication, EditDto form);
}
