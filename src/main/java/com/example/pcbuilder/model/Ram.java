package com.example.pcbuilder.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "ram")
public class Ram {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank @Column(nullable = false)
    private String name;
    @NotNull @Positive @Column(nullable = false)
    private Double price;
    @Enumerated(EnumType.STRING)
    private TypeRam typeRam;
}
