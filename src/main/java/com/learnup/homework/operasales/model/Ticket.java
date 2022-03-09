package com.learnup.homework.operasales.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Ticket {
    private Long Id;
    private Long premiereId;
    private Integer place;
    private Integer row;
}
