package ru.itis.deadathome.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.deadathome.dto.HousesDto;
import ru.itis.deadathome.dto.PostDto;
import ru.itis.deadathome.repositories.PostsRepository;

@Aspect
@Component
@Slf4j
public class PostAspect {

    @Autowired
    private PostsRepository postsRepository;

    @After(value = "execution(* ru.itis.deadathome.service.PostsService.getConcretePost(*))")
    public void after(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        PostDto post = PostDto.from(postsRepository.getOne((long)args[0]));
        log.info("Был запрошен пост " + post);
    }
}
