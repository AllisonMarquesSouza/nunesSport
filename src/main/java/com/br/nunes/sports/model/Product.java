package com.br.nunes.sports.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name_product")
    private String nameProduct;

    @Column(name = "code_product")
    private String codeProduct;

    @Column(name = "desc_product")
    private String descProduct;

    @Column(name = "price_product")
    private BigDecimal priceProduct;


}
