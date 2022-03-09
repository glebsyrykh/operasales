package com.learnup.homework.operasales.mappers;

import com.learnup.homework.operasales.entities.PremiereEntity;
import com.learnup.homework.operasales.entities.TicketEntity;
import com.learnup.homework.operasales.model.Premiere;
import com.learnup.homework.operasales.model.Ticket;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MyMapper {

    PremiereEntity toEntity(Premiere premiere);
    Premiere toDomain(PremiereEntity premiereEntity);

    TicketEntity toEntity(Ticket ticket);
    Ticket toDomain(TicketEntity ticketEntity);
}
