package org.product.productservice.services.PaymentGateway;

import com.stripe.exception.StripeException;

public interface PaymentGateway {
    String createPaymentLink(Long orderId , long amount) throws StripeException;
}
