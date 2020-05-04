package ru.itis.deadathome.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.deadathome.dto.PostDto;
import ru.itis.deadathome.security.UserDetailsImpl;

import java.util.List;
import java.util.UUID;

import static ru.itis.deadathome.dto.UserDto.from;

@Controller
public class ChatController {

    @GetMapping("/flud")
    public String getChatPage(Authentication authentication, Model model) {
        if (authentication != null) {
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            model.addAttribute("user", userDetails.getUser());

            model.addAttribute("userDto", from(userDetails.getUser()));
        }
        return "chat";
    }
}
