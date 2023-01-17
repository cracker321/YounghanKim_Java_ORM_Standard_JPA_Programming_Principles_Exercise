package jpabook.jpashop.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;



@Getter
@NoArgsConstructor//'임베디드 타입 객체'는 반드시 '기본 생성자'를 가지고 있어야 함!
@Embeddable //'임베디드 타입 객체'
public class Address {

    String city;
    String street;
    String zipcode;
}
