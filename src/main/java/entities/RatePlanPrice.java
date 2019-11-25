package entities;

import lombok.Getter;
import lombok.Setter;

/**
 * @author amir
 * @since 11/9/19
 */
@Getter
@Setter
public class RatePlanPrice {

    private String day;
    private Integer inventory;
    private Integer rackRate;
    private Integer dailyRate;
    private Integer grsRate;
    private Integer babyCotRackRate;
    private Integer babyCotDailyRate;
    private Integer babyCotGrsRate;
    private Integer extendBedRackRate;
    private Integer extendBedDailyRate;
    private Integer extendBedGrsRate;
    private String reservationState;
    private Integer minStay;
    private Integer maxStay;
    private Boolean closed;

}
