package ru.itis.deadathome.service;

import ru.itis.deadathome.dto.HouseCreationDto;
import ru.itis.deadathome.dto.HousesDto;
import ru.itis.deadathome.models.House;
import ru.itis.deadathome.models.User;

import java.util.List;

public interface HousesService {
    List<HousesDto> getHouses();

    HousesDto getConcreteHouse(String name);

    HousesDto getConcreteHouse(Long houseId);

    List<HousesDto> search(String name);

    List<HousesDto> getOtherHouses(User user, Long houseId);

    Long create(HouseCreationDto houseDto);

}
