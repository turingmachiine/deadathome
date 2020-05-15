package ru.itis.deadathome.aspects;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import ru.itis.deadathome.dto.SignUpDto;

@Aspect
@Component
@Slf4j
public class SignUpAspect {

    @Before(value = "execution(* ru.itis.deadathome.service.SignUpService.signUp(*))")
    public void before(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        SignUpDto user = (SignUpDto) args[0];
        log.info("Пользователь - " + user + " начал регистрацию");
    }

    @After(value = "execution(* ru.itis.deadathome.service.SignUpService.signUp(*))")
    public void after(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        SignUpDto user = (SignUpDto) args[0];
        log.info("Пользователь - " + user + " завершил регистрацию");
    }

}
