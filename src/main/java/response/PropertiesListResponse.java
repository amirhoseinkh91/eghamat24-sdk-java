package response;

import entities.Property;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

/**
 * @author amir
 * @since 11/11/19
 */
@Getter
@Setter
public class PropertiesListResponse {

    private Integer total;
    private Collection<Property> properties;

}
