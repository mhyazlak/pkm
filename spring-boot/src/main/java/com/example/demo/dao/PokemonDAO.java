package com.example.demo.dao;

import com.example.demo.dto.PokemonDTO;
import com.example.demo.dto.PokemonTreeNodeDTO;
import com.example.demo.enums.Type;
import com.example.demo.model.TypeStats;
import com.example.demo.util.DynamicQueryBuilder;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class PokemonDAO {

    @Autowired
    private EntityManager entityManager;

    private static final String SELECT_SINGLE = "SELECT * FROM POKEMON_VIEW WHERE id=?1";
    private static final String SELECT_ALL = "SELECT * FROM POKEMON_VIEW";

    private static final String SELECT_TYPE_STATS = "SELECT * FROM TYPE_STATS_VIEW WHERE type_one=?1";



    public PokemonDTO read(long id) {
        Query query = entityManager.createNativeQuery(SELECT_SINGLE, PokemonDTO.class);
        query.setParameter(1, id);
        return (PokemonDTO) query.getSingleResult();
    }

    public List<PokemonDTO> readAll(String search, String sortBy, Type[] selectedTypes) {
        DynamicQueryBuilder dqb = new DynamicQueryBuilder(SELECT_ALL, entityManager);

        if (search != null && !search.isEmpty()) {
            dqb.addQueryParam("name", "EQ", search);
        }
        if(selectedTypes != null && selectedTypes.length > 0) {
            String[] typeNames = Arrays.stream(selectedTypes)
                    .map(Type::name)
                    .toArray(String[]::new);
            dqb.addQueryParam("type_one", "IN", typeNames);
            if(typeNames.length > 1) {
                dqb.addQueryParam("type_two", "IN", typeNames);
            }

        }
        if(sortBy != null && !sortBy.isEmpty()) {
            dqb.addSortParam(sortBy, "ASC");
        }
        Query query = dqb.buildQuery(PokemonDTO.class);
        return (List<PokemonDTO>) query.getResultList();
    }

    public TypeStats readTypeStats(Type type) {
        Query query = entityManager.createNativeQuery(SELECT_TYPE_STATS, TypeStats.class);
        query.setParameter(1, type.name());
        return (TypeStats) query.getSingleResult();
    }

    private static final String SELECT_FAMILY_TREE = "SELECT * FROM FAMILY_TREE_VIEW WHERE target_id =?1";

    public List<PokemonTreeNodeDTO> readFamilyTree(long id) {
        Query query = entityManager.createNativeQuery(SELECT_FAMILY_TREE, PokemonTreeNodeDTO.class);
        query.setParameter(1, id);
        return (List<PokemonTreeNodeDTO>) query.getResultList();
    }
}
