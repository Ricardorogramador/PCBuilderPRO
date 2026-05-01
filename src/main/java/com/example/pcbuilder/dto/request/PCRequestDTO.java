package com.example.pcbuilder.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PCRequestDTO {
    private Integer motherBoardId;
    private Integer cpuId;
    private Integer ramId;
    private Integer gpuId;
}
