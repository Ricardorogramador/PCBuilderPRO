package com.example.pcbuilder.service;

import com.example.pcbuilder.dto.request.PCRequestDTO;
import com.example.pcbuilder.dto.response.PCResponseDTO;
import com.example.pcbuilder.model.*;
import com.example.pcbuilder.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PCService {

    private final PCRepository pcRepository;
    private final CpuRepository cpuRepository;
    private final GpuRepository gpuRepository;
    private final MotherboardRepository motherboardRepository;
    private final RamRepository ramRepository;
    // I know the PC have more parts but you see i'm struggling to do this lmao

    public PCResponseDTO create(PCRequestDTO request){
        Cpu cpu = cpuRepository.findById(request.getCpuId()).orElseThrow(()-> new RuntimeException("Cpu not found"));
        Gpu gpu  = gpuRepository.findById(request.getGpuId()).orElseThrow(()-> new RuntimeException("Gpu not found"));
        Motherboard motherboard = motherboardRepository.findById(request.getMotherBoardId()).orElseThrow(()-> new RuntimeException("Motherboard not found"));
        Ram ram = ramRepository.findById(request.getRamId()).orElseThrow(()-> new RuntimeException("Ram not found"));

        PC pc = PC.builder()
                .motherboard(motherboard)
                .cpu(cpu)
                .gpu(gpu)
                .ram(ram)
                .totalPrice(cpu.getPrice() + gpu.getPrice() + motherboard.getPrice() + ram.getPrice())
                .build();
        PC saved = pcRepository.save(pc);
        return toResponseDTO(saved);
    }

    public PCResponseDTO toResponseDTO(PC pc){
        PCResponseDTO dto = new PCResponseDTO();
        dto.setId(pc.getId());
        dto.setMotherBoardId(pc.getMotherboard().getId());
        dto.setMotherBoardName(pc.getMotherboard().getName());
        dto.setGpuId(pc.getGpu().getId());
        dto.setGpuName(pc.getGpu().getName());
        dto.setCpuId(pc.getCpu().getId());
        dto.setCpuName(pc.getCpu().getName());
        dto.setRamID(pc.getRam().getId());
        dto.setRamName(pc.getRam().getName());
        dto.setTotalPrice(pc.getTotalPrice());
        return dto;
    }

}
