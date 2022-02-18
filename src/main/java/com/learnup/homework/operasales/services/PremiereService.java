package com.learnup.homework.operasales.services;

import com.learnup.homework.operasales.annotations.EmailNotify;
import com.learnup.homework.operasales.model.Premiere;
import org.springframework.stereotype.Service;

@Service
public class PremiereService {

    @EmailNotify
    public void addPremiere(String title, String description, String ageCategory, Integer capacity) {
        System.out.println("Добавление премьеры: " + title + " Описание: " + description + " " + ageCategory + " ( " + capacity + " зрителей)");
    }
    @EmailNotify
    public void setPremiere(String title, String description, String ageCategory, Integer capacity) {
        System.out.println("Изменение премьеры: " + title + " Описание: " + description + " " + ageCategory + " ( " + capacity + " зрителей)");
    }

    public void deletePremiere() {
        System.out.println("Удаление премьеры");
    }

    public void getPremiere() {
        Premiere premiere = new Premiere(Long.valueOf(1), "Название", "Описание", "6+", 100);
        System.out.println(premiere.getTitle()+" "+premiere.getDescription()+" "+premiere.getAgeCategory());
    }

    public void getPremiereList() {
        System.out.println("Список премьер");
        Premiere premiere = new Premiere(Long.valueOf(2), "Название 2", "Описание 2", "16+", 200);
        System.out.println(premiere.getTitle()+" "+premiere.getDescription()+" "+premiere.getAgeCategory());
    }
}
