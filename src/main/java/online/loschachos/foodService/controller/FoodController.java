package online.loschachos.foodService.controller;

import online.loschachos.foodService.dto.FoodCataloguePage;
import online.loschachos.foodService.dto.FoodDTO;
import online.loschachos.foodService.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
@CrossOrigin
public class FoodController {

    @Autowired
    FoodService foodService;

    @GetMapping("/fetchAllFood")
    public ResponseEntity<List<FoodDTO>> fetchAllFood() {
        List<FoodDTO> allUsers = foodService.findAllFood();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @PostMapping("/addFood")
    public ResponseEntity<FoodDTO> saveFood(@RequestBody FoodDTO foodDTO) {
        FoodDTO userAdded = foodService.addFoodinDB(foodDTO);
        return new ResponseEntity<>(userAdded, HttpStatus.CREATED);
    }

    @GetMapping("/fetchByID/{id}")
    public ResponseEntity<FoodDTO> findFoodById(@PathVariable Long id) {
        return foodService.fetchFoodById(id);
    }

    @GetMapping("/food_catalogue/{restaurantId}")
    public ResponseEntity<FoodCataloguePage> foodCatalogue(@PathVariable Long restaurantId) {
        return new ResponseEntity<>(foodService.cataloguePage(restaurantId), HttpStatus.CREATED);
    }

}
