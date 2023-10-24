package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "Pokemon")
@AllArgsConstructor
@NoArgsConstructor
public class PokemonDTO {


    @Id
    @Column(name = "id", nullable = false)
    //@JsonProperty("id")
    private long id;

    @Column(name = "name", nullable = false)
    @JsonProperty("name")
    private String name;


}
