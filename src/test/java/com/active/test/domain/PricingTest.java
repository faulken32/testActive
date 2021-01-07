package com.active.test.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class PricingTest {

    @Test void getPriceByMinute() throws NoSuchMethodException {
        final Vehicle<Car> carVehicle = new Vehicle<>(new Car());

        final Pricing<Car> carPricing = new Pricing<>(carVehicle.getType(), false);

        final BigDecimal priceByMinute = carPricing.getPriceByMinute();


    }
}
