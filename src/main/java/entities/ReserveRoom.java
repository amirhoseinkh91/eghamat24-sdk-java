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
public class ReserveRoom {

    private Integer roomTypeId;
    private Integer ratePlanId;
    private Integer count;
    private Integer adultCount;
    private Collection<Integer> children;
    private String guestFirstName;
    private String guestLastName;
    private String guestPhone;
    private String guestEmail;
    private String guestNationalCode;
    private String guestPassportNumber;
    private Integer guestCountryId;
    private Integer guestCityId;
    private Collection<ReserveRoomGuests> guests;
    private Collection<ReserveRoomPrice> prices;
    private Collection<RoomType> roomType;
    private Collection<RatePlan> ratePlan;

}
