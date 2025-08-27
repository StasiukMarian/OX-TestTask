package org.ox.pojo.favourite;

import lombok.Data;

@Data
public class FavouriteByIdResponse {
    private Integer id;
    private String user_id;
    private String image_id;
    private String sub_id;
    private String created_at;
    private Image image;
}
