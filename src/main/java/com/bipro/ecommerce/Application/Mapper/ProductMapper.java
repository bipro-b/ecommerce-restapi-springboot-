package com.bipro.ecommerce.Application.Mapper;

import com.bipro.ecommerce.Application.Dto.ProductDto;
import com.bipro.ecommerce.Domain.Entity.Product;
import com.bipro.ecommerce.Domain.Entity.User;

public class ProductMapper {
    public static ProductDto mapToProductDto(Product product){
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getIsAvailable()
        );
    }

    public static Product mapToProduct(ProductDto productDto){
        return new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getDescription(),
                productDto.getPrice(),
                productDto.getIsAvailable()
        );
    }
}
