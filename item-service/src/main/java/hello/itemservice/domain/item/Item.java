package hello.itemservice.domain.item;

import lombok.Getter;
import lombok.Setter;

//@Data는 위험함

@Getter
@Setter
public class Item {

    private Long id;
    private String itemName;
    private Integer price; // Integer 쓰는 이유 : price가 안 들어갈 수도 있으니(null)
    private Integer quantity;

    // 기본 생성자
    public Item() {

    }

    // id 제외 생성자
    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
