package com.learnup.homework.operasales.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Premiere {
    private Long Id;
    private String title;
    private String description;
    private String ageCategory;
    private Integer capacity;
}
