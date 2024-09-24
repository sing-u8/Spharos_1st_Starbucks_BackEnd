package TRaMis8khae.starbucks.cart.entity;

import jakarta.persistence.*;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String memberUUID;

    @Column(nullable = false)
    private String productUUID;

    private Integer count;

    private Boolean checked;

    private Boolean deleted;

    private Boolean additionalChecked;

    private Long productOptionId;

    private Integer quantity; //상품 옵션 리스트 수량

    private String engravingText;

    //sql sum 으로 장바구니 최대 수량

}