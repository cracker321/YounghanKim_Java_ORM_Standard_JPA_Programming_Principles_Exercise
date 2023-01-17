package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.FetchType.*;

@Entity
public class Delivery {

    @Id
    @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = LAZY) //'@OneToOne'과 '@ManyToOne'에는 반드시
                                                   //'지연로딩'으로 일일히 설정해줘야 한다!
                                                   //왜냐하면, 위 두 개는 JPA 기본설정이 '즉시로딩'으로 되어있기 때문!
                                                   //cf) 'fetch =...' 작성 후에 'alt + enter' 누르고,
                                                   //'add on demand static import for...'누르면, 더 축약되어 깔끔하게 써진다!

    private Order order;


//====================================================================================================================

    //[ '임베디드 타입'강 05:00~ ]: 정말 긍정적으로 '객체지향적인 방식'이라서 강력추천!
    //                           'Delivery 엔티티'가 더욱 '객체지향적'이고, '응집력 있게' 되었다.
    //- 즉, '새로운 클래스 Address'를 '생성하고', '그 새로운 클래스 Address' 안에 원래라면 저렇게 지저분하게 많이 있어햐 하는
    // 아래 주석 처리한 세 필드들(city, street, zipcode)을 넣기.
    //  그리고, 아래 세 필드들을 대신하여, 아래에 '필드 homeAddress'를 대신 사용하는 것임.
    //- 그 후, '저 클래스 Address 위에는' '@Embeddable'을 쓰거나, 또는
    //- 이 아래 'Member 객체의 필드 homeAddress 위에는' '@Embedded'를 작성하거나 둘 중 하나만 하거나, 둘 다 작성해도 된다.
//    private String city;
//    private String street;
//    private String zipcode;

    @Embedded
    private Address address;

    private DeliveryStatus deliveryStatus; //현재 배송 상태

}
