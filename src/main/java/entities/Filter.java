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
public class Filter {

   private String name;
   private Collection<Operand> operand;
   private Integer creditAccountAmount;
   private String value;

}
