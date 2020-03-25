package ru.itis.deadathome.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itis.deadathome.models.House;
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
}
