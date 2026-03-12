package vod.web.rest.dto;

import lombok.Data;

@Data
public class MascotDTO {
    private String name;
    private String photo;
    private int designerId;
    private float rating;
}
