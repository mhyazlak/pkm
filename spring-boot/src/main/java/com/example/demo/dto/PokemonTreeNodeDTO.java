package com.example.demo.dto;


import com.example.demo.enums.Type;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PokemonTreeNodeDTO {

    @Id
    @Column(name = "id", nullable = false)
    @JsonProperty("id")
    private long id;

    @Column(name = "name", nullable = false)
    @JsonProperty("name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_one", nullable = false)
    @JsonProperty("type_one")
    private Type typeOne;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_two", nullable = true) // This should be nullable as not every Pokemon has a second type
    @JsonProperty("type_two")
    private Type typeTwo;

    @Column(name = "icon_b64", nullable = false)
    @JsonProperty("icon_b64")
    private String iconB64;

    @Column(name="stage", nullable = false)
    @JsonProperty("stage")
    private int stage;

    @Column(name="triggered_by", nullable = false)
    @JsonProperty("triggered_by")
    private String triggeredBy;
}
