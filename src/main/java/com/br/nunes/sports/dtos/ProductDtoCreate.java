package com.br.nunes.sports.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class ProductDtoCreate {

    @NotBlank(message = "Name product can't be empty or null")
    private String nameProduct;

    @NotBlank(message = "Description product can't be empty or null")
    private String descProduct;

    @NotNull(message = "Price product can't be null")
    private BigDecimal priceProduct;

}
