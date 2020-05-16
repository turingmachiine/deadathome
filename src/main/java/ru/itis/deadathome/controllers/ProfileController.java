package ru.itis.deadathome.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.deadathome.dto.EditDto;
import ru.itis.deadathome.dto.SignUpDto;
import ru.itis.deadathome.models.User;
import ru.itis.deadathome.security.UserDetailsImpl;
import ru.itis.deadathome.service.EditService;

import javax.validation.Valid;

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
        User user = userDetails.getUser();
        model.addAttribute("user", user);
        model.addAttribute("editForm", new EditDto(user.getEmail()));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(Authentication authentication, @Valid EditDto form, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            editService.edit(authentication, form);
            return "redirect:/profile";
        } else {
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            model.addAttribute("user", userDetails.getUser());
            System.out.println(bindingResult.getAllErrors());
            model.addAttribute("editForm", form);
            model.addAttribute("hasErrors", true);
            return "edit";
        }
    }
}
