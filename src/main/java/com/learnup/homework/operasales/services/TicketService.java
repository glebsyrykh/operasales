package com.learnup.homework.operasales.services;

import com.learnup.homework.operasales.entities.PremiereEntity;
import com.learnup.homework.operasales.entities.TicketEntity;
import com.learnup.homework.operasales.mappers.MyMapper;
import com.learnup.homework.operasales.repository.JpaPremiereRepository;
import com.learnup.homework.operasales.repository.JpaTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TicketService {

    public JpaTicketRepository repository;
    public MyMapper mapper;
    public JpaPremiereRepository premiereRepository;

    @Autowired
    public TicketService(JpaTicketRepository repository, MyMapper mapper, JpaPremiereRepository premiereRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.premiereRepository = premiereRepository;
    }

    @Transactional
    public Long buyTicket(Long premiereId, Integer place, Integer row) {
        PremiereEntity premiere = premiereRepository.getById(premiereId);
        TicketEntity ticketEntity = repository.save(new TicketEntity(null, premiere, place, row, 0));
        premiereRepository.save(new PremiereEntity(premiere.getId(), premiere.getTitle(), premiere.getDescription(), premiere.getAgeCategory(), premiere.getCapacity()-1, premiere.getVersion()));
        return ticketEntity.getId();
    }

    public void refundTicket(Long ticketId) {
        TicketEntity ticketEntity = repository.getById(ticketId);
        System.out.println(ticketEntity.getPremiere());
        PremiereEntity premiere = premiereRepository.getById(ticketEntity.getPremiere().getId());
        premiereRepository.save(new PremiereEntity(premiere.getId(), premiere.getTitle(), premiere.getDescription(), premiere.getAgeCategory(), premiere.getCapacity()+1, premiere.getVersion()));
        repository.deleteById(ticketId);
    }

    public TicketEntity getById(Long id) {
        return repository.getById(id);
    }
}
