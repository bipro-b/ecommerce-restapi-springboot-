package com.bipro.ecommerce.Application.Service.ImplemetationService;

import com.bipro.ecommerce.Application.Dto.ProductDto;
import com.bipro.ecommerce.Application.Mapper.ProductMapper;
import com.bipro.ecommerce.Application.Service.Iservice.ProductService;
import com.bipro.ecommerce.Domain.Entity.Product;
import com.bipro.ecommerce.Infrastructure.Repository.ProductRepository;

public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;
    @Override
    public ProductDto createProduct(ProductDto productDto) {

        Product product = ProductMapper.mapToProduct(productDto);
        Product savedProduct = productRepository.save(product);
        return ProductMapper.mapToProductDto(savedProduct);
    }
}
