package org.product.productservice.services.PaymentGateway;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentLink;
import com.stripe.param.PaymentLinkCreateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class StripeGatewayImpl implements PaymentGateway{

    @Value("${stripe.secret.key}")
    private String stripeSecretKey;

    @Override
    public String createPaymentLink(Long orderId, long amount) throws StripeException {
        Stripe.apiKey = stripeSecretKey;


        PaymentLinkCreateParams params =
                PaymentLinkCreateParams.builder()
                        .addLineItem(
                                PaymentLinkCreateParams.LineItem.builder()
                                        .setPrice("price_1Q0xrmCOG4fd3vWerWAvnBVa")
                                        .setQuantity(1L)
                                        .build()
                        )
                        .setAfterCompletion(PaymentLinkCreateParams.AfterCompletion.builder()
                                .setType(PaymentLinkCreateParams.AfterCompletion.Type.REDIRECT)
                                .setRedirect(
                                        PaymentLinkCreateParams.AfterCompletion.Redirect.builder()
                                                .setUrl("https://scaler.com")
                                                .build()
                                ).build()
                        )
                        .build();
        /*
        {
            "line_items": [{
                    "price": "price_1Pzhi5LQWjpPGvlgfSCN3C72",
                    "qty": 1
                }
            ],
            "after_completion": {
                "type": "redirect",
                "redirect": {
                    "url": "https://scaler.com"
                }
            }
        }

         */

        PaymentLink paymentLink = PaymentLink.create(params);

        return paymentLink.getUrl();

    }
}
