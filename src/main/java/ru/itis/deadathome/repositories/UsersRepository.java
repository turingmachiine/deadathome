package ru.itis.deadathome.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.deadathome.models.User;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByConfirmCode(String confirmCode);
    List<User> findAllByFirstNameOrLastNameContainsIgnoreCase(String firstName, String lastName);

}
