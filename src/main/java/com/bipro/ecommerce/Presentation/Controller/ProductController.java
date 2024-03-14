package com.bipro.ecommerce.Presentation.Controller;


import com.bipro.ecommerce.Application.Dto.ProductDto;
import com.bipro.ecommerce.Application.Service.Iservice.ProductService;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("api/products")
public class ProductController {
    private ProductService productService;

    public ResponseEntity<ProductDto>createProduct(@RequestBody ProductDto productDto){

        ProductDto res = productService.createProduct(productDto);
        return new ResponseEntity<>(res, HttpStatus.OK);

    }

}