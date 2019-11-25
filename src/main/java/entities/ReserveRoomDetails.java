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
public class ReserveRoomDetails {

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
    // TODO: 11/9/19 totalCancellationFee
    // TODO: 11/9/19 totalModificationFee
    private Integer totalPrice;
    private Integer totalDailyPrice;
    private Integer totalSalesPrice;

}
