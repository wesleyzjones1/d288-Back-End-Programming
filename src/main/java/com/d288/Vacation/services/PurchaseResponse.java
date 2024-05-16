package com.d288.Vacation.services;

import lombok.Data;

@Data
public class PurchaseResponse {
    private String orderTrackingNumber;

    public PurchaseResponse(String orderTrackingNumber) {
        this.orderTrackingNumber = orderTrackingNumber;
    }
}