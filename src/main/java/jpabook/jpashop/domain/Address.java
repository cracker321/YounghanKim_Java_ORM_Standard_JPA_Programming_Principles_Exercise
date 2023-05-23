package jpabook.jpashop.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;


//[ '임베디드 타입'강 05:00~ ]: 정말 긍정적으로 '객체지향적인 방식'이라서 강력추천!
//                           'Member 엔티티'가 더욱 '객체지향적'이고, '응집력 있게' 되었다.
//< '새로운 기본값 타입'으로 아래 두 필드를 합쳐서 쓸 수 있는 '주소 Address 임베디드 타입'을 생성하기 >
//- 즉, '새로운 클래스 Address'를 '생성하고', '그 새로운 클래스 Address' 안에 원래라면 저렇게 지저분하게 많이 있어햐 하는
// 주석 처리한 세 필드들(city, street, zipcode)을 넣기.
//  그리고, 위 세 필드들을 대신하여, 아래에 '필드 Address'를 대신 사용하는 것임.
//- 그 후, '이 클래스 Address 위에는' '@Embeddable'을 쓰거나, 또는
//- 저 아래 'Delivery 객체와 Member 객체의 필드 Address 위에는' '@Embedded'를 작성하거나 둘 중 하나만 하거나, 둘 다 작성해도 된다.


@Getter
@NoArgsConstructor//'임베디드 타입 객체'는 반드시 '기본 생성자'를 가지고 있어야 함!
@Embeddable //'임베디드 타입 객체'

//- '임베디드 타입 객체'는 '엔티티가 아니기 때문'에 절대 '@Entity'를 붙여줘서는 안된다!
//- '임베디드 타입 객체'와 같이 '값 타입 객체'는 '공유 참조를 피하기 위해', '절대 Setter를 쓰면 안된다'!!!!!

public class Address {

    @Column(length = 10) //'도시명 city'은 10자까지만 입력받아줄거야
    private String city;

    @Column(length = 20) //'거리명 street'은 20자까지만 입력받아줄거야
    private String street;

    @Column(length = 5) //'주소명 zipcode'는 5자까미나 입력받아줄거야야
    private String zipcode;


    
    //아래는 옵션사항. 
    //그냥 여기선 '다른 객체의 필드가 Address 객체를 호출했을 때', '의미있는 반환값을 건네주기 위해' 이렇게 생성자 설정함
    //'값 타입 Address 객체'를 좀 더 의미있고, 객체지향적으로 사용하기 위해 아래처럼 하는 것도 해볼만 함.
    public String fullAddress(){

        return getCity() + getStreet() + getZipcode();
    }
    

}
