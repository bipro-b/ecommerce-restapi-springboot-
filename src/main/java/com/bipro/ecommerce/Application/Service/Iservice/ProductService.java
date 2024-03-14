package com.bipro.ecommerce.Application.Service.Iservice;

import com.bipro.ecommerce.Application.Dto.ProductDto;


import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto productDto);
    List<ProductDto> getAllProducts();

    ProductDto updateProduct(Long productId, ProductDto updatedProduct);
}
