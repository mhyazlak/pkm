package com.example.demo.model;

import com.example.demo.dto.EvolutionChainDTO;
import com.example.demo.dto.PokemonDTO;
import com.example.demo.enums.Type;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pokemon {

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    @Enumerated(EnumType.STRING)
    @JsonProperty("type_one")
    private Type typeOne;

    @Enumerated(EnumType.STRING)
    @JsonProperty("type_two")
    private Type typeTwo;

    @JsonProperty("base_hp")
    private int baseHp;

    @JsonProperty("base_atk")
    private int baseAtk;

    @JsonProperty("base_def")
    private int baseDef;

    @JsonProperty("base_spa")
    private int baseSpa;

    @JsonProperty("base_spd")
    private int baseSpd;

    @JsonProperty("base_spe")
    private int baseSpe;

    @JsonProperty("base_total")
    private int baseTotal;

    @JsonProperty("sprite")
    private String sprite;

    @JsonProperty("icon_b64")
    private String icon_b64;

    @JsonProperty("stage")
    private int stage;

    public Pokemon(PokemonDTO pokemonDTO) {
        this.id = pokemonDTO.getId();
        this.name = pokemonDTO.getName();
        this.typeOne = pokemonDTO.getTypeOne();
        this.typeTwo = pokemonDTO.getTypeTwo();
        this.baseHp = pokemonDTO.getBaseHp();
        this.baseAtk = pokemonDTO.getBaseAtk();
        this.baseDef = pokemonDTO.getBaseDef();
        this.baseSpa = pokemonDTO.getBaseSpa();
        this.baseSpd = pokemonDTO.getBaseSpd();
        this.baseSpe = pokemonDTO.getBaseSpe();
        this.baseTotal = pokemonDTO.getBaseTotal();
        this.sprite = pokemonDTO.getSprite();
        this.icon_b64 = pokemonDTO.getIcon_b64();
        this.stage = pokemonDTO.getStage();
    }
}
