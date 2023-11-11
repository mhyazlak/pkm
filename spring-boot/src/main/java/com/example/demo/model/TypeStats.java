package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TYPE_STATS_VIEW") // You might want to specify the table name as well, especially if it doesn't match the class name in a straightforward way
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeStats {

    @Id
    @Column(name = "type_one", nullable = false)
    @JsonProperty("type_one")
    private String type_one;

    @Column(name = "avg_base_hp", nullable = false)
    @JsonProperty("avg_base_hp")
    private Double avg_base_hp;

    @Column(name = "avg_base_atk", nullable = false)
    @JsonProperty("avg_base_atk")
    private Double avg_base_atk;

    @Column(name = "avg_base_def", nullable = false)
    @JsonProperty("avg_base_def")
    private Double avg_base_def;

    @Column(name = "avg_base_spa", nullable = false)
    @JsonProperty("avg_base_spa")
    private Double avg_base_spa;

    @Column(name = "avg_base_spd", nullable = false)
    @JsonProperty("avg_base_spd")
    private Double avg_base_spd;

    @Column(name = "avg_base_spe", nullable = false)
    @JsonProperty("avg_base_spe")
    private Double avg_base_spe;

}
