package online.loschachos.foodService.service;

import lombok.AllArgsConstructor;
import online.loschachos.foodService.dto.FoodCataloguePage;
import online.loschachos.foodService.dto.FoodDTO;
import online.loschachos.foodService.dto.Restaurant;
import online.loschachos.foodService.entity.Food;
import online.loschachos.foodService.mapper.FoodMapper;
import online.loschachos.foodService.repo.FoodRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class FoodService {
    @Autowired
    FoodRepo foodRepo;

    private final RestTemplate restTemplate;

    public List<FoodDTO> findAllFood() {
        List<Food> users = foodRepo.findAll();
        return users.stream().map(FoodMapper.INSTANCE::mapFoodToFoodDTO).collect(Collectors.toList());
    }

    public FoodDTO addFoodinDB(FoodDTO userDTO) {
        Food saveUser = foodRepo.save(FoodMapper.INSTANCE.mapFoodDTOToFood(userDTO));
        return FoodMapper.INSTANCE.mapFoodToFoodDTO(saveUser);
    }

    public ResponseEntity<FoodDTO> fetchFoodById(Long id) {
        Optional<Food> user = foodRepo.findById(id);
        if (user.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<FoodDTO>(FoodMapper.INSTANCE.mapFoodToFoodDTO(user.get()), HttpStatus.OK);
    }

    public FoodCataloguePage cataloguePage(Long restaurant_id) {
        FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
        List<Food> foodList = foodRepo.findByRestaurantId(restaurant_id);

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString("http://RESTAURANT-SERVICE/restaurant/findRestaurantById")
                .queryParam("id", restaurant_id); // Agregar el ID como parámetro de consulta

        String url = builder.toUriString();
        ResponseEntity<Restaurant> responseEntity = restTemplate
                .getForEntity(url, Restaurant.class);

        Restaurant restaurant = responseEntity.getBody();

        foodCataloguePage.setFoodList(foodList);
        foodCataloguePage.setRestaurant(restaurant);

        return foodCataloguePage;
    }

}
