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
public class Reserve {

    private Integer propertyId;
    private Date checkIn;
    private Date checkOut;
    private String bookerFirstName;
    private String bookerLastName;
    private String bookerPhone;
    private String bookerEmail;
    private Vehicle vehicle;
    private String vehicleNumber;
    private String Description;
    private Collection<ReserveRoom> rooms;


}
