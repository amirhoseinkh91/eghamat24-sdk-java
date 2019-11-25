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
public class RoomRate {

    private Integer propertyId;
    private Integer roomTypeId;
    private String roomTypeName;
    private Collection<RatePlan> ratePlans;

}
