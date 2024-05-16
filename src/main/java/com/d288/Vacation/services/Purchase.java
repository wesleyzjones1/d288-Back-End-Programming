package com.d288.Vacation.services;

import com.d288.Vacation.entities.Cart ;
import com.d288.Vacation.entities.CartItem;
import com.d288.Vacation.entities.Customer;
import lombok.Getter;
import lombok.Setter;
import lombok.Data;

import java.util.Set;

@Getter
@Setter

@Data
public class Purchase {

    private Customer customer;
    private Cart cart;
    private Set<CartItem> cartItems;
}