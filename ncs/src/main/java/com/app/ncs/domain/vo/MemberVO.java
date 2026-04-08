package com.app.ncs.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MemberVO {
    private Long id;
    private String memberPassword;
    private String memberName;
    private String memberEmail;
}
