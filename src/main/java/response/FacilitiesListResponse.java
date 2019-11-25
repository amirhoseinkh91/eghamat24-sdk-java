package response;

import entities.Facility;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

/**
 * @author amir
 * @since 11/11/19
 */
@Getter
@Setter
public class FacilitiesListResponse {

    private Integer total;
    private Collection<Facility> facilities;

}
