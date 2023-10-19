package online.loschachos.foodService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long foodId;
    private String itemName;
    private String itemDescription;
    private boolean isVeg;
    private Double price;
    private Long restaurantId;
    private Integer quantity;


}
