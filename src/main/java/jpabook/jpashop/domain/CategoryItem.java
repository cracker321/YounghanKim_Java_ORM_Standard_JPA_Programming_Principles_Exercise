package jpabook.jpashop.domain;

import javax.persistence.*;


@Entity
public class CategoryItem {

    @Id
    @GeneratedValue
    @Column(name = "CATEGORY_ITEM_ID")
    private Long id;



    //========================================================================================================

    //[ 'Category 객체(N)'와 'Delivery 객체(M)' 간의 N : M 관계를 풀어주기 위한 '연결 테이블 'CATEGORY_ITEM' ]

    //< 'CategoryItem 객체의 필드 category'와 'Category 객체의 필드 id(1)' 간의 'N : 1 단방향' 매핑 >
    //- '주인(N : M 일 때 기준으로)'이 'CategoryItem 객체의 필드 category(='Category 객체의 필드 id')'인 경우
    @ManyToOne(fetch = FetchType.LAZY)  //'@OneToOne'과 '@ManyToOne'에는 반드시 '지연로딩'으로 일일히 설정해줘야 한다!
                                        //왜냐하면, 위 두 개는 JPA 기본설정이 '즉시로딩'으로 되어있기 때문!
                                        //cf) 'fetch =...' 작성 후에 'alt + enter' 누르고,
                                        //'add on demand static import for...'누르면, 더 축약되어 깔끔하게 써진다!
    @JoinColumn(name = "CATEGORY_ID") //'현재 테이블 CATEGORY_ITEM의 FK인 필드 category(='Catgory 객체의 필드 id')'는
                                      //'주인이 아닌 테이블 CATEGORY의 PK인 컬럼 CATEGORY_ID'에 대응된다!
    private Category category; //='Cateogry 객체의 필드 id'



    //< 'CategoryItem 객체의 필드 item(N)'과 'Item 객체의 필드 id(1) 간의 'N : 1 단방향' 매핑 >
    //- '주인(N: M 일 때 기준으로)'이 'CategoryItem 객체의 필드 item(='Item 객체의 필드 id')'인 경우
    @ManyToOne(fetch = FetchType.LAZY) //'@OneToOne'과 '@ManyToOne'에는 반드시 '지연로딩'으로 일일히 설정해줘야 한다!
                                       //왜냐하면, 위 두 개는 JPA 기본설정이 '즉시로딩'으로 되어있기 때문!
                                       //cf) 'fetch =...' 작성 후에 'alt + enter' 누르고,
                                       //'add on demand static import for...'누르면, 더 축약되어 깔끔하게 써진다!
    @JoinColumn(name = "ITEM_ID") //'현재 테이블 CATEGORY_ITEM의 FK인 필드 item(='Item 객체의 필드 id')'은
                                  //'주인이 아닌 테이블 ITEM의 PK인 컬럼 ITEM_ID'에 대응된다!
    private Item item; //='Item 객체의 핃드 id'

    //========================================================================================================



}
