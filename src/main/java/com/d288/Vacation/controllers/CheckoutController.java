package com.d288.Vacation.controllers;

import com.d288.Vacation.services.CheckoutService;
import com.d288.Vacation.services.Purchase;
import com.d288.Vacation.services.PurchaseResponse;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private CheckoutService checkout;
    public CheckoutController(CheckoutService checkout) {
        this.checkout = checkout;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase){
        PurchaseResponse purchaseResponse = checkout.placeOrder(purchase);
        return purchaseResponse;
    }
}
