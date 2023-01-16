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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID")
    private Category parent; //상위 카테고리

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();
    //=========================================================================================================



}
