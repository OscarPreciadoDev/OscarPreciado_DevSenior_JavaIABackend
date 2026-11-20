package com.devSenior.campusFlow.pagos.config;

import com.stripe.StripeClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StripeConfig {

    @Value("${stripe.secret-key}")
    private String secretKey;

    // Objeto que representa la conexión con Stripe, todo lo que se pida a Stripe pasa por aca!!
    @Bean
    public StripeClient stripeClient() {
        return new StripeClient(secretKey);
    }
}