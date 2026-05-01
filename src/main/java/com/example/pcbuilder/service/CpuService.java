package com.example.pcbuilder.service;

import com.example.pcbuilder.dto.request.CpuRequest;
import com.example.pcbuilder.dto.response.CpuResponse;
import com.example.pcbuilder.model.Cpu;
import com.example.pcbuilder.repository.CpuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CpuService {

    private final CpuRepository cpuRepository;

    public CpuResponse create(CpuRequest request){
        Cpu cpu = Cpu.builder().name(request.getName())
                .price(request.getPrice())
                .socketType(request.getSocketTypeDTO())
                .build();
        return toResponseDTO(cpuRepository.save(cpu));
    }

    public CpuResponse findById(Integer id){
        Cpu cpu = cpuRepository.findById(id).orElseThrow(()-> new RuntimeException("Cpu not found"));
        return toResponseDTO(cpu);
    }

    public CpuResponse toResponseDTO(Cpu cpu){
        CpuResponse dto = new CpuResponse();

        dto.setId(cpu.getId());
        dto.setName(cpu.getName());
        dto.setSocketTypeDTO(cpu.getSocketType());
        dto.setPrice(cpu.getPrice());
        return dto;
    }
}
