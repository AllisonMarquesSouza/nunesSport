package com.br.nunes.sports.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class ProductDtoUpdate {
    @NotNull(message = "Code product can't be or null")
    private UUID codeProduct;

    @NotBlank(message = "Name product can't be empty or null")
    private String nameProduct;

    @NotBlank(message = "Description product can't be empty or null")
    private String descProduct;

    @NotNull(message = "Price product can't be null")
    private BigDecimal priceProduct;

}
