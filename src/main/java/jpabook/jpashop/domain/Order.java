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

    //< 'Order 객체'와 'Member 객체' 간의 '연관관계 매핑' >
    //일단, 가급적 '단방향 매핑'을 제대로 해둔다! 이것만으로 '개체 설계'는 많이 됨.
    @ManyToOne //'주문(Order) 객체'와 '회원(Member) 객체'의 관계 = N : 1
    @JoinColumn(name = "MEMBER_ID") //'Order 객체의 필드 member(= 'Member 객체의 필드 id')'는
                                    //'테이블 MEMBER의 컬럼 MEMBER_ID'에 대응된다!
    private Member member; //'Order 객체의 필드 member'. FK = 'Member 객체의 필드 id'. PK
                           //'Order 객체'의 입장에서는, '어떤 Member가 주문했는지' '그 Member ID'에 대한 정보가 필요함.
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
