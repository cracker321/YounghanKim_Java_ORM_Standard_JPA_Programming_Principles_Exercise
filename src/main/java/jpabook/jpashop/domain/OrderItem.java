package jpabook.jpashop.domain;

import javax.persistence.*;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue
    @Column(name = "ORDER_ITEM_ID")
    private Long id;


    //< 'OrderItem 객체의 필드 order(N)'와 'Order 객체의 필드 id(1)' 간의 'N : 1 단방향' 매핑': 주문된 주문내역ID >
    //- '주인(N : M 일때 기준으로)'이 'OrderItem 객체의 필드 order(='Order 객체의 필드 id')'인 경우
    @ManyToOne //'주문상품(OrderItem) 객체'와 '주문(Order) 객체'의 관계 = N : 1
    @JoinColumn(name = "ORDER_ID") //'주인인 현재 테이블 ORDER_ITEM의 FK인 필드 member(= 'Member 객체의 필드 id')'는
                                   //'주인이 아닌 테이블 ORDER의 PK인 컬럼 ORDER_ID'에 대응된다!
    private Order order; //'OrderItem 객체의 필드 order'. FK = 'Order 객체의 필드 id'. PK
                         //'OrderItem 객체'의 입장에서는, '어떤 Order ID(주문내역)가 상품을 주문했는지' '그 Order ID'에 대한 정보가 필요함.
                         //즉, 'Order ID'가 필요하고, 여기서의 '필드 order'가 바로 그 'order ID'임.




    //< 'OrderItem 객체의 필드 item(N)'과 'Item 객체의 필드 id(1)' 간의 'N : 1 단방향 매핑': 주문된 상품ID >
    //- '주인(N : M 일때 기준으로)'이 'OrderItem 객체의 필드 item(='Item 객체의 필드 id')인 경우
    @ManyToOne //'주문상품(OrderItem) 객체'와 '상품(Item) 객체'의 관계 = N : 1
    @JoinColumn(name = "ITEM_ID") //'주인인 현재 테이블 ORDER_ITEM의 FK인 필드 item(= 'Item 객체의 필드 id)'은
                                  //'주인이 아닌 테이블 ITEM의 PK인 컬럼 ITEM_ID'에 대응된다!
    private Item item; //'OrderItem 객체의 필드 item'. FK = 'Item 객체의 필드 id'. PK
                       //'OrderItem 객체'의 입장에서는, '어떤 Item ID(상품정보)가 주문되었는지' '그 Item ID'에 대한 정보가 필요함.
                       //즉, 'Item ID'가 필요하고, 여기서의 '필드 item'이 바로 그 'item ID'임.


//    @Column(name = "ORDER_ID")
//    private Long orderId;
//
//    @Column(name = "ITEM_ID")
//    private Long itemId;

    private int orderPrice;

    private int count; //구매수량

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
