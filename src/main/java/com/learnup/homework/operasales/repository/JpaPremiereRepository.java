package com.learnup.homework.operasales.repository;

import com.learnup.homework.operasales.entities.PremiereEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPremiereRepository extends JpaRepository<PremiereEntity, Long> {
    PremiereEntity getById(Long Id);
}
