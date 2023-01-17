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



//====================================================================================================================


    //[ '임베디드 타입'강 05:00~ ]: 정말 긍정적으로 '객체지향적인 방식'이라서 강력추천!
    //                           'Delivery 엔티티'가 더욱 '객체지향적'이고, '응집력 있게' 되었다.
    //- 즉, '새로운 클래스 Address'를 '생성하고', '그 새로운 클래스 Address' 안에 원래라면 저렇게 지저분하게 많이 있어햐 하는
    // 아래 주석 처리한 세 필드들(city, street, zipcode)을 넣기.
    //  그리고, 아래 세 필드들을 대신하여, 아래에 '필드 Address'를 대신 사용하는 것임.
    //- 그 후, '저 클래스 Address 위에는' '@Embeddable'을 쓰거나, 또는
    //- 이 아래 'Delivery 객체의 필드 Address 위에는' '@Embedded'를 작성하거나 둘 중 하나만 하거나, 둘 다 작성해도 된다.
//    private String city;
//    private String street;
//    private String zipcode;
    @Embedded
    private Address address;


//====================================================================================================================



    //< 'Order 객체의 필드 member(N)'와 Member 객체의 필드 orders(1)' 간의 'N : 1 양방향 연관관계 매핑': 주문내역'목록'ID >
    //- '주인'이 'Order 객체의 필드 member'인 경우
    @OneToMany(mappedBy = "member") //- '회원(Member) 객체'와 '주문(Order) 객체'와의 관계 = 1 : N
    //- '반대편 연관관계이자 주인'인 'Order 객체의 필드 member'와 '양방향 매핑'되어있다 라는 뜻
    //- '양방향 매핑의 주인인 Order 객체의 필드 member'의 위에 어노테이션으로는
    // 'mappedBy'에 사용될 수 없기에
    //  '그 반대편 연관관계 매핑'의 대상인 이 '필드 orders'의 위에 'member'가 'mappedBy' 되는 것이다!
    private List<Order> orders = new ArrayList<Order>(); //'new ArrayList<>();'로 해도 됨.
    //- 'Member 객체의 필드 orders' = 'Order 객체의 필드 orderItems'
    //- 'Order 객체'가 '외래키(필드 member)를 가지고 있기에', '외래키 소유객체인 Order 객체의 필드 member'가
    //  이 '양방향 매핑의 주인'이다.
    //- 'Member 객체'의 입장에서는, '어떤 주문내역목록이 주문되었는지' '그 orders ID'에 대한 정보가 필요함.
    //  즉, 'orders ID'가 필요하고, 여기서의 '필드 orders'가 바로 그 'orders ID'임.
//Q: '@OneToMany'에서는 '@JoinColumn'을 사용하지 않는 이유?
//A: '다대 일(N:1) 연관관계'에서는 '연관관계의 주인'을 설정해주어야 함.
//   일반적으로 '다(N)' 쪽이 '연관관계의 주인'임.
//   그래서, '다(N)' 쪽에 '@JoinColumn'을 통해 '해당 다(N)인 개체 속의 외래키 컬럼'을 매핑시킴(넣음)
//   이 때, '일(1) 쪽의 연관관계의 주인'은 '다(N)'이고, '일(1)'은 '다(N)에 의해 매핑된 필드'라는 것을 명시하는 것이
//   바로 'mappedBy'임
//   따라서, '일(1)' 쪽에 '@OneToMany'를 사용하고, 그러므로 '일(1)' 쪽에는 '@JoinColumn'을 사용할 수 없는 것임.


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}