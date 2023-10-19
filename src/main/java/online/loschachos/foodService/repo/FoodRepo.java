package online.loschachos.foodService.repo;


import online.loschachos.foodService.entity.Food;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepo extends JpaRepository <Food, Long> {
    List<Food> findByRestaurantId(Long restaurantId);
}
