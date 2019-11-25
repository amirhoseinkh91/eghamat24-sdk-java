package entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

/**
 * @author amir
 * @since 11/9/19
 */
@Getter
@Setter
public class Property {

    private Integer id;
    private String name;
    private String type;
    private Integer star;
    private String grade;
    private Integer provinceId;
    private Integer cityId;
    private Double latitude;
    private Double longitude;
    private String address;
    private Integer roomCount;
    private Collection<FacilityDetails> facilities;
    private Collection<File> images;
    private String description;
    private Collection<Rule> rules;

}
