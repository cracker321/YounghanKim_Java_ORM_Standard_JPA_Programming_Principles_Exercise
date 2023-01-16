package jpabook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID")
    private Long id;

    private String name; //카테고리명


    //=========================================================================================================
    //< 셀프 연관관계 > : 웹페이지에서 카테고리가 아래로 쭉~ 내려가지는데, 그것을 셀프로 하는 것. 이것은 이 강의의 핵심이 아님
    @ManyToOne(fetch = FetchType.LAZY) //'@OneToOne'과 '@ManyToOne'에는 반드시 '지연로딩'으로 일일히 설정해줘야 한다!
                                       //왜냐하면, 위 두 개는 JPA 기본설정이 '즉시로딩'으로 되어있기 때문!
                                       //cf) 'fetch =...' 작성 후에 'alt + enter' 누르고,
                                       //'add on demand static import for...'누르면, 더 축약되어 깔끔하게 써진다!
    @JoinColumn(name = "PARENT_ID")
    private Category parent; //상위 카테고리

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();
    //=========================================================================================================



}
