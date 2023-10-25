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
        return pokemonDAO.read(id);
    }

    @Override
    public List<PokemonDTO> readAll() {
        return pokemonDAO.readAll();
    }
}
