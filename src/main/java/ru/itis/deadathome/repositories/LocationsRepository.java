package ru.itis.deadathome.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.deadathome.models.Location;

public interface LocationsRepository extends JpaRepository<Location, Long> {
}
