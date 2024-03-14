package com.bipro.ecommerce.Application.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Boolean isAvailable;
}
