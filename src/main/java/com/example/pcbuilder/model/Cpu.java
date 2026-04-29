package com.example.pcbuilder.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "cpu")
public class Cpu {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank @Column(nullable = false) @Size(min = 5)
    private String name;
    @NotNull @Positive @Column(nullable = false)
    private Double price;
    @Enumerated(EnumType.STRING)
    private SocketType socketType;
}
