package com.bipro.ecommerce.Application.Service.ImplemetationService;

import com.bipro.ecommerce.Application.Dto.ProductDto;
import com.bipro.ecommerce.Application.Exception.ResourceNotFoundException;
import com.bipro.ecommerce.Application.Mapper.ProductMapper;
import com.bipro.ecommerce.Application.Service.Iservice.ProductService;
import com.bipro.ecommerce.Domain.Entity.Product;
import com.bipro.ecommerce.Infrastructure.Repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;
    @Override
    public ProductDto createProduct(ProductDto productDto) {

        Product product = ProductMapper.mapToProduct(productDto);
        Product savedProduct = productRepository.save(product);
        return ProductMapper.mapToProductDto(savedProduct);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map((product)->
                ProductMapper.mapToProductDto(product))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto updateProduct(Long productId, ProductDto updatedProduct) {

        Product product = productRepository.findById(productId).orElseThrow(
                ()-> new ResourceNotFoundException("Id is not valid")
        );

        product.setPrice(updatedProduct.getPrice());

        Product updatedPrice = productRepository.save(product);

        return ProductMapper.mapToProductDto(updatedPrice);

    }

    @Override
    public void deleteProduct(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(
                ()-> new ResourceNotFoundException("Invalid id")
        );

        productRepository.deleteById(productId);

    }
}
