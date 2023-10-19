package online.loschachos.foodService.dto;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import online.loschachos.foodService.entity.Food;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class FoodCataloguePage {
   private List<Food> foodList;
   private Restaurant restaurant;
}
