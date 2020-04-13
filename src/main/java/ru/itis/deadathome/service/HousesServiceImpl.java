package ru.itis.deadathome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.deadathome.dto.HouseCreationDto;
import ru.itis.deadathome.models.House;
import ru.itis.deadathome.models.HouseClass;
import ru.itis.deadathome.models.Location;
import ru.itis.deadathome.models.User;
import ru.itis.deadathome.repositories.HousesRepository;
import ru.itis.deadathome.repositories.LocationsRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class HousesServiceImpl implements HousesService {


    @Autowired
    private LocationsRepository locationsRepository;

    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    private HousesRepository housesRepository;

    @Override
    public List<House> getHouses() {
        return housesRepository.findAll();
    }

    @Override
    public House getConcreteHouse(String name) {
        Optional<House> houseOptional = housesRepository.findByNameIgnoreCase(name);
        return houseOptional.orElse(null);
    }

    @Override
    public House getConcreteHouse(Long houseId) {
        return housesRepository.getOne(houseId);
    }

    @Override
    public List<House> search(String name) {
        return housesRepository.search(name);
    }

    @Override
    public List<House> getOtherHouses(User user, Long houseId) {
        return housesRepository.findByCreatorAndIdIsNot(user, houseId);
    }

    @Override
    public Long create(HouseCreationDto houseDto) {
        Location location = Location.builder()
                .latitude(houseDto.getLatitude())
                .longitude(houseDto.getLongitude())
                .city(houseDto.getCity())
                .build();
        locationsRepository.save(location);

        House house = House.builder().
                name(houseDto.getHouseName())
                .houseClass(HouseClass.valueOf(houseDto.getHouseClass()))
                .createdAt(LocalDateTime.now())
                .description(houseDto.getDescription())
                .creator(houseDto.getUser())
                .fileInfo(fileStorageService.saveFile(houseDto.getFile()))
                .build();
        housesRepository.save(house);
        return house.getId();
    }
}
