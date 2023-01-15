package jpabook.jpashop.domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@DiscriminatorColumn(name = "DTYPE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity
public class Item {


    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID")
    private  Long id;
    private String name;
    private int price;
    private int stockQuantity;


    @OneToMany(mappedBy = "item")
    private List<CategoryItem> categoryItems = new ArrayList<>();



//==================================================================================================================

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
