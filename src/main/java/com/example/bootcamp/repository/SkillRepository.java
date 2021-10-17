package com.example.bootcamp.repository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component()
public class SkillRepository {
    String skillRepoString = "statsRepoString";
    String urlFromYML;

    public SkillRepository(@Value("${spring.datasource.url}") String url) {
        urlFromYML = url ;
    }

    public String getSkillRepoString() {
        return skillRepoString;
    }
}
