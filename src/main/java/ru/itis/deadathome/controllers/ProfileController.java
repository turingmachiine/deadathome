package ru.itis.deadathome.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.deadathome.dto.EditDto;
import ru.itis.deadathome.dto.SignUpDto;
import ru.itis.deadathome.security.UserDetailsImpl;
import ru.itis.deadathome.service.EditService;

@Controller
public class ProfileController {
    @Autowired
    private EditService editService;

    @GetMapping("/profile")
    public String getProfile(Authentication authentication, Model model) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        model.addAttribute("user", userDetails.getUser());
        return "profile";
    }

    @GetMapping("/edit")
    public String getProfileEdit(Authentication authentication, Model model) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        model.addAttribute("user", userDetails.getUser());
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(Authentication authentication, EditDto form) {
        editService.edit(authentication, form);
        return "redirect:/profile";
    }
}
