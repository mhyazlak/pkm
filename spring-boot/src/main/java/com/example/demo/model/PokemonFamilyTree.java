package com.example.demo.model;

import com.example.demo.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokemonFamilyTree {
    private long id;
    private String name;
    private Type typeOne;
    private Type typeTwo;
    private String iconBase64;
    private String triggeredBy;
    private int stage;
    private List<PokemonFamilyTree> nextEvolutions = new ArrayList<>();  // Now a list

    public void addEvolution(PokemonFamilyTree evolution) {
        this.nextEvolutions.add(evolution);
    }
}