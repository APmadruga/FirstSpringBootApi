package com.example.bootcamp.service;
import com.example.bootcamp.model.SuperPower;
import com.example.bootcamp.repository.SuperPowerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SuperPowerService{

    SuperPowerRepository superPowerRepository;

    public SuperPowerService(SuperPowerRepository superPowerRepository) {
        this.superPowerRepository = superPowerRepository;
    }


    public List<SuperPower> findAll() {
        return superPowerRepository.findAll();
    }
}
