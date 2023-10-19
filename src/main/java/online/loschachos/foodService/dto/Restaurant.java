package online.loschachos.foodService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {

    private Long id;
    private String name;
    private String addres;
    private String city;
    private String restaurantDescription;
    
}
