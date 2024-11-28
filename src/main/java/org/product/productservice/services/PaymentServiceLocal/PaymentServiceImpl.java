package org.product.productservice.services.PaymentServiceLocal;

import org.product.productservice.services.PaymentGateway.PaymentGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private  PaymentGateway paymentGateway;

    @Override
    public String createPaymentLink(long orderId) throws Exception {
        return paymentGateway.createPaymentLink(orderId,1000);
    }
}
