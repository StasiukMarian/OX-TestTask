package org.ox.pojo.imageResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weight {
    public String imperial;
    public String metric;
}
