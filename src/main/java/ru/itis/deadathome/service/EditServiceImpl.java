package ru.itis.deadathome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.deadathome.dto.EditDto;
import ru.itis.deadathome.models.FileInfo;
import ru.itis.deadathome.models.User;
import ru.itis.deadathome.repositories.FileInfoRepository;
import ru.itis.deadathome.repositories.UsersRepository;
import ru.itis.deadathome.security.UserDetailsImpl;
import ru.itis.deadathome.util.FileStorageUtil;

import java.util.Optional;

@Service
public class EditServiceImpl implements EditService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    private FileStorageService fileStorageService;

    @Override
    public void edit(Authentication authentication, EditDto form) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        user.setEmail(form.getEmail());
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        if (form.getProfilePic().getSize() != 0) {
            user.setProfilePic(fileStorageService.saveFile(form.getProfilePic()));
        }
        usersRepository.save(user);
        UserDetails newUserDetails = new UserDetailsImpl(user);
        Authentication newAuth = new UsernamePasswordAuthenticationToken(newUserDetails,
                authentication.getCredentials(), authentication.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(newAuth);

    }
}
