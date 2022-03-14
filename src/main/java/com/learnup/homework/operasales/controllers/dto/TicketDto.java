package com.learnup.homework.operasales.controllers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketDto {
    @JsonProperty
    Long id;
    @JsonProperty
    PremiereDto premiere;
    @JsonProperty
    Integer place;
    @JsonProperty
    Integer row;
}
