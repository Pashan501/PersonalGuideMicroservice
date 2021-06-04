package com.personalguide.imp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodDto {

    private Integer id;

    private String title;

    private String description;

    private String imageSources;

    private String texts;
}
