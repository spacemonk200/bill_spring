package com.example.electricitybill.service;

import org.springframework.stereotype.Service;

@Service
public class ElectricityBillService {
    public double calculateBill(int units) {
        double totalBill = 0;

        if (units <= 50) {
            totalBill = units * 3.50;
        } else if (units <= 150) {
            totalBill = 50 * 3.50 + (units - 50) * 4.00;
        } else if (units <= 250) {
            totalBill = 50 * 3.50 + 100 * 4.00 + (units - 150) * 5.20;
        } else {
            totalBill = 50 * 3.50 + 100 * 4.00 + 100 * 5.20 + (units - 250) * 6.50;
        }

        return totalBill;
    }
}
