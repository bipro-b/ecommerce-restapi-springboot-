package com.bipro.ecommerce.Infrastructure.Repository;

import com.bipro.ecommerce.Domain.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);

}
