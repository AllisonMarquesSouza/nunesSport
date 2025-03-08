package com.br.nunes.sports.model;

import com.br.nunes.sports.dtos.ProductDtoCreate;
import com.br.nunes.sports.dtos.ProductDtoUpdate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "code_product")
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    private UUID codeProduct;

    @Column(name = "name_product")
    private String nameProduct;

    @Column(name = "desc_product")
    private String descProduct;

    @Column(name = "price_product")
    private BigDecimal priceProduct;


    public Product(ProductDtoCreate productDtoCreate) {
        this.nameProduct = productDtoCreate.getNameProduct();
        this.descProduct = productDtoCreate.getDescProduct();
        this.priceProduct = productDtoCreate.getPriceProduct();
    }
    public Product(ProductDtoUpdate productDtoUpdate) {
        this.codeProduct = productDtoUpdate.getCodeProduct();
        this.nameProduct = productDtoUpdate.getNameProduct();
        this.descProduct = productDtoUpdate.getDescProduct();
        this.priceProduct = productDtoUpdate.getPriceProduct();
    }
}
