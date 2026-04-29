package com.example.pcbuilder.dto.request;

import com.example.pcbuilder.model.SocketType;
import com.example.pcbuilder.model.TypeRam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class MotherboardRequest {
    private String name;
    private Double price;
    private SocketType socketTypeDTO;
    private TypeRam typeRamDTO;
}
