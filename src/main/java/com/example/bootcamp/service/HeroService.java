package com.example.bootcamp.service;
import com.example.bootcamp.model.Hero;
import com.example.bootcamp.repository.HeroRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HeroService  {

    HeroRepository heroRepository;

    public HeroService(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }


    public List<Hero> findAll() {
        return heroRepository.findAll();
    }
}
