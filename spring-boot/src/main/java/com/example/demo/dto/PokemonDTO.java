package com.example.demo.dto;

import com.example.demo.enums.Type;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Pokemon")
@AllArgsConstructor
@NoArgsConstructor
public class PokemonDTO {

    @Id
    @Column(name = "id", nullable = false)
    @JsonProperty("id")
    private long id;

    @Column(name = "name", nullable = false)
    @JsonProperty("name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_one", nullable = false)
    @JsonProperty("type_one")
    private Type typeOne;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_two", nullable = true) // This should be nullable as not every Pokemon has a second type
    @JsonProperty("type_two")
    private Type typeTwo;

    @Column(name = "base_hp", nullable = false)
    @JsonProperty("base_hp")
    private int baseHp;

    @Column(name = "base_atk", nullable = false)
    @JsonProperty("base_atk")
    private int baseAtk;

    @Column(name = "base_def", nullable = false)
    @JsonProperty("base_def")
    private int baseDef;

    @Column(name = "base_spa", nullable = false)
    @JsonProperty("base_spa")
    private int baseSpa;

    @Column(name = "base_spd", nullable = false)
    @JsonProperty("base_spd")
    private int baseSpd;

    @Column(name = "base_spe", nullable = false)
    @JsonProperty("base_spe")
    private int baseSpe;

    @Column(name = "base_total", nullable = false)
    @JsonProperty("base_total")
    private int baseTotal;

    @Column(name = "pokemon_display_sprite", nullable = false)
    @JsonProperty("sprite")
    private String sprite;

    @Column(name = "pokemon_icon_b64", nullable = false)
    @JsonProperty("icon_b64")
    private String pokemon_icon_b64;
}
