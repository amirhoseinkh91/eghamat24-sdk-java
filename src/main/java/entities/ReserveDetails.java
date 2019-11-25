package entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.Date;

/**
 * @author amir
 * @since 11/9/19
 */
@Setter
@Getter
public class ReserveDetails {

    private Integer propertyId;
    private Date checkIn;
    private Date checkOut;
    private String bookerFirstName;
    private String bookerLastName;
    private String bookerPhone;
    private String bookerEmail;
    private Vehicle vehicle;
    private String vehicleNumber;
    private ReserveDetailsStatus status;
    private ReserveDetailsState state;
    private String confirmationCode;
    private String propertyConfirmationCode;
    // TODO: 11/9/19 totalCancellationFee
    // TODO: 11/9/19 totalModificationFee
    private Integer totalPrice;
    private Integer totalDailyPrice;
    private Integer totalSalesPrice;
    private Collection<PriceDetails> priceDetails;
    private Collection<ReserveRoom> rooms;
    private String Description;
    private Date createDate;
    private Date expireDate;
    private Date cancelDate;
    private Date definiteDate;
    // TODO: 11/9/19 check this:
    private Collection<ReserveRoomDetails> rooms2;

}
