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
public class ReserveDetailsResponse {

    private ReserveDetails reserve;
    private Collection<ReserveDetails> relatedReserves;


}
