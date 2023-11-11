package com.example.demo.controller;

import com.example.demo.dto.PokemonTreeNodeDTO;
import com.example.demo.enums.Type;
import com.example.demo.model.AjaxResponse;
import com.example.demo.model.PokemonFamilyTree;
import com.example.demo.model.Pokemon;
import com.example.demo.model.TypeStats;
import com.example.demo.service.IPokemonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

    @Autowired
    IPokemonService pokemonService;

    @ResponseBody
    @GetMapping("/read")
    public AjaxResponse<String, Pokemon> read(@RequestParam long id) {
        final AjaxResponse<String, Pokemon> response = new AjaxResponse<>(false);
        try {
            response.setMessage("pokemon successfully loaded.");
            response.setSuccess(true);
            Pokemon pokemon = pokemonService.read(id);
            response.setData(pokemon);
        } catch (Exception e) {
            response.setMessage("Failed to load pokemon.");
            response.setSuccess(false);
            log.error("Error requesting URL: /api/pokemon/read", e);
            return new AjaxResponse<>(false);
        }
        return response;
    }

    @ResponseBody
    @GetMapping("/readAll")
    public AjaxResponse<String, List<Pokemon>> read(@RequestParam(required=false) String search,
                                                       @RequestParam(required=false) String sortBy,
                                                       @RequestParam(required=false) Type[] selectedTypes){
        final AjaxResponse<String, List<Pokemon>> response = new AjaxResponse<>(false);
        try {
            response.setMessage("pokemonList successfully loaded.");
            response.setSuccess(true);
            List<Pokemon> pokemonList = pokemonService.readAll(search, sortBy, selectedTypes);
            response.setData(pokemonList);
        } catch (Exception e) {
            response.setMessage("Failed to load pokemonList.");
            response.setSuccess(false);
            log.error("Error requesting URL: /api/pokemon/readAll", e);
            return new AjaxResponse<>(false);
        }
        return response;
    }

    @ResponseBody
    @GetMapping("/readTypeStats")
    public AjaxResponse<String, TypeStats> readTypeStats(@RequestParam Type type){
        final AjaxResponse<String, TypeStats> response = new AjaxResponse<>(false);
        try {
            response.setMessage("stats for type successfully loaded.");
            response.setSuccess(true);
            TypeStats stats= pokemonService.readTypeStats(type);
            response.setData(stats);
        } catch (Exception e) {
            response.setMessage("Failed to load stats for type.");
            response.setSuccess(false);
            log.error("Error requesting URL: /api/pokemon/typeStats", e);
            return new AjaxResponse<>(false);
        }
        return response;
    }

    @ResponseBody
    @GetMapping("/readFamilyTree")
    public AjaxResponse<String, PokemonFamilyTree> readEvoChain(@RequestParam long id){
        final AjaxResponse<String, PokemonFamilyTree> response = new AjaxResponse<>(false);
        try {
            response.setMessage("stats for type successfully loaded.");
            response.setSuccess(true);
            PokemonFamilyTree tree = pokemonService.readFamilyTree(id);
            response.setData(tree);
        } catch (Exception e) {
            response.setMessage("Failed to load stats for type.");
            response.setSuccess(false);
            log.error("Error requesting URL: /api/pokemon/typeStats", e);
            return new AjaxResponse<>(false);
        }
        return response;
    }

    @ResponseBody
    @GetMapping("/readFamilyTreeFlat")
    public AjaxResponse<String, List<PokemonTreeNodeDTO>> readFamilyTreeFlat(@RequestParam long id){
        final AjaxResponse<String, List<PokemonTreeNodeDTO>> response = new AjaxResponse<>(false);
        try {
            response.setMessage("stats for type successfully loaded.");
            response.setSuccess(true);
            List<PokemonTreeNodeDTO> tree = pokemonService.readFamilyTreeFlat(id);
            response.setData(tree);
        } catch (Exception e) {
            response.setMessage("Failed to load stats for type.");
            response.setSuccess(false);
            log.error("Error requesting URL: /api/pokemon/typeStats", e);
            return new AjaxResponse<>(false);
        }
        return response;
    }
}
