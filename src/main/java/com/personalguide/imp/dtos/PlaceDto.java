package com.personalguide.imp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceDto {

    private Integer id;

    private String title;

    private String description;

    private String imageSources;

    private String texts;
}
