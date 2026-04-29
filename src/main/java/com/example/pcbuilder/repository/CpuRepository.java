package com.example.pcbuilder.repository;

import com.example.pcbuilder.model.Cpu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CpuRepository extends JpaRepository<Cpu, Integer> {
}
