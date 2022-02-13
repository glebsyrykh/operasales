package com.learnup.homework.operasales.services;

import com.learnup.homework.operasales.model.Premiere;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PremiereService {

    private Premiere premiere;
    private List<Premiere> premiereList;

    public Premiere addPremiere(String title, String description, String ageCategory, Integer capacity) {
        Random random = new Random();
        premiere = new Premiere(random.nextLong(), title, description, ageCategory, capacity);
        if (premiereList == null || premiereList.size() == 0) {
            premiereList = new ArrayList<>();
        }
        premiereList.add(premiere);
        return premiere;
    }

    public void setPremiere(String title, String description, String ageCategory, Integer capacity) {
        premiere.setTitle(title);
        premiere.setDescription(description);
        premiere.setAgeCategory(ageCategory);
        premiere.setCapacity(capacity);
    }

    public void deletePremiere() {
        premiereList.remove(premiere);
    }

    public Premiere getPremiere() {
        System.out.println(premiere.getTitle()+" "+premiere.getDescription()+" "+premiere.getAgeCategory());
        return premiere;
    }

    public void getPremiereList() {
        for (Premiere premiere : premiereList) {
            System.out.println(premiere.getTitle()+" "+premiere.getDescription()+" "+premiere.getAgeCategory());
        }
    }
}
