package com.example.bootcamp.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name= "superPower")
public class SuperPower {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Min(value = 1)
    @Max(value = 99)
    private int spRange;

    @Min(value = 1)
    @Max(value = 99)
    private int damage;

    @ManyToMany
    @JoinTable(
            name = "superPowerMtMHeroTable",
            joinColumns = @JoinColumn(name = "superPower_id"),
            inverseJoinColumns = @JoinColumn(name = "hero_id"))
    Set<Hero> superPowersToHeroes;
}
