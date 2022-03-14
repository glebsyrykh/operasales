package com.learnup.homework.operasales.controllers;

import com.learnup.homework.operasales.controllers.dto.PremiereDto;
import com.learnup.homework.operasales.controllers.dto.TicketDto;
import com.learnup.homework.operasales.mappers.MyMapper;
import com.learnup.homework.operasales.model.Premiere;
import com.learnup.homework.operasales.model.Ticket;
import com.learnup.homework.operasales.services.PremiereService;
import com.learnup.homework.operasales.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {
    private TicketService ticketService;
    private MyMapper mapper;

    @Autowired
    public TicketController(TicketService ticketService, MyMapper mapper) {
        this.ticketService = ticketService;
        this.mapper = mapper;
    }

    @PostMapping
    public Long buy(@RequestBody TicketDto ticketDto) {
        return ticketService.buyTicket(mapper.toDomain(ticketDto));
    }

    @DeleteMapping("/{id}")
    public void refund(@PathVariable("id") Long id) {
        ticketService.refundTicket(id);
    }

}
