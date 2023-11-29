package com.example.electricitybill.controller;

import com.example.electricitybill.model.ElectricityBill;
import com.example.electricitybill.service.ElectricityBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ElectricityBillController {

    @Autowired
    private ElectricityBillService electricityBillService;

    @GetMapping("/")
    public String showCalculatorForm(Model model) {
        model.addAttribute("electricityBill", new ElectricityBill());
        return "index";
    }

    @PostMapping("/calculate")
    public String calculateBill(ElectricityBill electricityBill, Model model) {
        double totalBill = electricityBillService.calculateBill(electricityBill.getUnits());
        model.addAttribute("totalBill", totalBill);
        return "result";
    }
}
