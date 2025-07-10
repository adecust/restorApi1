package controller;

import dto.RestaurantDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import services.RestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/{code}")
    public RestaurantDTO getRestaurant(@PathVariable Integer code) {
        return restaurantService.getRestaurant(code);
    }

    @PostMapping
    public RestaurantDTO addRestaurant(@RequestBody RestaurantDTO dto) {
        return restaurantService.addRestaurant(dto);
    }
}
