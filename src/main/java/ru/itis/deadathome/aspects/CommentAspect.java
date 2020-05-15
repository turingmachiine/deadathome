package ru.itis.deadathome.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import ru.itis.deadathome.dto.CommentAddDto;

@Aspect
@Component
@Slf4j
public class CommentAspect {

    @After(value = "execution(* ru.itis.deadathome.service.CommentsService.addComment(*))")
    public void after(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        CommentAddDto comment = (CommentAddDto) args[0];
        log.info("Пользователь - " + comment.getUser() + " Отправил коммент " + comment.getCommentText() +
                " к посту " + comment.getPost());
    }
}
