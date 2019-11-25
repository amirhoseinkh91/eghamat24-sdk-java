package response;

import lombok.Getter;
import lombok.Setter;
import entities.Error;

import java.util.Collection;

/**
 * @author amir
 * @since 11/9/19
 */
@Getter
@Setter
public class ResponseSchema<T> {

    private Integer code;
    private String message;
    private Collection<Error> errors;
    private T value;
}
