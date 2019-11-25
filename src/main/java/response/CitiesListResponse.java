package response;

import entities.City;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

/**
 * @author amir
 * @since 11/11/19
 */
@Getter
@Setter
public class CitiesListResponse {

    private Integer total;
    private Collection<City> cities;

}
