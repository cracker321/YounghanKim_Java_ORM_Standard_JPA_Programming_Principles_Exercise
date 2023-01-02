package jpabook.jpashop.domain;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ORDERS")
public class Order {


    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID", length = 10)
    private Long id;

    @Column(name = "MEMBER_ID")
    private Long memberId; //그러나, 이 방식은 '객체지향스럽지 않다!'
                           //이 방식은, '자바 객체 설계'를 'DB 테이블 설계'에 맞춘 방식이다.
                           //왜냐하면, '테이블의 외래키를 자바 객체에 그대로 가져왔고',
                           //         '객체 그래프 탐색이 불가능'하며,
                           //         '참조가 없으므로 UML도 잘못됨'.

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
