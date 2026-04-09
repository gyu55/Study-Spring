package com.app.threetier.domain.vo;


import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TaskVO {
    private int kor;
    private int eng;
    private int math;
}
