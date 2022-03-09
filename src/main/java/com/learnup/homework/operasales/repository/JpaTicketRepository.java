package com.learnup.homework.operasales.repository;

import com.learnup.homework.operasales.entities.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaTicketRepository extends JpaRepository<TicketEntity, Long> {
}
