package com.app.dependency.di;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Data
// @Data: getter, setter, toString, equals, hashCode
// @NoArgsConstructor: 기본 생성자
// @AllArgsConstructor: 초기화 생성자
// @Getter: getter
// @Setter: setter
// @ToString: toString
// @EqualsAndHashCode: equals, hashCode
public class Coding {

//    필드 주입을 하면 안 되는 이유
//    1. 불변 상태를 만들 수 없다. (값이 바뀌지 않을 수 없다.)
//    final로 해결 X
//    2. 순환 참조 발생 여부를 알 수 없다.
//    서버 -> 코딩 -> 컴퓨터 -> 코딩 -> 컴퓨터
//    사용할 수 없음
//    @Autowired
//    final private Computer computer;

//    setter 주입 안 됨
//    final private Computer computer;
//
//    @Autowired
//    public void setComputer(Computer computer) {
//        this.computer = computer;
//    }

//    private을 붙이는 이유 -> 생성자 주입으로 불변성을 유지하기 위해!
//    final의 시점을 생각해야 함
    private final Computer computer;

    private String type;
    private String content;
}
