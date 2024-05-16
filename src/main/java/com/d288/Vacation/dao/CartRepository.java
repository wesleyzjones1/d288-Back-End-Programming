package com.d288.Vacation.dao;

import com.d288.Vacation.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface CartRepository extends JpaRepository<Cart, Long> {
}
