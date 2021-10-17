package com.example.bootcamp.controller;
import com.example.bootcamp.model.Hero;
import com.example.bootcamp.service.HeroService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping("/api")
@Validated
public class HeroController {

    HeroService heroService;

    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping("/heroes")
    public List<Hero> getHeroes() {
        return heroService.findAll();
    }
}