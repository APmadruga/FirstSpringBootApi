package com.example.bootcamp.repository;
import org.springframework.stereotype.Repository;

@Repository
public class StatsRepository {
    String statsRepoString = "statsRepoString";

    public String getStatsRepoString() {
        return statsRepoString;
    }
}
