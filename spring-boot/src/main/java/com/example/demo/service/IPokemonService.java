package com.example.demo.service;

import com.example.demo.dto.PokemonDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface IPokemonService {

    public PokemonDTO read(long id);

    List<PokemonDTO> readAll();
}
