package com.example.demo.service.impl;

import com.example.demo.dao.PokemonDAO;
import com.example.demo.dto.PokemonDTO;
import com.example.demo.dto.PokemonTreeNodeDTO;
import com.example.demo.enums.Type;
import com.example.demo.model.PokemonFamilyTree;
import com.example.demo.model.Pokemon;
import com.example.demo.model.TypeStats;
import com.example.demo.service.IPokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PokemonServiceImpl implements IPokemonService {

    @Autowired
    PokemonDAO pokemonDAO;

    @Override
    @Transactional
    public Pokemon read(long id) {
        Pokemon pokemonDb = null;

        try {
            pokemonDb = new Pokemon(pokemonDAO.read(id));

        } catch (Exception e) {
            throw e;
        }
        return pokemonDb;
    }

    @Override
    public List<Pokemon> readAll(String search, String sortBy, Type[] selectedTypes) {
        List<PokemonDTO> pokemonDtoList = pokemonDAO.readAll(search, sortBy, selectedTypes);

        return pokemonDtoList.stream()
                .map(pokemonDto -> {
                    Pokemon pokemon = new Pokemon(pokemonDto);
                    return pokemon;
                })
                .collect(Collectors.toList());
    }

    @Override
    public TypeStats readTypeStats(Type type) {
        return pokemonDAO.readTypeStats(type);
    }

    @Override
    public PokemonFamilyTree readFamilyTree(long id) {
        List<PokemonTreeNodeDTO> familyTreeDTOList = pokemonDAO.readFamilyTree(id);

        // Convert DTO to tree node
        List<PokemonFamilyTree> nodes = familyTreeDTOList.stream()
                .map(dto -> new PokemonFamilyTree(dto.getId(), dto.getName(), dto.getTypeOne(), dto.getTypeTwo(), dto.getIconB64(), dto.getTriggeredBy(), dto.getStage(), new ArrayList<>()))
                .collect(Collectors.toList());

        // Use a map for faster lookup
        Map<Long, PokemonFamilyTree> nodeMap = nodes.stream()
                .collect(Collectors.toMap(PokemonFamilyTree::getId, node -> node));

        // Just take the first entry as the root
        PokemonFamilyTree root = nodes.get(0);

        // Construct the evolution tree
        constructEvolutionTree(root, nodeMap);

        return root;
    }

    @Override
    public List<PokemonTreeNodeDTO> readFamilyTreeFlat(long id) {
        return pokemonDAO.readFamilyTree(id);
    }


    private void constructEvolutionTree(PokemonFamilyTree current, Map<Long, PokemonFamilyTree> nodeMap) {
        if (current == null) return;

        // Find all Pokémon that evolve from the current Pokémon and add them to the tree
        for (PokemonFamilyTree potentialEvolution : nodeMap.values()) {
            if (current.getStage() - potentialEvolution.getStage() == -1) {
                current.addEvolution(potentialEvolution);
                constructEvolutionTree(potentialEvolution, nodeMap); // Recursively add evolutions for this Pokémon
            }
        }
    }

}
