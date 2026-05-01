package com.example.pcbuilder.dto.response;

import com.example.pcbuilder.model.SocketType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CpuResponse {
    private Integer id;
    private String name;
    private Double price;
    private SocketType socketTypeDTO;
}
