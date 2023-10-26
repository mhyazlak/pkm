package com.example.demo.dao;

import com.example.demo.dto.PokemonDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Repository
public class PokemonDAO {

    @Autowired
    private EntityManager entityManager;

    private static final String SELECT_SINGLE = "SELECT * FROM Pokemon_VIEW WHERE id=?1";
    private static final String SELECT_ALL= "SELECT * FROM Pokemon_VIEW";

    public PokemonDTO read(long id) {
        Query query = entityManager.createNativeQuery(SELECT_SINGLE, PokemonDTO.class);
        query.setParameter(1, id);
        return (PokemonDTO) query.getSingleResult();
    }

    public List<PokemonDTO> readAll() {
        Query query = entityManager.createNativeQuery(SELECT_ALL, PokemonDTO.class);
        return (List<PokemonDTO>) query.getResultList();
    }

}
