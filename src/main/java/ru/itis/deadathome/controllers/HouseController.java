package ru.itis.deadathome.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itis.deadathome.dto.HouseCreationDto;
import ru.itis.deadathome.models.House;
import ru.itis.deadathome.models.HouseClass;
import ru.itis.deadathome.models.User;
import ru.itis.deadathome.security.UserDetailsImpl;
import ru.itis.deadathome.service.HousesService;

import java.util.List;

@Controller
public class HouseController {

    @Autowired
    HousesService housesService;

    @GetMapping("/houses")
    public String getHousesPage(Model model, Authentication authentication) {
        if (authentication != null) {
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            model.addAttribute("user", userDetails.getUser());
        }
        List<House> houses = housesService.getHouses();
        model.addAttribute("houses", houses);
        return "houses";
    }

    @GetMapping("/house{house-id}")
    public String getConcreteHousePage(@PathVariable("house-id") Long houseId, Authentication authentication,
                                       Model model) {
        if (authentication != null) {
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            model.addAttribute("user", userDetails.getUser());
        }
        House house = housesService.getConcreteHouse(houseId);
        model.addAttribute("house", house);
        model.addAttribute("otherHouses", housesService.getOtherHouses(house.getCreator(), houseId));
        return "house";
    }

    @GetMapping("/create_house")
    public String getCreateHousePage(Authentication authentication, Model model) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        model.addAttribute("user", userDetails.getUser());
        model.addAttribute("classes", HouseClass.values());
        return "create_house";
    }

    @PostMapping("/create_house")
    public String createHouse(Authentication authentication, HouseCreationDto houseDto) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.getUser();
        houseDto.setUser(user);
        Long id = housesService.create(houseDto);
        return "redirect:/house" + id;
    }

    @GetMapping("/searchHouses")
    @ResponseBody
    public List<House> searchHouses(@RequestParam("name") String name) {
        return housesService.search(name);
    }
}
