package com.eazybytes.controller;

import com.eazybytes.model.Cards;
import com.eazybytes.repository.CardsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardsController {

    private final CardsRepository repository;

    public CardsController(CardsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/myCards")
    public List<Cards> getLoanDetails(@RequestParam int id){
        List<Cards> cards = repository.findByCustomerId(id);
        if (cards != null){
            return cards;
        } else{
            return null;
        }
    }

}
