package entities;

import lombok.Getter;
import lombok.Setter;

/**
 * @author amir
 * @since 11/9/19
 */
@Setter
@Getter
public class ReserveRoomGuests {

    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String passportNumber;
    private Integer countryId;
    private Integer cityId;

}
