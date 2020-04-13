package ru.itis.deadathome.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.deadathome.models.House;
import ru.itis.deadathome.models.User;

import java.util.List;
import java.util.Optional;

public interface HousesRepository extends JpaRepository<House, Long> {
    Optional<House> findByNameIgnoreCase(String name);
    List<House> findByNameContainsIgnoreCase(String name);
    List<House> findByCreator(User creator);
    List<House> findByCreatorAndIdIsNot(User creator, Long id);

    @Query("from House house where " +
    "upper(house.name) like  concat('%', upper(:query), '%' )")
    List<House> search(@Param("query") String query);
}
