package entities;

import lombok.Getter;
import lombok.Setter;

/**
 * @author amir
 * @since 11/9/19
 */
@Setter
@Getter
public class Rule {

   private String name;
   private RuleType type;
   private RuleCategory category;
   private String description;

}
