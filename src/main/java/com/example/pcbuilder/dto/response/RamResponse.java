package com.example.pcbuilder.dto.response;

import com.example.pcbuilder.model.TypeRam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class RamResponse {
    private Integer id;
    private String name;
    private Double price;
    private TypeRam typeRamDTO;
}
