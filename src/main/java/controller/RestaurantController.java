package controller;

import dto.request.RestaurantRequest;
import dto.response.RestaurantResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.RestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/{code}")
    public ResponseEntity<RestaurantResponse> getRestaurant(@PathVariable Integer code) {
        RestaurantResponse response = restaurantService.getRestaurant(code);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<RestaurantResponse> addRestaurant(@Valid @RequestBody RestaurantRequest request) {
        RestaurantResponse response = restaurantService.addRestaurant(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
