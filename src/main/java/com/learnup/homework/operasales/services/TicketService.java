package com.learnup.homework.operasales.services;

import com.learnup.homework.operasales.annotations.EmailNotify;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    @EmailNotify
    public void buyTicket(Long premiereId, Integer place, Integer row) {
        System.out.println("Покупаем билет: место "+place+", ряд "+ row);
    }

    public void refundTicket(Long ticketId) {
        System.out.println("Возвращаем билет "+ticketId);
    }
}
