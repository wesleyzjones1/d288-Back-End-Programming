package com.d288.Vacation.services;

import com.d288.Vacation.dao.CartItemRepository;
import com.d288.Vacation.dao.CartRepository;
import com.d288.Vacation.dao.CustomerRepository;
import com.d288.Vacation.entities.Cart;
import com.d288.Vacation.entities.CartItem;
import com.d288.Vacation.entities.Customer;
import com.d288.Vacation.entities.StatusType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    public CheckoutServiceImpl(CartRepository cartRepository, CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Transactional
    @Override
    public PurchaseResponse placeOrder(Purchase purchase) {

        Cart cart = purchase.getCart();
        Set<CartItem> cartItems = purchase.getCartItems();


        String orderTrackingNumber = UUID.randomUUID().toString();
        cart.setOrderTrackingNumber(orderTrackingNumber);
        cart.setStatus(StatusType.ordered);
        cartItems.forEach(cartItem -> {
            cart.add(cartItem);
            cartItem.setCart(cart);
        });
        cartRepository.save(cart);

        return new PurchaseResponse(orderTrackingNumber);
    }
}