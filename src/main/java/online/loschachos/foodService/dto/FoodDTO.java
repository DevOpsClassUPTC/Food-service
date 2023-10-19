package online.loschachos.foodService.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodDTO {
    private Long foodId;
    private String itemName;
    private String itemDescription;
    private boolean isVeg;
    private Double price;
    private Long restaurantId;


}
