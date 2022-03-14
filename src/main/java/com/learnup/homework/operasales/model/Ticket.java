package com.learnup.homework.operasales.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Data
public class Ticket {
    private Long id;
    private Premiere premiere;
    private Integer place;
    private Integer row;
}
