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
public class RoomType {

    private Integer id;
    private String name;
    private String type;
    private Integer capacity;
    private Integer extraCapacity;
    private Integer singleBedCount;
    private Integer doubleBedCount;
    private Integer sofaBedCount;
    private Boolean outOfService;
    private Collection<FacilityDetails> facilities;
    private Collection<RatePlanDetails> ratePlans;
    private String description;

}
