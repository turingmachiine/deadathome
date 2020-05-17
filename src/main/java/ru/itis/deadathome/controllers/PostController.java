package ru.itis.deadathome.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.deadathome.dto.*;
import ru.itis.deadathome.models.User;
import ru.itis.deadathome.repositories.HousesRepository;
import ru.itis.deadathome.repositories.PostsRepository;
import ru.itis.deadathome.security.UserDetailsImpl;
import ru.itis.deadathome.service.CommentsService;
import ru.itis.deadathome.service.HousesService;
import ru.itis.deadathome.service.PostsService;

import java.util.List;

@Controller
public class PostController {
    @Autowired
    private HousesService housesService;

    @Autowired
    private HousesRepository housesRepository;

    @Autowired
    private PostsRepository postsRepository;

    @Autowired
    private PostsService postsService;

    @Autowired
    private CommentsService commentsService;

    @GetMapping("/posts")
    public String getPostsPage(Model model, Authentication authentication, @RequestParam(value = "house_id",
            defaultValue = "-1") Long houseId, @RequestParam(value = "page", defaultValue = "0") Integer page) {
        model.addAttribute("page", page);
        if (page.equals(0)) {
            model.addAttribute("canListBack", false);
        } else {
            model.addAttribute("canListBack", true);
        }
        if (authentication != null) {
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            model.addAttribute("user", userDetails.getUser());

        }
        List<HousesDto> houses = housesService.getHouses();
        model.addAttribute("houses", houses);
        if (houseId != -1) {
            model.addAttribute("houseId", houseId);
            PostsSearchResult posts = postsService.getPostsAboutHouse(housesRepository.getOne(houseId), page);
            model.addAttribute("posts", posts.getPosts());
            if (page.equals(posts.getCount() - 1)) {
                model.addAttribute("canListForward", false);
            } else {
                model.addAttribute("canListForward", true);
            }
        } else {
            PostsSearchResult posts = postsService.getPosts(page);
            model.addAttribute("posts", posts.getPosts());
            if (page.equals(posts.getCount() - 1)) {
                model.addAttribute("canListForward", false);
            } else {
                model.addAttribute("canListForward", true);
            }
        }
        return "posts";
    }

    @GetMapping("/post{post-id}")
    public String getConcretePostPage(Model model, Authentication authentication,
                                      @PathVariable("post-id") Long postId) {
        if (authentication != null) {
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            model.addAttribute("user", userDetails.getUser());
        }
        PostDto post = postsService.getConcretePost(postId);
        if (post.getHouse() != null) {
            List<PostDto> posts = postsService.getOtherPostsAboutHouse(housesRepository.getOne(post.getHouse().getId()),
                    postId);
            model.addAttribute("otherPosts", posts);
        }
        List<CommentDto> comments = commentsService.findByPost(postsRepository.getOne(post.getId()));
        model.addAttribute("post", post);
        model.addAttribute("comments", comments);
        return "post";
    }

    @GetMapping("/create_post")
    public String getCreatePostPage(Authentication authentication, Model model) {
        if (authentication != null) {
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            model.addAttribute("user", userDetails.getUser());
        }
        List<HousesDto> houses = housesService.getHouses();
        model.addAttribute("houses", houses);
        return "create_post";
    }

    @PostMapping("/create_post")
    public String create(Authentication authentication, PostCreationDto postDto) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        postDto.setUser(user);
        if (!postDto.getHouseName().equals("Никакой")) {
            postDto.setHouse(housesRepository.getOne(housesService.getConcreteHouseByName(postDto.getHouseName()).getId()));
        }
        Long id = postsService.create(postDto);
        return "redirect:/post" + id;
    }

    @PostMapping("/comment{post-id}")
    public String addComment(Authentication authentication,
                             @PathVariable("post-id") Long postId, CommentAddDto commentAddDto) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        commentAddDto.setPost(postsRepository.getOne(postsService.getConcretePost(postId).getId()));
        commentAddDto.setUser(user);
        commentsService.addComment(commentAddDto);
        return "redirect:/post" + postId;
    }
}
