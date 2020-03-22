package ru.itis.deadathome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.deadathome.dto.UserDto;
import ru.itis.deadathome.models.User;
import ru.itis.deadathome.repositories.UsersRepository;

import java.util.List;

import static ru.itis.deadathome.dto.UserDto.from;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<UserDto> getUsers() {
        return from(usersRepository.findAll());
    }

    @Override
    public UserDto getConcreteUser(Long userId) {
        User user = usersRepository.getOne(userId);
        return from(user);
    }

    @Override
    public List<UserDto> search(String name) {
        return from(usersRepository.findAllByFirstNameOrLastNameContainsIgnoreCase(name, name));
    }
}
