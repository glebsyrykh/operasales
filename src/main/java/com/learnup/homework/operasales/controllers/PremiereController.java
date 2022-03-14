package com.learnup.homework.operasales.controllers;

import com.learnup.homework.operasales.controllers.dto.PremiereDto;
import com.learnup.homework.operasales.mappers.MyMapper;
import com.learnup.homework.operasales.model.Premiere;
import com.learnup.homework.operasales.services.PremiereService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/v1/premiere")
@Slf4j
public class PremiereController {
    private PremiereService premiereService;
    private MyMapper mapper;

    @Autowired
    public PremiereController(PremiereService premiereService, MyMapper mapper) {
        this.premiereService = premiereService;
        this.mapper = mapper;
    }

    @PostMapping
    public Long add(@RequestBody PremiereDto premiereDto) {
        return premiereService.addPremiere(mapper.toDomain(premiereDto));
    }

    @PutMapping("/{id}")
    public void set(@PathVariable("id") Long id, @RequestBody PremiereDto premiereDto) {
        premiereService.setPremiere(mapper.toDomain(premiereDto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        premiereService.deleteById(id);
    }

    @GetMapping("/{id}")
    public PremiereDto get(@PathVariable("id") Long id) {
        return mapper.toDto(premiereService.get(id));
    }

    @GetMapping
    public Collection<PremiereDto> getAll () {
        List<Premiere> premiereList = premiereService.getAll();
        log.info(String.valueOf(premiereList.size()) + " премьер");
        return premiereList.stream().map(mapper::toDto).collect(toList());
    }
}
