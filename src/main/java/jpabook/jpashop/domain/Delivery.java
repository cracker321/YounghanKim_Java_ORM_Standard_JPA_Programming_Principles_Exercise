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

    private String city;
    private String street;
    private String zipcode; // 배송지 주소 관련 정보들

    private DeliveryStatus deliveryStatus; //현재 배송 상태

}
