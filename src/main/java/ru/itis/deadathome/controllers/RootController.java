package ru.itis.deadathome.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.deadathome.dto.PostDto;
import ru.itis.deadathome.models.Post;
import ru.itis.deadathome.security.UserDetailsImpl;
import ru.itis.deadathome.service.PostsService;

import java.util.List;

@RequestMapping("/")
@Controller
public class RootController {
    @Autowired
    private PostsService postsService;

    @GetMapping
    public String getRootPage(Authentication authentication, Model model) {
        if (authentication != null) {
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            model.addAttribute("user", userDetails.getUser());
        }
        List<PostDto> posts = postsService.getPosts(0).getPosts();
        model.addAttribute("topPosts", posts);
        return "index";
    }
}
