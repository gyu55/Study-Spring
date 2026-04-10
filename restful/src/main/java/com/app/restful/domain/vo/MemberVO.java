package com.app.restful.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
// Serializable interface: 데이터를 주고 받는 데이터라는 것을 알려주기 위함 (다른 서버와 주고 받음)
public class MemberVO implements Serializable {
    private Long id;
    private String memberEmail;
    private String memberName;
    private String memberPassword;
}
