package com.learnup.homework.operasales.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Data
public class Premiere {
    private Long id;
    private String title;
    private String description;
    private String ageCategory;
    private Integer capacity;
}
