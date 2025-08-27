package org.ox.pojo.imageResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageResponse {
    private ArrayList<Breed> breeds;
    private String id;
    private String url;
    private Integer width;
    private Integer height;
}
