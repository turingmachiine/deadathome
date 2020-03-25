package ru.itis.deadathome.service;

import ru.itis.deadathome.models.House;
import ru.itis.deadathome.models.User;

import java.util.List;

public interface HousesService {
    List<House> getHouses();

    House getConcreteHouse(Long houseId);

    List<House> search(String name);

    List<House> getOtherHouses(User user, Long houseId);

}
