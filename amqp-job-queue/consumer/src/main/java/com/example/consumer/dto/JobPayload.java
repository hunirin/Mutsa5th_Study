package com.example.consumer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
// Producer가 발생시킬 Job을 정의한 DTO
public class JobPayload {
    private String jobId;
    private String filename;
    private String path;
}
