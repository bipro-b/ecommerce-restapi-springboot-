package com.bipro.ecommerce.Presentation.Controller;


import com.bipro.ecommerce.Application.Dto.ProductDto;
import com.bipro.ecommerce.Application.Service.Iservice.ProductService;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/products")
public class ProductController {
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<ProductDto>createProduct(@RequestBody ProductDto productDto){

        ProductDto res = productService.createProduct(productDto);
        return new ResponseEntity<>(res, HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        List<ProductDto> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    // update price

   @PatchMapping("{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("id") Long productId,@RequestBody ProductDto updatedProduct){

    ProductDto productUpdated = productService.updateProduct(productId,updatedProduct);
    return ResponseEntity.ok(productUpdated);
    }


    // delete
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long productId){
        productService.deleteProduct(productId);
        return ResponseEntity.ok("Deleted product successfully.");
    }
}
