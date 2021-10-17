package com.example.bootcamp.model;
import javax.persistence.*;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "hero")
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotNull
    @NotEmpty
    private String alias;

    @Min(value = 1)
    @Max(value = 99)
    private int age;

    @ManyToOne
    @JoinColumn(name = "id_country")
    private Country country;

    @ManyToMany(mappedBy = "superPowersToHeroes")
    Set<SuperPower> heroSuperPowers;


}
