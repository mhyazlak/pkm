package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "EVOLUTION_CHAIN_VIEW")
@AllArgsConstructor
@NoArgsConstructor
public class EvolutionChainDTO {

    @Id
    @Column(name = "id")
    @JsonProperty("id")
    private Long id;

    @Column(name = "pokemon_name")
    @JsonProperty("pokemon_name")
    private String pokemonName;

    @Column(name = "stage")
    @JsonProperty("stage")
    private int stage;

    @Column(name = "stage_one")
    @JsonProperty("stage_one")
    private String stageOne;

    @Column(name = "stage_two")
    @JsonProperty("stage_two")
    private String stageTwo;

    @Column(name = "stage_three")
    @JsonProperty("stage_three")
    private String stageThree;

    @Column(name = "triggeredBy")
    @JsonProperty("triggeredBy")
    private String triggeredBy;
}
