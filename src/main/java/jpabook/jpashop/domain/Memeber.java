package jpabook.jpashop.domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(length = 10) //10자를 넘으면 안됨. '자바 객체의 필드들'에는 이거 다 추가해주기!
    private String name;
    private String city;
    private String street;
    private String zipcode;


    //< 'Member 객체의 필드 orders'와 'Order 객체의 필드 member' 간의 '양방향 연관관계 매핑': 주문내역'목록'ID >
    @OneToMany(mappedBy = "member") //- '회원(Member) 객체'와 '주문(Order) 객체'와의 관계 = 1 : N
                                    //- '반대편 연관관계'인 'Order 객체의 필드 member'와 '양방향 매핑'되어있다 라는 뜻
                                    //- '양방향 매핑의 주인인 Order 객체'의 '필드 member'는 'mappedBy'에 사용될 수 없기에
                                    //  '그 반대편 연관관계 매핑'의 대상인 'member'가 'mappedBy' 되는 것이다!
    private List<Order> orders = new ArrayList<Order>(); //'new ArrayList<>();'로 해도 됨.
                            //- 'Member 객체의 필드 orders' = 'Order 객체의 필드 orderItems'
                            //- 'Order 객체'가 '외래키를 가지고 있기에', '외래키의 관리자인 객체'.
                            //따라서, '양방향 연관관계의 주인'은 'Order 객체'
                            //- 'Member 객체'의 입장에서는, '어떤 주문내역목록이 주문되었는지' '그 orders ID'에 대한 정보가 필요함.
                            //즉, 'orders ID'가 필요하고, 여기서의 '필드 orders'가 바로 그 'orders ID'임.


}
