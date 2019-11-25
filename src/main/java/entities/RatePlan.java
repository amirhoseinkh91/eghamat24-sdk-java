package entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

/**
 * @author amir
 * @since 11/9/19
 */
@Getter
@Setter
public class RatePlan {

    private Integer id;
    private String name;
    private MealType mealTypeIncluded;
    private FoodBoardType foodBoardType;
    private Integer breakfastRate;
    private Integer halfBoardRate;
    private Integer fullBoardRate;
    private Boolean cancelable;
    private Integer sleeps;
    private Collection<FacilityDetails> facilities;
    private Collection<RatePlanPrice> prices;
    private Integer countryId;

}
