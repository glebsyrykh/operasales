package com.learnup.homework.operasales.services;

import com.learnup.homework.operasales.annotations.EmailNotify;
import com.learnup.homework.operasales.entities.PremiereEntity;
import com.learnup.homework.operasales.mappers.MyMapper;
import com.learnup.homework.operasales.model.Premiere;
import com.learnup.homework.operasales.repository.JpaPremiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PremiereService {

    private JpaPremiereRepository repository;
    private MyMapper mapper;

    @Autowired
    public PremiereService(JpaPremiereRepository repository, MyMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @EmailNotify
    @Transactional
    public void addPremiere(String title, String description, String ageCategory, Integer capacity) {
        PremiereEntity newEntity = new PremiereEntity(null, title, description, ageCategory, capacity, 0);
        repository.save(newEntity);
    }

    @EmailNotify
    @Transactional
    public void setPremiere(PremiereEntity premiereEntity) {
        final PremiereEntity pr = repository.getById(premiereEntity.getId());
        repository.save(new PremiereEntity(premiereEntity.getId(), premiereEntity.getTitle(), premiereEntity.getDescription(), premiereEntity.getAgeCategory(), premiereEntity.getCapacity(), pr.getVersion()));
    }
    @Transactional
    public void deletePremiere(PremiereEntity premiereEntity) {
        repository.delete(premiereEntity);
    }

    public void printPremiere(Long id) {
        System.out.println(repository.findById(id));
    }

    public void printAll() {
        repository.findAll().forEach(System.out::println);
    }

    public PremiereEntity getbyId(Long id) {
        return repository.getById(id);
    }

    public List<Premiere> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}
