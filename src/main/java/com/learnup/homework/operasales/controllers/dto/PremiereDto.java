package com.learnup.homework.operasales.controllers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PremiereDto {
    @JsonProperty
    Long id;
    @JsonProperty
    String title;
    @JsonProperty
    String description;
    @JsonProperty
    String ageCategory;
    @JsonProperty
    Integer capacity;
}
