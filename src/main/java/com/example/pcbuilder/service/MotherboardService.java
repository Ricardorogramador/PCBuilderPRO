package com.example.pcbuilder.service;

import com.example.pcbuilder.dto.request.MotherboardRequest;
import com.example.pcbuilder.dto.response.MotherboardResponse;
import com.example.pcbuilder.model.Motherboard;
import com.example.pcbuilder.repository.MotherboardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MotherboardService {
    private final MotherboardRepository motherboardRepository;

    public MotherboardResponse create(MotherboardRequest request){
        Motherboard motherboard = Motherboard.builder()
                .name(request.getName())
                .price(request.getPrice())
                .socketTypeMb(request.getSocketTypeDTO())
                .motherboardTypeRam(request.getTypeRamDTO())
                .build();
        return toResponseDTO(motherboardRepository.save(motherboard));
    }

    public MotherboardResponse findById(Integer id){
        Motherboard motherboard = motherboardRepository.findById(id).orElseThrow(()-> new RuntimeException("Motherboard not found"));
        return toResponseDTO(motherboard);
    }

    public MotherboardResponse toResponseDTO(Motherboard motherboard){
        MotherboardResponse dto = new MotherboardResponse();
        dto.setId(motherboard.getId());
        dto.setName(motherboard.getName());
        dto.setPrice(motherboard.getPrice());
        dto.setSocketTypeDTO(motherboard.getSocketTypeMb());
        dto.setTypeRamDTO(motherboard.getMotherboardTypeRam());
        return dto;
    }
}
