package com.example.demo.service.impl;

import com.example.demo.dao.PokemonDAO;
import com.example.demo.dto.PokemonDTO;
import com.example.demo.service.IPokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PokemonServiceImpl implements IPokemonService {

    @Autowired
    PokemonDAO pokemonDAO;

    @Override
    @Transactional
    public PokemonDTO read(long id) {

        PokemonDTO pokemonDb = null;
        try {
             pokemonDb = pokemonDAO.read(id);
        } catch (Exception e) {
            throw e;
        }
        return pokemonDb;
    }


    @Override
    public List<PokemonDTO> readAll() {
        return pokemonDAO.readAll();
    }
}
