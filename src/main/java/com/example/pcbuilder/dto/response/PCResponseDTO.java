package com.example.pcbuilder.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PCResponseDTO {
    private Integer Id;
    private Integer motherBoardId;
    private String motherBoardName;
    private Integer cpuId;
    private String cpuName;
    private Integer gpuId;
    private String gpuName;
    private Integer ramID;
    private String ramName;
    private Double totalPrice;
}
