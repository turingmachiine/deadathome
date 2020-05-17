package ru.itis.deadathome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.deadathome.dto.HouseCreationDto;
import ru.itis.deadathome.dto.HousesDto;
import ru.itis.deadathome.models.House;
import ru.itis.deadathome.models.HouseClass;
import ru.itis.deadathome.models.Location;
import ru.itis.deadathome.models.User;
import ru.itis.deadathome.repositories.HousesRepository;
import ru.itis.deadathome.repositories.LocationsRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static ru.itis.deadathome.dto.HousesDto.from;

@Service
public class HousesServiceImpl implements HousesService {


    @Autowired
    private LocationsRepository locationsRepository;

    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    private HousesRepository housesRepository;

    @Override
    public List<HousesDto> getHouses() {
        return from(housesRepository.findAll());
    }

    @Override
    public HousesDto getConcreteHouseByName(String name) {
        Optional<House> houseOptional = housesRepository.findByNameIgnoreCase(name);
        return houseOptional.map(HousesDto::from).orElse(null);
    }

    @Override
    public HousesDto getConcreteHouse(Long houseId) {
        return from(housesRepository.getOne(houseId));
    }


    @Override
    public List<HousesDto> search(String name) {
        return from(housesRepository.search(name));
    }

    @Override
    public List<HousesDto> getOtherHouses(User user, Long houseId) {
        return from(housesRepository.findByCreatorAndIdIsNot(user, houseId));
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
