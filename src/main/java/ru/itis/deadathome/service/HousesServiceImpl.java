package ru.itis.deadathome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.deadathome.models.House;
import ru.itis.deadathome.models.User;
import ru.itis.deadathome.repositories.HousesRepository;

import java.util.List;

@Service
public class HousesServiceImpl implements HousesService {

    @Autowired
    HousesRepository housesRepository;

    @Override
    public List<House> getHouses() {
        return housesRepository.findAll();
    }

    @Override
    public House getConcreteHouse(Long houseId) {
        return housesRepository.getOne(houseId);
    }

    @Override
    public List<House> search(String name) {
        return null;
    }

    @Override
    public List<House> getOtherHouses(User user, Long houseId) {
        return housesRepository.findByCreatorAndIdIsNot(user, houseId);
    }
}
