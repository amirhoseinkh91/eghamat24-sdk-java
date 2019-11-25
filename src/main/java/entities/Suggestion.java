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
public class Suggestion {

    private Integer propertyId;
    private String propertyName;
    private Collection<SuggestionRoom> rooms;

}
