package com.active.test.service;

import com.active.test.domain.*;
import com.active.test.rest.BillRequest;
import com.active.test.rest.BillResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.Duration;

@Service public class BillingService {

    private static final String MOTO = "MOTO";
    private static final String CAR  = "CAR";

    /**
     * main method manque tout les condition de validation de la reqete
     *
     * @param billRequest {@link BillRequest}
     * @return
     * @throws NoSuchMethodException
     */
    public BillResponse<VehicleType> bill(BillRequest billRequest) throws NoSuchMethodException {

        if (billRequest != null && billRequest.getType() != null) {
            Vehicle<? extends VehicleType> vehicle = null;
            if (billRequest.getType().equals(CAR)) {
                final Car car = new Car();
                vehicle = new Vehicle<>(car);

            }

            if (billRequest.getType().equals(MOTO)) {
                final Moto moto = new Moto();
                vehicle = new Vehicle<>(moto);

            }

            final BigDecimal time = this.computeTime(billRequest);
            assert vehicle != null;

            final BigDecimal price = this.computePrice(time, vehicle);
            return this.buildResponse(time, price, vehicle);

        }

        return null;
    }

    /**
     *
     * @param time
     * @param price
     * @param vehicle
     * @return
     */
    protected BillResponse<VehicleType> buildResponse(BigDecimal time, BigDecimal price, Vehicle<?> vehicle) {
        // triche un peu
        return BillResponse.builder().vehiclesType(vehicle.getType()).price(price.longValue()).energy("essence")
                .pastTime(time.toString()).build();

    }

    /**
     * @param billRequest
     * @return
     */
    protected BigDecimal computeTime(BillRequest billRequest) {

        Duration period = Duration.between(billRequest.getStart(), billRequest.getEnd());
        return new BigDecimal(period.toMinutes());

    }

    /**
     * @param time
     * @param vehicle
     * @return
     * @throws NoSuchMethodException
     */
    protected BigDecimal computePrice(BigDecimal time, Vehicle<? extends VehicleType> vehicle)
            throws NoSuchMethodException {

        BigDecimal price = BigDecimal.ZERO;

        BigDecimal priceByHour = new Pricing<>(vehicle.getType(), false).getPriceByMinute();
        if (time.compareTo(new BigDecimal(60)) <= 0) {
            return new BigDecimal(0);

        }

        if (time.compareTo(new BigDecimal(60 * 4)) <= 0) {

            price = priceByHour.multiply(time);

        }

        if (time.compareTo(new BigDecimal(60 * 4)) > 0) {

            throw new NoSuchMethodException("cas non gére");
        }

        MathContext m = new MathContext(4); // 4 precision
        BigDecimal bigDecimal = price.round(m).stripTrailingZeros();
        final BigDecimal remainder = bigDecimal.remainder(new BigDecimal(1));
        if (BigDecimal.ZERO.compareTo(remainder) != 0) {
            bigDecimal = bigDecimal.setScale(0, RoundingMode.DOWN);
            bigDecimal = bigDecimal.add(BigDecimal.valueOf(0.5));
        }

        return bigDecimal;
    }

}
