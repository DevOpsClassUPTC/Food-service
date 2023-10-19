package online.loschachos.foodService.mapper;

import online.loschachos.foodService.dto.FoodDTO;
import online.loschachos.foodService.entity.Food;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodMapper {

    FoodMapper INSTANCE = Mappers.getMapper(FoodMapper.class);

    Food mapFoodDTOToFood(FoodDTO foodDTO);

    FoodDTO mapFoodToFoodDTO(Food food);
}
