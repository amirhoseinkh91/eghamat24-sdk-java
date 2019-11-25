package entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

/**
 * @author amir
 * @since 11/9/19
 */
@Setter
@Getter
public class SuggestionRoom {

    private Integer roomTypeId;
    private String roomTypeName;
    private Integer roomTypeCapacity;
    private Integer roomTypeExtraCapacity;
    private Collection<RatePlan> ratePlans;

}
