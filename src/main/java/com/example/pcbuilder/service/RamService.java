package com.example.pcbuilder.service;

import com.example.pcbuilder.dto.request.RamRequest;
import com.example.pcbuilder.dto.response.RamResponse;
import com.example.pcbuilder.model.Ram;
import com.example.pcbuilder.repository.RamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RamService {

    private final RamRepository ramRepository;

    public RamResponse create(RamRequest request) {
        Ram ram = Ram.builder()
                .name(request.getName())
                .price(request.getPrice())
                .typeRam(request.getTypeRamDTO())
                .build();
        return toResponseDTO(ramRepository.save(ram));
    }

    public RamResponse findById(Integer id){
        Ram ram = ramRepository.findById(id).orElseThrow(()-> new RuntimeException("Ram not found"));
        return toResponseDTO(ram);
    }

    public RamResponse toResponseDTO(Ram ram){
        RamResponse dto = new RamResponse();
        dto.setId(ram.getId());
        dto.setName(ram.getName());
        dto.setPrice(ram.getPrice());
        dto.setTypeRamDTO(ram.getTypeRam());
        return dto;
    }
}
