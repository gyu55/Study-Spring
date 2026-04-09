package com.app.threetier.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class WorkerVO {
    private Long id;
    private String workerName;
    private String workerHoursStart;
    private String workerHoursEnd;
}
