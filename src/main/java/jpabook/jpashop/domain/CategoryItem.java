package jpabook.jpashop.domain;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class CategoryItem {

    private Long id;



    //========================================================================================================

    //[ 'Category 객체(N)'와 'Delivery 객체(M)' 간의 N : M 관계를 풀어주기 위한 '연결 테이블 'CATEGORY_ITEM' ]

    //< 'CategoryItem 객체의 필드 category'와 'Category 객체의 필드 id(1)' 간의 'N : 1 단방향' 매핑 >
    //- '주인(N : M 일 때 기준으로)'이 'CategoryItem 객체의 필드 category(='Category 객체의 필드 id')'인 경우
    @ManyToOne
    @JoinColumn(name = CATEGORY_ID) //'현재 테이블 CATEGORY_ITEM의 FK인 필드 category(='Catgory 객체의 필드 id')'는
                                    //'주인이 아닌 테이블 CATEGORY의 PK인 컬럼 CATEGORY_ID'에 대응된다!
    private Category category; //='Cateogry 객체의 필드 id'



    //< 'CategoryItem 객체의 필드 item(N)'과 'Item 객체의 필드 id(1) 간의 'N : 1 단방향' 매핑 >
    //- '주인(N: M 일 때 기준으로)'이 'CategoryItem 객체의 필드 item(='Item 객체의 필드 id')'인 경우
    @ManyToOne
    @JoinColumn(name = ITEM_ID) //'현재 테이블 CATEGORY_ITEM의 FK인 필드 item(='Item 객체의 필드 id')'은
                                //'주인이 아닌 테이블 ITEM의 PK인 컬럼 ITEM_ID'에 대응된다!
    private Item item; //='Item 객체의 핃드 id'

    //========================================================================================================



}
