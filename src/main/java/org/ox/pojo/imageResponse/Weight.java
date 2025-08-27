package org.ox.pojo.imageResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weight {
    private String imperial;
    private String metric;
}
