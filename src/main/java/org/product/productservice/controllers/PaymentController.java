package org.product.productservice.controllers;


import org.product.productservice.services.PaymentServiceLocal.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {


    @Autowired
    private PaymentService paymentService;

    @GetMapping("/createPaymentLink")
    public String createPaymentLink() throws Exception {
        return paymentService.createPaymentLink(5);
    }
}
