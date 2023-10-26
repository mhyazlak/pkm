package com.example.demo.controller;

import com.example.demo.dto.PokemonDTO;
import com.example.demo.model.AjaxResponse;
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
    public AjaxResponse<String, PokemonDTO> read(@RequestParam long id) {
        final AjaxResponse<String, PokemonDTO> response = new AjaxResponse<>(false);
        try {
            response.setMessage("pokemon successfully loaded.");
            response.setSuccess(true);
            PokemonDTO pokemon = pokemonService.read(id);
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
    public AjaxResponse<String, List<PokemonDTO>> read() {
        final AjaxResponse<String, List<PokemonDTO>> response = new AjaxResponse<>(false);
        try {
            response.setMessage("pokemonList successfully loaded.");
            response.setSuccess(true);
            List<PokemonDTO> pokemonList = pokemonService.readAll();
            response.setData(pokemonList);
        } catch (Exception e) {
            response.setMessage("Failed to load pokemonList.");
            response.setSuccess(false);
            log.error("Error requesting URL: /api/pokemon/readAll", e);
            return new AjaxResponse<>(false);
        }
        return response;
    }
}
