package jpabook.jpashop.domain;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order {


    @Id
    @GeneratedValue
    @Column(name = "ORDER_ID", length = 10)
    private Long id;


    //1. < 'Order 객체의 필드 member'와 'Member 객체의 필드 orders' 간의 '양방향 연관관계 매핑': 주문내역'목록' ID >
    //2. < 'Order 객체의 필드 member'와 'Member 객체의 필드 id' 간의 '단방향 연관관계 매핑': 주문한 회원ID >
    //즉, 아래 'Order 객체의 필드 member'는, '양방향 매핑'과 '단방향 매핑' 둘 다 'Member 객체'의 각각 다른 필드들과 연결되어 있다
    //일단, 가급적 '단방향 매핑'을 제대로 해둔다! 이것만으로 '개체 설계'는 많이 됨.
    @ManyToOne //'주문(Order) 객체'와 '회원(Member) 객체'의 관계 = N : 1
    @JoinColumn(name = "MEMBER_ID") //'Order 객체의 필드 member(= 'Member 객체의 필드 id')'는
                                    //'테이블 MEMBER의 컬럼 MEMBER_ID'에 대응된다!
    private Member member; //1. < 양방향 매핑 >
                           //- 'Order 객체'가 '외래키(필드 member)를 소유하고 있기에', '외래키 소유 객체인 Order 객체의 필드 member'가
                           //   양방향 매핑의 주인!
                           //- 'Member 객체' 입장에서는, '어떤 주문내역목록이 주문되었는지', '그 orders ID'에 대한 정보가 필요함
                           //   즉, 'orders ID'가 필요하고, 여기서의 'Member 객체의 필드 orders'가 바로 그 'oders ID'임.
                           //2. < 단방향 매핑 >
                           //- 'Order 객체의 필드 member'. FK = 'Member 객체의 필드 id'. PK
                           //   'Order 객체'의 입장에서는, '어떤 Member(회원)가 주문했는지' '그 Member ID'에 대한 정보가 필요함.
                           //   즉, 'member ID'가 필요하고, 여기서의 '필드 member'가 바로 그 'member ID'임.



    //1. < 'Order 객체의 필드 orderItems'와 'OrderItem 객체의 필드 order' 간의 '양방향 연관관계 매핑' >
    //2. < 'Order 객체의 필드 id'와 'OrderItem 객체의 필드 order'간의 '단방향 연관관계 매핑' >
    @OneToMany(mappedBy = "order") //- '주문(Order) 객체'와 '주문상품(OrderItem) 객체'와의 관계 = 1 : N
                                   //- '반대편 연관관계이자 주인'인 'OrderItem 객체의 필드 order'와 '양방향 매핑'되어있다 라는 뜻
                                   //- '양방향 매핑의 주인인 OrderItem 객체의 필드 order'의 위에 어노테이션으로는
                                   //   'mappedBy'에 사용될 수 없기에
                                   //  '그 반대편 연관관계 매핑'의 대상인 이 '필드 orderItems'위에 'mappedBy' 되는 것이다!
    private List<OrderItem> orderItems = new ArrayList<OrderItem>();
            //1. < 양방향 매핑 >
            //- 'OrderItems 객체'가 ''외래키(필드 order)'를 소유하고 있기에', '외래키 소유 객체인 OrderItems 객체의 필드 order'가
            //  양방향 매핑의 주인!
            //- 'Order 객체' 입장에서는, '어떤 상품들이 주문되었는지', '그 orderItems ID'에 대한 정보가 필요함
            //   즉, 'orderItems ID'가 필요하고, 여기서의 'Order 객체의 필드 orderItems'가 바로 그 'oderItems ID'임.
            //2. < 단방향 매핑 >
            //- 'Order 객체의 필드 id'. PK = 'OrderItems 객체의 필드 order'. FK


//    @Column(name = "MEMBER_ID")
//    private Long memberId; //그러나, 이 방식은 '객체지향스럽지 않다!'
//                           //이 방식은, '자바 객체 설계'를 'DB 테이블 설계'에 맞춘 방식이다.
//                           //왜냐하면, '테이블의 외래키를 자바 객체에 그대로 가져왔고',
//                           //         '객체 그래프 탐색이 불가능'하며,
//                           //         '참조가 없으므로 UML도 잘못됨'.


    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
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
