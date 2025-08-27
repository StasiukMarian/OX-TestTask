package org.ox.pojo.imageResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Breed {
    public Weight weight;
    public String id;
    public String name;
    public String cfa_url;
    public String vetstreet_url;
    public String vcahospitals_url;
    public String temperament;
    public String origin;
    public String country_codes;
    public String country_code;
    public String description;
    public String life_span;
    public Integer indoor;
    public String alt_names;
    public Integer adaptability;
    public Integer affection_level;
    public Integer child_friendly;
    public Integer dog_friendly;
    public Integer energy_level;
    public Integer grooming;
    public Integer health_issues;
    public Integer intelligence;
    public Integer shedding_level;
    public Integer social_needs;
    public Integer stranger_friendly;
    public Integer vocalisation;
    public Integer experimental;
    public Integer hairless;
    public Integer natural;
    public Integer rare;
    public Integer rex;
    public Integer suppressed_tail;
    public Integer short_legs;
    public String wikipedia_url;
    public Integer hypoallergenic;
    public String reference_image_id;
}
