package ru.itis.deadathome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.deadathome.dto.SignUpDto;
import ru.itis.deadathome.models.FileInfo;
import ru.itis.deadathome.models.Role;
import ru.itis.deadathome.models.State;
import ru.itis.deadathome.models.User;
import ru.itis.deadathome.repositories.FileInfoRepository;
import ru.itis.deadathome.repositories.UsersRepository;
import ru.itis.deadathome.util.FileStorageUtil;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.ExecutorService;

@Component
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private FileStorageService fileStorageService;

    @Autowired
    private ExecutorService executorService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void signUp(SignUpDto form) {
        User user = User.builder()
                .email(form.getEmail())
                .hashPassword(passwordEncoder.encode(form.getPassword()))
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .createdAt(LocalDateTime.now())
                .state(State.NOT_CONFIRMED)
                .role(Role.USER)
                .profilePic(fileStorageService.saveFile(form.getProfilePic()))
                .confirmCode(UUID.randomUUID().toString())
                .build();
        usersRepository.save(user);

        if (user.getEmail().contains("@")) {
            executorService.submit(() ->
                    emailService.sendMail("Confirm", user.getConfirmCode(), user.getEmail()));
        } else {
            executorService.submit(() -> messageService.sendMessage(user.getEmail(), user.getFirstName(),
                    user.getConfirmCode()));
        }
    }
}
