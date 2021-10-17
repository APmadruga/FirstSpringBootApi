package com.example.bootcamp.controller;
import com.example.bootcamp.service.ChampionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChampionController {

    ChampionService championService;

    public ChampionController(ChampionService championService) {
        this.championService = championService;
    }

    @GetMapping(value = "/champion")
    public String getChampionOverview(){
        System.out.println(championService.getBothStrings());
        return championService.getBothStrings();
    }
}
