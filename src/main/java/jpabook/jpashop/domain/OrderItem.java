package jpabook.jpashop.domain;

import javax.persistence.*;

public class OrderItem {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;


    //< 'OrderItem 객체'와 'Order 객체' 간의 '연관관계 매핑' >
    @ManyToOne //'주문상품(OrderItem) 객체'와 '주문(Order) 객체'의 관계 = N : 1
    @JoinColumn(name = "ORDER_ID") //'OrderItem 객체의 필드 member(= 'Member 객체의 필드 id')'는
                                   //'테이블 ORDER의 컬럼 ORDER_ID'에 대응된다!
    private Order order; //'OrderItem 객체의 필드 order'. FK = 'Order 객체의 필드 id'. PK
                         //'OrderItem 객체'의 입장에서는, '어떤 Order ID가 상품을 주문했는지' '그 Order ID'에 대한 정보가 필요함.
                         //즉, 'Order ID'가 필요하고, 여기서의 '필드 order'가 바로 그 'order ID'임.


    //< 'OrderItem 객체'와 'Item 객체' 간의 '연관관계 매핑' >
    @ManyToOne //'주문상품(OrderItem) 객체'와 '상품(Item) 객체'의 관계 = N : 1
    @JoinColumn(name = "ITEM_ID") //'OrderItem 객체의 필드 item(= 'Item 객체의 필드 id)'는
                                  //'테이블 ITEM의 컬럼 ITEM_ID'에 대응된다!
    private Item item; //'OrderItem 객체의 필드 item'. FK = 'Item 객체의 필드 id'. PK
                       //'OrderItem 객체'의 입장에서는, '어떤 Item ID가 주문되었는지' '그 Item ID'에 대한 정보가 필요함.
                       //즉, 'Item ID'가 필요하고, 여기서의 '필드 item'이 바로 그 'item ID'임.


//    @Column(name = "ORDER_ID")
//    private Long orderId;
//
//    @Column(name = "ITEM_ID")
//    private Long itemId;

    private int orderPrice;

    private int count; //구매수량


    }
}
