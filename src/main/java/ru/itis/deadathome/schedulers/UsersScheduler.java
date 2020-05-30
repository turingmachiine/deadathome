package ru.itis.deadathome.schedulers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import ru.itis.deadathome.dto.UserDto;
import ru.itis.deadathome.service.UsersService;

import javax.transaction.Transactional;
import java.util.List;

@Configuration
@EnableScheduling
@Slf4j
public class UsersScheduler {

    @Autowired
    private UsersService usersService;

    @Scheduled(cron="* */40 * * * *")
    public void run() {
        List<UserDto> users = usersService.getUsers();
        System.out.println("Current list of users:");
        for (UserDto user: users) {
            System.out.println(user.toString());
        }
    }
}
