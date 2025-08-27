package org.ox.pojo.imageResponse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImageResponse {
    public ArrayList<Breed> breeds;
    public String id;
    public String url;
    public Integer width;
    public Integer height;
}
