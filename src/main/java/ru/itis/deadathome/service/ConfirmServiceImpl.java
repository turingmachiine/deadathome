package ru.itis.deadathome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.deadathome.models.State;
import ru.itis.deadathome.models.User;
import ru.itis.deadathome.repositories.UsersRepository;

import java.util.Optional;

@Service
public class ConfirmServiceImpl implements ConfirmService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public boolean confirm(String confirmCode) {
        Optional<User> userOptional = usersRepository.findByConfirmCode(confirmCode);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setState(State.CONFIRMED);
            usersRepository.save(user);
            return true;
        }
        return false;
    }
}
