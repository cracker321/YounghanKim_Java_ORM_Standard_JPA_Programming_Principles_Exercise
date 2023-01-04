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
                           //- 'Order 객체'가 '외래키를 소유하고 있기에', '외래키의 관리자 객체인 Order 객체'가 양방향 매핑의 주인!
                           //- 'Member 객체' 입장에서는, '어떤 주문내역목록이 주문되었는지', '그 orders ID'에 대한 정보가 필요함
                           //   즉, 'orders ID'가 필요하고, 여기서의 'Member 객체의 필드 orders'가 바로 그 'oders ID'임.
                           //2. < 단방향 매핑 >
                           //'Order 객체의 필드 member'. FK = 'Member 객체의 필드 id'. PK
                           //'Order 객체'의 입장에서는, '어떤 Member(회원)가 주문했는지' '그 Member ID'에 대한 정보가 필요함.
                           //즉, 'member ID'가 필요하고, 여기서의 '필드 member'가 바로 그 'member ID'임.


//    @Column(name = "MEMBER_ID")
//    private Long memberId; //그러나, 이 방식은 '객체지향스럽지 않다!'
//                           //이 방식은, '자바 객체 설계'를 'DB 테이블 설계'에 맞춘 방식이다.
//                           //왜냐하면, '테이블의 외래키를 자바 객체에 그대로 가져왔고',
//                           //         '객체 그래프 탐색이 불가능'하며,
//                           //         '참조가 없으므로 UML도 잘못됨'.


    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;









}
