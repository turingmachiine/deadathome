package ru.itis.deadathome.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.itis.deadathome.dto.HousesDto;
import ru.itis.deadathome.repositories.HousesRepository;

import static ru.itis.deadathome.dto.HousesDto.from;

@Aspect
@Component
@Slf4j
public class HouseAspect {

    @Autowired
    private HousesRepository housesRepository;

    @After(value = "execution(* ru.itis.deadathome.service.HousesService.getConcreteHouse(*))")
    public void after(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        HousesDto house = from(housesRepository.getOne((long) args[0]));
        log.info("Был запрошен дом " + house);
    }
}
