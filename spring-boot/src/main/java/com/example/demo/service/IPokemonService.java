package com.example.demo.service;

import com.example.demo.dto.PokemonTreeNodeDTO;
import com.example.demo.enums.Type;
import com.example.demo.model.PokemonFamilyTree;
import com.example.demo.model.Pokemon;
import com.example.demo.model.TypeStats;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPokemonService {

    Pokemon read(long id);

    List<Pokemon> readAll(String search, String sortBy, Type[] selectedTypes);

    TypeStats readTypeStats(Type type);

    PokemonFamilyTree readFamilyTree  (long id);

    List<PokemonTreeNodeDTO> readFamilyTreeFlat(long id);
}
