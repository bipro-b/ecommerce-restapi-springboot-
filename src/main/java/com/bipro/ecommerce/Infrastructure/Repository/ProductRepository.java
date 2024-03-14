package com.bipro.ecommerce.Infrastructure.Repository;

import com.bipro.ecommerce.Domain.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
