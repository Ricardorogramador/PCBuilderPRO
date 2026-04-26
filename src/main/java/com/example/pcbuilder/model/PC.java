package com.example.pcbuilder.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pc")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class PC {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "motherboard_id", nullable = false)
    private  Motherboard motherboard;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cpu_id", nullable = false)
    private Cpu cpu;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "gpu_id", nullable = false)
    private Gpu gpu;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ram_id", nullable = false)
    private Ram ram;

    @Column(name = "total_price", nullable = false)
    private Double totalPrice;
}
