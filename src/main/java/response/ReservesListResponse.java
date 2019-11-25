package response;

import entities.ReserveDetails;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

/**
 * @author amir
 * @since 11/11/19
 */
@Getter
@Setter
public class ReservesListResponse {

    private Integer total;
    private Collection<ReserveDetails> reserves;

}
