package com.active.test.service;

import com.active.test.domain.Car;
import com.active.test.domain.Vehicle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;


import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BillingServiceTest {

    @Autowired
    private BillingService billingService;

    @Test void bill() {
    }

    @Test void computePrice_Gratis() throws NoSuchMethodException {

        final Vehicle<Car> carVehicle = new Vehicle<>(new Car());


        final BigDecimal bigDecimal = this.billingService.computePrice(new BigDecimal(50), carVehicle);
        assertEquals(BigDecimal.ZERO , bigDecimal);


    }

    @Test void computePrice_Normal() throws NoSuchMethodException {

        final Vehicle<Car> carVehicle = new Vehicle<>(new Car());

        final BigDecimal bigDecimal1 = this.billingService.computePrice(new BigDecimal(120), carVehicle);


        assertEquals(new BigDecimal(4) , bigDecimal1);



    }


    @Test void computePrice_Normal2() throws NoSuchMethodException {

        final Vehicle<Car> carVehicle = new Vehicle<>(new Car());

        final BigDecimal bigDecimal1 = this.billingService.computePrice(new BigDecimal(121), carVehicle);


        assertEquals(new BigDecimal(4.5) , bigDecimal1);



    }

    @Test void computePrice_Normal3() throws NoSuchMethodException {

        final Vehicle<Car> carVehicle = new Vehicle<>(new Car());

        final BigDecimal bigDecimal1 = this.billingService.computePrice(new BigDecimal(180), carVehicle);


        assertEquals(new BigDecimal(6) , bigDecimal1);

    }


    @Test void computePrice_Normal4() throws NoSuchMethodException {

        final Vehicle<Car> carVehicle = new Vehicle<>(new Car());

        final BigDecimal bigDecimal1 = this.billingService.computePrice(new BigDecimal(182), carVehicle);


        assertEquals(new BigDecimal(6.5) , bigDecimal1);

    }




}
