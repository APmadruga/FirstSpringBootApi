package com.example.bootcamp.service;
import com.example.bootcamp.repository.SkillRepository;
import com.example.bootcamp.repository.StatsRepository;
import org.springframework.stereotype.Service;

@Service
public class ChampionService {

    private final SkillRepository skillRepository;
    private final StatsRepository statsRepository;

    public ChampionService(SkillRepository skillRepository, StatsRepository statsRepository) {
        this.skillRepository = skillRepository;
        this.statsRepository = statsRepository;
    }


    //for example with no autowired
    public String getBothStrings(){
        return skillRepository.getSkillRepoString() + statsRepository.getStatsRepoString();
    }
}
