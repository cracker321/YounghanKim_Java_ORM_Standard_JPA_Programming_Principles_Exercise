package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    private String city;
    private String street;
    private String zipcode; // 배송지 주소 관련 정보들

    private DeliveryStatus deliveryStatus; //현재 배송 상태

}
