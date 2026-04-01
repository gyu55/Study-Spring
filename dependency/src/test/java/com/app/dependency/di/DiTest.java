package com.app.dependency.di;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest // test를 위한 클래스라고 Spring에게 보고
@Slf4j // log에 결과를 출력
public class DiTest {

    // Test에서는 생성자 주입을 받을 수 없음 -> Autowired해줘야 함 (필드주입)
    // 필드 주입 (메서드 내부에서는 주입하면 안 됨)
    @Autowired
    private Coding coding;
    @Autowired
    private Food food;
    @Autowired
    private Login login;

    @Test
    // JUnit은 실행 버튼
    public void codingTest(){

        log.info("codingTest"); // log.info는 문자열만 출력가능함
        log.info("coding : {}", coding.getComputer());
    }

    @Test
    public void foodTest(){
        log.info("foodTest");
        log.info("food {}", food.getKnife());
    }

    @Test
    public void loginTest(){
        log.info("loginTest");
        log.info("Login {}", login.getMember());
    }
}
