package com.example.pcbuilder.service;

import com.example.pcbuilder.dto.request.GpuRequest;
import com.example.pcbuilder.dto.response.GpuResponse;
import com.example.pcbuilder.model.Gpu;
import com.example.pcbuilder.repository.GpuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GpuService {

    private final GpuRepository gpuRepository;

    public GpuResponse create(GpuRequest request){
        Gpu gpu = Gpu.builder()
                .name(request.getName())
                .price(request.getPrice())
                .build();
                //Sorry still learning about builder pattern.
        return toResponseDTO(gpuRepository.save(gpu));
    }

    public GpuResponse findById(Integer id){
        Gpu gpu = gpuRepository.findById(id).orElseThrow(()-> new RuntimeException("Gpu not found"));
        return toResponseDTO(gpu);
    }

    public GpuResponse toResponseDTO(Gpu gpu){
        GpuResponse dto = new GpuResponse();
        dto.setId(dto.getId());
        dto.setName(dto.getName());
        dto.setPrice(dto.getPrice());
        return dto;
    }
}
