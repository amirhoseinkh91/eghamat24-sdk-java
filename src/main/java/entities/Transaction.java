package entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author amir
 * @since 11/9/19
 */
@Setter
@Getter
public class Transaction {

    private Integer reserveConfirmationCode;
    private String type;
    private Date paidDate;
    private Integer amount;
    private String description;
    private Date createDate;

}
