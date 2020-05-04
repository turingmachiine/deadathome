package ru.itis.deadathome.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.deadathome.models.House;
import ru.itis.deadathome.models.Post;
import ru.itis.deadathome.models.User;

import java.util.List;
import java.util.Optional;

public interface PostsRepository extends JpaRepository<Post, Long>{
    Optional<Post> findByTitleIgnoreCase(String title);
    List<Post> findByAuthor(User author);
    Page<Post> findByHouse(House house, Pageable pageable);
    List<Post> findByHouseAndIdIsNot(House house, Long id);
}
