package com.example.bootcamp.controller;
import com.example.bootcamp.model.SuperPower;
import com.example.bootcamp.service.SuperPowerService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class SuperPowerController {

    SuperPowerService superPowerService;

    public SuperPowerController(SuperPowerService superPowerService) {
        this.superPowerService = superPowerService;
    }

    @GetMapping("/super-powers")
    public List<SuperPower> getSuperPowers() {
        return superPowerService.findAll();
    }
}
